# Tech Challenge

Este Tech Challenge teve como objetivo desenvolver um sistema para gerenciamento de uma livraria. O foco do projeto é no front-end.

## Sumário

- [Tech Challenge](#tech-challenge)
  - [Sumário](#sumário)
  - [Tecnologias utilizadas](#tecnologias-utilizadas)
    - [Estrutura do repositório](#estrutura-do-repositório)
  - [Modelos de dados](#modelos-de-dados)
  - [Instalação e Configuração](#instalação-e-configuração)
    - [Pré-requisitos](#pré-requisitos)
    - [Como instalar](#como-instalar)

## Tecnologias utilizadas

Para desenvolver esse sistema utilizamos as seguintes tecnologias:

- HTML
- CSS
- JavaScript
- Bootstrap
- React
- NPM

### Estrutura do repositório

A organização do repositório refleta a arquitetura escolhida.

```text
.
├── public
├── src
│   ├── components # Componentes front-end
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── bookstore
│   │   │           └── api
│   │   │               └── model
│   │   └── resources
│   ├── pages # Páginas front-end
│   │   ├── Authors
│   │   ├── Books
│   │   └── Home
│   └── test
│       └── java
│           └── com
│               └── bookstore
│                   └── api
└── target
```

## Modelos de dados

```mermaid
erDiagram
    BOOKS 0--1+ BOOKS_AUTHORS
    AUTHORS 0--1+ BOOKS_AUTHORS

    BOOKS {
        INT id PK
        VARCHAR title
        VARCHAR isbn
        INT published_year
        DECIMAL price
        TIMESTAMP created_at
        TIMESTAMP updated_at
    }

    BOOKS_AUTHORS {
        INT book_id FK
        INT author_id FK
    }

    AUTHORS {
        INT id PK
        VARCHAR name
        DATE birth_date
        VARCHAR nationality
        TIMESTAMP created_at
        TIMESTAMP updated_at
    }
```

## Instalação e Configuração

### Pré-requisitos

- [NodeJs](https://nodejs.org/en/download/)
- [NPM](https://docs.npmjs.com/downloading-and-installing-node-js-and-npm)

### Como instalar

1. Instalar as dependências:

```bash
    npm install
```

2. Iniciar a aplicação:

```bash
    npm run start
```
