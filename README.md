# API REST de Cadastro de Usuários

API RESTful desenvolvida em Java utilizando **Spring Boot 3**, projetada para o gerenciamento de usuários com foco em boas práticas de arquitetura em camadas, validação de dados, tratamento de exceções e documentação interativa.

---

## 🛠️ Tecnologias e Ferramentas Utilizadas

* **Java 17+**
* **Spring Boot 3**
  * **Spring Data JPA:** Para persistência de dados e mapeamento objeto-relacional.
  * **Spring Web:** Para construção da API RESTful baseada em arquitetura MVC.
  * **Spring Boot Validation:** Para validação de dados de entrada baseada em Bean Validation (`@NotBlank`, `@Email`, etc.).
* **Lombok:** Para redução de código boilerplate (gerenciamento automático de getters, setters e construtores).
* **SpringDoc OpenAPI (Swagger):** Para documentação interativa automatizada da API.
* **H2 Database:** Banco de dados em memória utilizado para o ambiente de desenvolvimento e testes rápidos.

---

## 🏗️ Arquitetura do Projeto

O projeto segue uma abordagem de **arquitetura em camadas** bem definida para separar responsabilidades:

```text
src/
 └── main/
      └── java/
           └── com/
                └── pedrispengler/
                     └── cadastro_usuario/
                          ├── CadastroUsuarioApplication.java
                          ├── config/          # Configurações globais (ex: Swagger/OpenAPI)
                          ├── controller/      # Endpoints HTTP e manipulação global de exceções
                          ├── dto/             # Objetos de Transferência de Dados (Records)
                          ├── model/           # Entidades JPA (Modelo de Domínio do Banco de Dados)
                          ├── repository/      # Interfaces de acesso ao banco de dados (Spring Data JPA)
                          └── service/         # Camada de regras de negócio da aplicação
