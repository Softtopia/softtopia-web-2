# APIs RESTFul con Spring 4


La "World Wide Web" se está convirtiendo cada vez más en un mundo de información distribuida integrada. De las muchas tecnologías que existen para desarrollar servicios, parece que RESTFul se está convirtiendo en un estándar de facto, muy difícil de no tener en cuenta.

## ¿ Por qué RESTFul ?

REST (Representational State Transfer) es la definición de una [arquitectura para diseñar sistemas distribuidos](http://www.ics.uci.edu/~fielding/pubs/dissertation/top.htm). 
No existe ningún estándar oficial para REST pero al ser concebida utilizando las tecnologías y mecanismos nativos de la web es la que mejor se integra.

**REST** se caracteriza por: 

* **Stateless** El servidor no almacena el estado del cliente entre las peticiones.
* Todo se puede representar como recursos identificados por **URIs**
* No restringe ninguna representación específica para los objetos que transferimos, pueden ser representados **JSON**, XML, etc...
* Utiliza HTTP i puede usar sus métodos (GET, POST, PUT, DELETE, ...) y valores de retorno de forma explícita.

> "Almost anything can be modeled as a resource and then made available for manipulation over the network" (REST in Practice)

A las APIs implementadas usando los servicios de REST les llamamos APIs **RESTFul**

## Niveles de RESTFul

El Dr. Leonar Richardson definió 4 niveles de conformidad para los principios RESTFul.

![](http://martinfowler.com/articles/images/richardsonMaturityModel/overview.png)

* **Nivel 0** Solo utilizamos HTTP como transporte. 
* **Nivel 1** Recursos - Utilizamos URIs para distinguir entre las distintas entidades. Por ejemplo: /documentos/1234
* **Nivel 2** HTTP Verbs - Utilizamos los verbos HTTP como PUT, GET, DELETE, POST para definir los distintos tipos de operaciones en los recursos.
* **Nivel 3** Hipermedia Controls - El llamado [HATEOAS](https://en.wikipedia.org/wiki/HATEOAS) "Hypermedia as the Engine of Application State". El servicio puede responder preguntas referentes a qué peticiones hay que hacer i cuando.

## Definición de Recursos en Spring 
Vamos a utilizar el Nivel 2 de RESTFul para implementar una API de ejemplo en Spring 4. Usaremos el recurso **Documentos** y implementaremos 4 operaciones: Create, Read, Update, Delete (CRUD).

```
@RestController
@RequestMapping(path = "/api/v1/documents", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class DocumentResource {
```

Anotamos la definición de la clase con @RestController indicando el "RootPath" o ruta raíz como **/api/v1/documents** y el tipo de datos que produciremos por defecto.

### Verbos en HTTP

#### Post (Create)

El verbo **POST** indica que realizar alguna operación con el recurso que indica la URI. Normalmente se utiliza **POST** para la creación de un nuevo recurso. Pero también lo podemos utilizar para actualizarlo.

![image](https://cloud.githubusercontent.com/assets/4984031/19948076/2b1b2146-a14b-11e6-90d9-a9bc5e93ce5f.png)


```java
@RequestMapping(method = RequestMethod.POST)
public ResponseEntity<?> add(@RequestBody Document document) {

   if (document != null)
   {
      Document result = documentService.add(document);
      HttpHeaders httpHeaders = new HttpHeaders();
      httpHeaders.setLocation(ServletUriComponentsBuilder
         .fromCurrentRequest().path("/{id}")
         .buildAndExpand(result.getId()).toUri());
      return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
   }
   else
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
}
```

Valores de retorno (Response codes) para POST: 

* **201 Created**: Si la llamada al método ha creado un recurso y lo ha hecho correctamente. En este caso a demás en los HttpHeaders añadiremos uno de tipo Location con la URI del recurso creado.
* **400 Bad Request**: En el caso de que el objeto enviado sea incorrecto o no se pueda serializar.
* **500 Internal Server Error**: Si ha ocurrido algún error no recuperable para el servidor. Por ejemplo que no se puede acceder a la base de datos para guardar el recurso. En estos casos el servidor se debería quedar en el mismo estado en el que estaba antes de la llamada a **POST**.

#### PUT (Update/Create)

Se puede usar tanto para actualizar un recurso o para crearlo. Existe una convención para decidir si usar  **PUT** o **POST** : 

* Usamos **POST** cuando no conocemos la URI del recurso que queremos crear o actualizar.
* Usamos **PUT** cuando el cliente conoce la URI del recurso que quiere crear o actualizar.

![image](https://cloud.githubusercontent.com/assets/4984031/19949874/840cb9f0-a154-11e6-8a62-c4e99526524a.png)

```java
@RequestMapping(path = "/{documentId}", method = RequestMethod.PUT)
public ResponseEntity<?> updateDocument(@PathVariable String documentId, @RequestBody Document document) {
    HttpStatus status;
    if (documentService.exists(documentId) ) {
        boolean conflict = documentService.updateDocument(document);
        if (!conflict )
            status = HttpStatus.NO_CONTENT;
        else 
            status = HttpStatus.CONFLICT;
    } else {
        status = HttpStatus.NOT_FOUND;
    }
    return new ResponseEntity<>(status);
}
```

**PUT** se considera idempotente, ya que el estado del cliente es el mismo que el estado del servidor, antes y después de la llamada. El cliente puede repetir la llamada tantas veces como crea necesario. (Ver más abajo)

> Con los verbos **PUT** el servidor entiende que se le mandan los objetos con todos los atributos. Cuando por lo contrario solo mandemos los atributos que queramos actualizar, en lugar de **PUT** usaremos **PATCH**

Los valores de retorno (Response Codes) de **PUT** 

* **200 OK**: En el caso de que nuestra llamada tenga éxito y devolvamos el objeto creado o modificado.
* **204 No Content**: En el caso de que nuestra llamada tenga éxito y no devolvamos el objeto creado o modificado.
* **409 Conflict**: Cuano no se puede actualizar el objeto porque hay una incoherencia en los datos.
* **500 Internal Server Error**: Cuandono se puede actualizar el objeto por algún motivo no conocido por el servidorl.

 

