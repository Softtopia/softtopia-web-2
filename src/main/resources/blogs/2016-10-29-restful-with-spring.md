# APIs RESTFul con Spring 4


La "World Wide Web" se está convirtiendo cada vez más en un mundo de información distribuida integrada. De las muchas tecnologías que existen para desarrollar servicios, parece que RESTFul se está convirtiendo en un estándar de facto, muy difícil de no tener en cuenta.

## ¿ Por qué RESTFul ?

REST (Representational State Transfer) es la definición de una [arquitectura para diseñar sistemas distribuidos]((http://www.ics.uci.edu/~fielding/pubs/dissertation/top.htm). 
No existe ningún estándar oficial para REST pero al ser concebida utilizando las tecnologías y mecanismos nativos de la web es la que mejor se integra.

REST se caracteriza por: 
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

