# Versões README

- [Inglês](https://github.com/antonioChristofoletti/guia-bolso-desafio-tecnico/blob/main/readme/readme.en.md)
- ***[Português](https://github.com/antonioChristofoletti/guia-bolso-desafio-tecnico/blob/main/readme/readme.ptbr.md)***

# Guia Bolso Desafio Técnico API

Desafio Técnico do Guia Bolso para avaliar as competências como `DEV Back-End`.

## Objetivo

Desenvolver um `mock API RESTful` de acordo com algumas regras e premissas.

Contrato: 
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

## Figuras

![api](https://user-images.githubusercontent.com/31052642/109580024-b39f0580-7ad8-11eb-99a6-db6c55b57737.gif)

## Tecnologias Utilizadas

- [Heroku](https://www.heroku.com/)
- [Gradle](https://gradle.org/)
- [Kotlin](https://kotlinlang.org/)
  - [Javalin (API RestFull Frame Work)](https://javalin.io/)
  - [JUnit5](https://junit.org/junit5/)
    - [Ktor as Client HTTP Request](https://ktor.io/)

## Setup

- Executar a aplicação localmente por meio de uma `IDE`, executar a `fun main` do arquivo `JavalinAppKt`;
- Por meio do `jar` gerado através do build `java -jar GuiaBolsoDesafioTecnico.jar`;
- Obs.: A aplicação foi configurada para ter o `deploy` no `Heruku`.

## Funcionalidades

A aplicação é um `API mock` para 1 único `end-point` em específico com vários conteúdos relevantes para tal tipo de sistema, tais como:

- Geração de texto aleatório;
- Geração de dados a partir dos `URL params`;
- Tratativas de parâmetros;
- Aplicação autossuficiência sem dependência com bancos de dados;
- Testes unitários.

## Status

Finalizado. Não há indicativos para adequações futuras.

## Contato

Criado por [antonioChristofoletti](https://github.com/antonioChristofoletti) - Sinta-se à vontade para entrar em contato comigo!
