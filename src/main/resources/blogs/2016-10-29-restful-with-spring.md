Spring RESTFul howto 

En aquesta guia mostrem quines serien les bones pràctiques alhora d'escriure una API RESTFul amb Spring Web.
## Índex
<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->


- [Per què RESTFul](#per-qu%C3%A8-restful)
- [Nivells de RESTFul](#nivells-de-restful)
- [Definició de recursos](#definici%C3%B3-de-recursos)
  - [Verbs HTTP](#verbs-http)
    - [Post (Create)](#post-create)
    - [Get (Read)](#get-read)
      - [Obtenir una llista de resultats](#obtenir-una-llista-de-resultats)
    - [Put (Update/Create)](#put-updatecreate)
    - [Delete](#delete)
  - [Safe and Idempotency](#safe-and-idempotency)
  - [Tipus de paràmetres als Endpoints](#tipus-de-par%C3%A0metres-als-endpoints)
  - [Altres verbs](#altres-verbs)
  - [Media Types](#media-types)
- [Bones pràctiques](#bones-pr%C3%A0ctiques)
- [Testing](#testing)
  - [Test de CRUD a API de documents](#test-de-crud-a-api-de-documents)
    - [Get](#get)
    - [Post](#post)
    - [Put](#put)
    - [Delete](#delete-1)
- [Documentar la API](#documentar-la-api)
- [Paginació i ordenació [WIP]](#paginaci%C3%B3-i-ordenaci%C3%B3-wip)
- [Control d'errors [WIP]](#control-derrors-wip)
- [Versionat](#versionat)
- [Cache](#cache)
- [Seguretat](#seguretat)
- [Més opcions amb Spring](#m%C3%A9s-opcions-amb-spring)
- [Referències](#refer%C3%A8ncies)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

## Per què RESTFul 

REST (Representational State Transfer) és la definició d'una [arquitectura per a dissenyar sistemes distribuits](http://www.ics.uci.edu/~fielding/pubs/dissertation/top.htm). 
No és un standard però actualment està molt utilitzada ja que al utilitzar mecanismes i tecnologies natives de la web s'hi integra molt bé.
