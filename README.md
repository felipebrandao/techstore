# E-Commerce 🛒

Este projeto é um sistema de e-commerce desenvolvido como parte do desafio Tech Challenge. Ele permite aos usuários realizar operações como login, registro, gestão de itens, carrinho de compras e simulação de pagamento.

## Requisitos Técnicos
- Spring Boot
- Spring Security
- Arquitetura de Microsserviços
- Banco de Dados
- Docker

## Instalação e Uso
1. Clone o repositório.
2. Configure as propriedades do banco de dados no arquivo `application.properties`.
3. Execute cada microsserviço separadamente ou utilizando Docker.
4. Acesse a interface do usuário através do navegador.

## Microsserviços
- **Autenticação**
- **Gestão de Itens**
- **Carrinho de Compras**
- **Pagamento**

## Executando com Docker
1. Certifique-se de ter o Docker instalado em seu sistema.
2. Na raiz de cada microsserviço, execute o comando `docker build -t nome-do-servico .` para construir as imagens Docker.
3. Em seguida, execute `docker-compose up` para iniciar todos os microsserviços.
4. Acesse a interface do usuário através do navegador.

---
Feito com ❤️ pelo time Tech Challenge 🚀
