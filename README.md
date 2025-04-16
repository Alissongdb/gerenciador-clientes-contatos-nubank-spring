# Desafio Nubank - Gerenciamento de Clientes e Contatos

Este projeto foi desenvolvido como parte de um desafio técnico para o Nubank. O objetivo é criar uma API REST que gerencia clientes e seus contatos, utilizando o Spring Boot e PostgreSQL. A API também utiliza a conversão de DTOs (Data Transfer Objects) para entidades, permitindo a criação e listagem de clientes e contatos de forma eficiente sem expor dados sensíveis.

## Tecnologias Utilizadas

- **Spring Boot 3.4.4**: Framework para desenvolvimento rápido de aplicações Java.
- **PostgreSQL**: Banco de dados relacional para armazenar informações de clientes e contatos.
- **JPA (Java Persistence API)**: Para manipulação das entidades no banco de dados.
- **Lombok**: Biblioteca para simplificação de código Java (como getters, setters, construtores, etc).
- **Maven**: Gerenciador de dependências e build.

## Estrutura do Projeto

O projeto é dividido em várias camadas:

- **Controller**: Responsável por expor os endpoints da API e interagir com a camada de serviço para manipulação de dados.
- **Service**: Contém a lógica de negócio da aplicação. A camada de serviço interage com os repositórios para realizar as operações necessárias.
- **Repository**: Interface de persistência de dados utilizando JPA (Java Persistence API). É responsável pela comunicação com o banco de dados.
- **DTO (Data Transfer Object)**: Objetos usados para transferir dados entre as camadas de forma eficiente. Os DTOs ajudam a desacoplar a lógica de persistência da API, permitindo um formato adequado para transporte de dados.
- **Model**: Representação das entidades do banco de dados. São as classes que mapeiam as tabelas do banco de dados. As entidades são usadas pelas camadas de repositório e serviço.
- **Converter**: Classe responsável pela conversão entre os **DTOs** e **Models**. Essa camada é importante para transformar as entidades de banco de dados em objetos de transferência de dados, e vice-versa. Ela facilita a separação das camadas e evita que a lógica de conversão seja repetida nas classes de serviço ou controller.


# Endpoints da API

## Cadastrar Cliente
   
Método: POST

Endpoint: /cliente

Descrição: Cria um novo cliente na plataforma.


## Cadastrar Contato de um Cliente
   
Método: POST

Endpoint: /cliente/contato/{idCliente}

Descrição: Cria um novo contato para um cliente existente, identificado pelo idCliente.


## Listar Todos os Clientes
   
Método: GET

Endpoint: /cliente

Descrição: Retorna a lista de todos os clientes cadastrados na plataforma.


## Listar Contatos de um Cliente
   
Método: GET

Endpoint: /cliente/contato/{id}

Descrição: Retorna a lista de contatos de um cliente específico, identificado pelo id.

# Rodando o Projeto

## Certifique-se de ter o PostgreSQL instalado e configurado.

* Clone o repositório e abra o projeto no seu IDE preferida (IntelliJ IDEA ou outro).

* Configure as credenciais do banco de dados no arquivo application.properties.

## Execute o projeto com o comando:

* mvn spring-boot:run
* Acesse a API através de http://localhost:8080.

