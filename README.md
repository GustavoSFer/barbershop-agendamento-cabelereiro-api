# 💇‍♂️ Agendamento Cabelereiro API

API desenvolvida em **Java com Spring Boot** para gerenciamento de agendamentos de um salão de cabeleireiro.  
A aplicação permite que clientes agendem cortes de cabelo, façam planos mensais e gerenciem suas informações pessoais.  
O foco deste projeto é demonstrar boas práticas de desenvolvimento backend, incluindo autenticação JWT, validações, documentação Swagger, HATEOAS e paginação.

---

## 🚀 Funcionalidades

- **Gerenciamento de Clientes**
    - Cadastrar, listar, editar, excluir e atualizar clientes
    - Validação de campos obrigatórios (nome, telefone, CPF)
    - Campo de e-mail opcional

- **Pacote Mensal**
    - Plano mensal de R$ 80,00 que permite ao cliente realizar quantos cortes desejar dentro do mês

- **Agendamento de Cortes**
    - Agendar cortes de cabelo
    - Verificar se o corte deve ser pago ou está incluso no plano mensal

- **Listagem de Cortes**
    - Listar tipos de cortes disponíveis

- **Paginação**
    - Paginação na listagem de clientes para melhor performance

- **Segurança**
    - Autenticação via **JWT (JSON Web Token)**
    - Endpoints protegidos por roles de usuário (ex: ADMIN, USER)

- **Documentação**
    - Documentação interativa com **Swagger UI**

- **CORS**
    - Configuração global habilitando requisições de:
        - `http://localhost:8080`
        - `http://localhost:3000`

- **HATEOAS**
    - Inclusão de links de navegação nos recursos retornados pela API

---

## 🛠️ Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot**
    - Spring Web
    - Spring Data JPA
    - Spring Security (JWT)
    - Spring HATEOAS
- **Swagger / OpenAPI**
- **Validation (Jakarta Bean Validation)**
- **MySQL / H2 Database**
- **Maven**
- **Lombok**

---

## ⚙️ Pré-requisitos

- Java 17 ou superior
- Maven 3.8+
- Banco de dados MySQL (ou H2 em modo de teste)
- IDE (IntelliJ / Eclipse / VS Code)

---

## ▶️ Como Executar o Projeto

1. **Clonar o repositório:**
   ```bash
   git clone https://github.com/seuusuario/barbershop-agendamento-cabelereiro-api.git

2. **Entrar na pasta do projeto:**

```cd barbershop-agendamento-cabelereiro-api```


3. **Configurar o banco de dados (application.properties ou application.yml):**
```
spring.datasource.url=jdbc:mysql://localhost:3306/agendamento_db
spring.datasource.username=root
spring.datasource.password=senha
spring.jpa.hibernate.ddl-auto=update
```

4. **Executar o projeto:**

```mvn spring-boot:run```


5. **Acessar a documentação Swagger:**

http://localhost:8080/swagger-ui.html

🔒 **Autenticação JWT**

Para acessar os endpoints protegidos, é necessário autenticar-se com um usuário válido e obter um token JWT.

Endpoint de login: POST /auth/login

O token deve ser enviado no header das requisições:

Authorization: Bearer <seu_token>

📘 Exemplos de Endpoints
Método	Endpoint	Descrição
POST	/clientes	Cadastrar novo cliente
GET	/clientes?page=0&size=10	Listar clientes com paginação
PUT	/clientes/{id}	Atualizar cliente
DELETE	/clientes/{id}	Excluir cliente
GET	/cortes	Listar cortes disponíveis
POST	/agendamentos	Criar um novo agendamento
POST	/auth/login	Autenticação e geração de token JWT

🧩 **Organização de Pacotes**
```
src/main/java/com/seuprojeto/agendamento
│
├── config/          # Configurações (CORS, Swagger, Security)
├── controller/      # Controladores REST
├── dto/             # Objetos de transferência de dados
├── entity/          # Entidades JPA
├── repository/      # Repositórios Spring Data
├── service/         # Regras de negócio
└── security/        # JWT e autenticação
```

🧠 **Aprendizados e Objetivo**

- Este projeto foi criado com o objetivo de:
- Praticar conceitos de arquitetura RESTful
- Implementar autenticação JWT e boas práticas de segurança
- Utilizar validação de dados e documentação da API
- Demonstrar organização de código e estrutura profissional de backend