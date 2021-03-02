# Versions README

- ***[English](https://github.com/antonioChristofoletti/guia-bolso-desafio-tecnico/blob/main/readme/readme.en.md)***
- [Portuguese](https://github.com/antonioChristofoletti/guia-bolso-desafio-tecnico/blob/main/readme/readme.ptbr.md)

# Guia Bolso's API Technical Challenging

Guia Bolso's Technical challenging in order to check the abilities and knowledge related with back-end development.

## Purpose

Create a `mock API RESTful` following some rules and premises.

Contract: 
```
[GET] /<id>/transacoes/<ano>/<mes>

Content-type: application/json

[
  {
     "descricao": "string(10, 120)"
     "data": "long(timestamp)"
     "valor": "integer(-9.999.999, 9.999.999)"
  }  
]
```

## Images

![api](https://user-images.githubusercontent.com/31052642/109580024-b39f0580-7ad8-11eb-99a6-db6c55b57737.gif)

## Used Technologies

- [Heroku](https://www.heroku.com/)
- [Gradle](https://gradle.org/)
- [Kotlin](https://kotlinlang.org/)
  - [Javalin (API RestFull Frame Work)](https://javalin.io/)
  - [JUnit5](https://junit.org/junit5/)
    - [Ktor as Client HTTP Request](https://ktor.io/)

## Setup

- Execute the app from an `IDE`, start the `fun main` from file `JavalinAppKt`;
- Through a built `jar`: `java -jar GuiaBolsoDesafioTecnico.jar`;
- Obs.: The system was configured for `deploy` on `Heruku`.

## Features

The applications is an `API mock` with an unique `end-point`, in which It has contents and important points related with this kind of application, such as:

- Random text generator;
- Data generator through `URL params`;
- Parameter handling;
- Standalone application, no need databases.
- Unitary tests.

## Status

Concluded. There is no indicates for futures developments.

## Contact

[My contact](https://github.com/antonioChristofoletti)
