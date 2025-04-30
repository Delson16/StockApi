# Stock API

Este projeto é uma **API RESTful simples** desenvolvida com **Spring Boot** para gerenciamento de produtos em estoque. A API permite operações básicas como:

- Listar todos os produtos  
- Buscar um produto por ID  
- Cadastrar um novo produto  
- Atualizar um produto existente  
- Excluir um produto por ID  

## Tecnologias e dependências utilizadas

- **Java 21**
- **Spring Boot 3.4.5**
  - `spring-boot-starter-web`: estrutura básica para criação da API REST
  - `spring-boot-starter-data-jpa`: integração com JPA/Hibernate para persistência de dados
  - `spring-boot-starter-validation`: validação de dados nos modelos
- **MySQL** (conector JDBC: `mysql-connector-j`)
- **Lombok**: geração automática de código boilerplate (getters, setters, etc.)

## Estrutura básica

A API possui endpoints organizados por um controller principal responsável por lidar com as requisições relacionadas à entidade `Produto`.

### Exemplo de endpoints:

- `GET /produto` → Lista todos os produtos  
- `GET /produto/{id}` → Busca um produto pelo ID  
- `POST /produto` → Cadastra um novo produto  
- `PUT /produto/{id}` → Atualiza um produto existente  
- `DELETE /produto/{id}` → Remove um produto do sistema  

## Como executar o projeto

1. **Clone o repositório:**

   ```bash
   git clone https://github.com/seu-usuario/stockApi.git

2. Configure o banco de dados MySQL

Crie um banco com o nome de sua escolha e ajuste as credenciais no arquivo `application.properties`.

> Obs.: Este projeto utiliza um banco de dados chamado `stock`, mas você pode configurar outro nome conforme desejar.  
> Caso queira, há um arquivo `.sql` disponível para criar o banco automaticamente.  
> As tabelas são criadas automaticamente pela aplicação Java utilizando JPA/Hibernate.

```properties
spring.datasource.url=jdbc:jdbc:mysql://localhost:3306/nome_do_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```
3. Execute o projeto com Maven ou através da sua IDE.
