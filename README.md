
# FórumHub API `v1.0.0`

## 📖 Sobre o Projeto

**FórumHub API** é o backend para uma plataforma de fórum de discussões, desenvolvido como parte do desafio de programação Back-End da Alura. O projeto consiste em uma API REST que permite o gerenciamento completo de tópicos, seguindo as melhores práticas de desenvolvimento com uma arquitetura robusta e escalável.

A API implementa um CRUD completo e seguro para tópicos, com um sistema de autenticação de usuários via tokens JWT. O projeto também inclui documentação interativa com Swagger/OpenAPI, facilitando o teste e a integração.

---

## 🚀 Funcionalidades Implementadas

*   **Autenticação de Usuários**:
    *   Endpoint `POST /login` para autenticação com email e senha.
    *   Geração de token JWT para autorização de acesso aos demais endpoints.

*   **Gerenciamento de Tópicos (CRUD Completo)**:
    *   `POST /topicos`: Cadastrar um novo tópico.
    *   `GET /topicos`: Listar todos os tópicos ativos de forma paginada e ordenada.
    *   `GET /topicos/{id}`: Exibir os detalhes de um tópico específico.
    *   `PUT /topicos/{id}`: Atualizar as informações de um tópico (título, mensagem, status).
    *   `DELETE /topicos/{id}`: Exclusão lógica (soft delete) de um tópico.

*   **Validações de Regras de Negócio**:
    *   Sistema de validação desacoplado para regras de negócio.
    *   Impede o cadastro e a atualização de tópicos com título e mensagem duplicados.
    *   Valida a existência de um tópico antes de operações de atualização ou exclusão.

*   **Segurança**:
    *   Endpoints protegidos que exigem um token JWT válido no cabeçalho `Authorization`.

*   **Documentação**:
    *   Documentação interativa da API gerada com SpringDoc/OpenAPI.
    *   Disponível em `/swagger-ui.html` com suporte para autorização via Bearer Token.

---

## 🛠️ Tecnologias Utilizadas

*   **Linguagem**: Java 21
*   **Framework**: Spring Boot 3
*   **Módulos Spring**:
    *   Spring Web
    *   Spring Security
    *   Spring Data JPA
    *   Validation
*   **Banco de Dados**: MySQL
*   **Migrações de BD**: Flyway
*   **Autenticação**: JWT (JSON Web Token)
*   **Documentação**: SpringDoc (OpenAPI 3)
*   **Build Tool**: Maven
*   **Utilitários**: Lombok

---

## 🏛️ Arquitetura

O projeto adota uma arquitetura em camadas inspirada nos princípios da Clean Architecture, garantindo a separação de responsabilidades e alta manutenibilidade.

*   **`api`**: Camada de interface, responsável pela comunicação HTTP (Controllers, DTOs, Tratamento de Erros).
*   **`application`**: Camada de aplicação, que orquestra os casos de uso (Services) e contém a lógica de validação de negócio.
*   **`domain`**: O núcleo da aplicação, contendo as entidades de negócio (Models), as interfaces de repositório e as exceções de domínio.
*   **`infra`**: Camada de infraestrutura, com os detalhes técnicos de frameworks, acesso a banco de dados, segurança e configurações.

---

## ⚙️ Como Executar o Projeto

**Pré-requisitos:**
*   Java 21 (ou superior)
*   Maven 3.8 (ou superior)
*   MySQL Server (versão 8.0 ou compatível)

1.  **Clone o repositório:**
    ```bash
    git clone https://github.com/seu-usuario/forum-hub.git
    ```

2.  **Crie o Banco de Dados:**
    Antes de iniciar, você precisa ter um banco de dados MySQL chamado `forum_hub_db`. Você pode criá-lo com o seguinte comando SQL:
    ```sql
    CREATE DATABASE forum_hub_db;
    ```

3.  **Acesse o diretório do projeto:**
    ```bash
    cd forum-hub
    ```

4.  **Configure as variáveis de ambiente:**
    No arquivo `src/main/resources/application.properties`, configure as credenciais de acesso ao seu banco de dados MySQL e a chave secreta para a geração do token JWT.
    ```properties
    # Configuração do Banco de Dados
    spring.datasource.url=jdbc:mysql://localhost:3306/forum_hub_db
    spring.datasource.username=${DB_USER_MYSQL}
    spring.datasource.password=${DB_PASS_MYSQL}

    # Chave Secretra do JWT
    api.security.token.secret=${JWT_SECRET_FORUM_HUB:12345678}
    ```

5.  **Execute a aplicação:**
    Utilize o Maven para compilar e rodar o projeto. O Flyway criará todas as tabelas automaticamente na primeira execução.
    ```bash
    mvn spring-boot:run
    ```

6.  **Acesse a API:**
    *   A aplicação estará disponível em `http://localhost:8080`.
    *   A documentação do Swagger estará em `http://localhost:8080/swagger-ui.html`.

---

## ✨ Próximos Passos (Roadmap)

*   [ ] Implementar o CRUD completo de `Respostas`.
*   [ ] Implementar a funcionalidade de "marcar resposta como solução".
*   [ ] Adicionar autorização baseada em perfis de usuário (Roles).
*   [ ] Implementar testes unitários e de integração.

---

## 📄 Licença

Este projeto está sob a licença **[Nome da Licença - ex: Apache 2.0]**. Veja o arquivo `LICENSE` para mais detalhes.
<!-- 
Você pode escolher uma licença como a Apache 2.0 (padrão do ecossistema Spring) ou a MIT.
Depois de escolher, crie um arquivo chamado LICENSE na raiz do seu projeto e cole o texto da licença escolhida nele.
-->

---

**Autor**

Wendell Dorta - [Seu Link para o LinkedIn ou GitHub]

## 📖 Sobre o Projeto

**FórumHub API** é o backend para uma plataforma de fórum de discussões, desenvolvido como parte do desafio de programação Back-End da Alura. O projeto consiste em uma API REST que permite o gerenciamento completo de tópicos, seguindo as melhores práticas de desenvolvimento com uma arquitetura robusta e escalável.

A API implementa um CRUD completo e seguro para tópicos, com um sistema de autenticação de usuários via tokens JWT. O projeto também inclui documentação interativa com Swagger/OpenAPI, facilitando o teste e a integração.

---

## 🚀 Funcionalidades Implementadas

*   **Autenticação de Usuários**:
    *   Endpoint `POST /login` para autenticação com email e senha.
    *   Geração de token JWT para autorização de acesso aos demais endpoints.

*   **Gerenciamento de Tópicos (CRUD Completo)**:
    *   `POST /topicos`: Cadastrar um novo tópico.
    *   `GET /topicos`: Listar todos os tópicos ativos de forma paginada e ordenada.
    *   `GET /topicos/{id}`: Exibir os detalhes de um tópico específico.
    *   `PUT /topicos/{id}`: Atualizar as informações de um tópico (título, mensagem, status).
    *   `DELETE /topicos/{id}`: Exclusão lógica (soft delete) de um tópico.

*   **Validações de Regras de Negócio**:
    *   Sistema de validação desacoplado para regras de negócio.
    *   Impede o cadastro e a atualização de tópicos com título e mensagem duplicados.
    *   Valida a existência de um tópico antes de operações de atualização ou exclusão.

*   **Segurança**:
    *   Endpoints protegidos que exigem um token JWT válido no cabeçalho `Authorization`.

*   **Documentação**:
    *   Documentação interativa da API gerada com SpringDoc/OpenAPI.
    *   Disponível em `/swagger-ui.html` com suporte para autorização via Bearer Token.

---

## 🛠️ Tecnologias Utilizadas

*   **Linguagem**: Java 21
*   **Framework**: Spring Boot 3
*   **Módulos Spring**:
    *   Spring Web
    *   Spring Security
    *   Spring Data JPA
    *   Validation
*   **Banco de Dados**: MySQL
*   **Migrações de BD**: Flyway
*   **Autenticação**: JWT (JSON Web Token)
*   **Documentação**: SpringDoc (OpenAPI 3)
*   **Build Tool**: Maven
*   **Utilitários**: Lombok

---

## 🏛️ Arquitetura

O projeto adota uma arquitetura em camadas inspirada nos princípios da Clean Architecture, garantindo a separação de responsabilidades e alta manutenibilidade.

*   **`api`**: Camada de interface, responsável pela comunicação HTTP (Controllers, DTOs, Tratamento de Erros).
*   **`application`**: Camada de aplicação, que orquestra os casos de uso (Services) e contém a lógica de validação de negócio.
*   **`domain`**: O núcleo da aplicação, contendo as entidades de negócio (Models), as interfaces de repositório e as exceções de domínio.
*   **`infra`**: Camada de infraestrutura, com os detalhes técnicos de frameworks, acesso a banco de dados, segurança e configurações.

---

## ⚙️ Como Executar o Projeto

**Pré-requisitos:**
*   Java 21 (ou superior)
*   Maven 3.8 (ou superior)
*   MySQL Server (versão 8.0 ou compatível)

1.  **Clone o repositório:**
    ```bash
    git clone https://github.com/seu-usuario/forum-hub.git
    ```

2.  **Crie o Banco de Dados:**
    Antes de iniciar, você precisa ter um banco de dados MySQL chamado `forum_hub_db`. Você pode criá-lo com o seguinte comando SQL:
    ```sql
    CREATE DATABASE forum_hub_db;
    ```

3.  **Acesse o diretório do projeto:**
    ```bash
    cd forum-hub
    ```

4.  **Configure as variáveis de ambiente:**
    No arquivo `src/main/resources/application.properties`, configure as credenciais de acesso ao seu banco de dados MySQL e a chave secreta para a geração do token JWT.
    ```properties
    # Configuração do Banco de Dados
    spring.datasource.url=jdbc:mysql://localhost:3306/forum_hub_db
    spring.datasource.username=root
    spring.datasource.password=sua_senha

    # Chave Secretra do JWT
    api.security.token.secret=${JWT_SECRET}
    ```

5.  **Execute a aplicação:**
    Utilize o Maven para compilar e rodar o projeto. O Flyway criará todas as tabelas automaticamente na primeira execução.
    ```bash
    mvn spring-boot:run
    ```

6.  **Acesse a API:**
    *   A aplicação estará disponível em `http://localhost:8080`.
    *   A documentação do Swagger estará em `http://localhost:8080/swagger-ui.html`.

---

## ✨ Próximos Passos (Roadmap)

*   [ ] Implementar o CRUD completo de `Respostas`.
*   [ ] Implementar a funcionalidade de "marcar resposta como solução".
*   [ ] Adicionar autorização baseada em perfis de usuário (Roles).
*   [ ] Implementar testes unitários e de integração.

---

[**Badge do Desafio Concluído**]
![Badge Desafio Concluído](Badge-Spring.png)

## 📄 Licença

Este projeto está sob a licença **Apache 2.0]**. Veja o arquivo `LICENSE` para mais detalhes.
