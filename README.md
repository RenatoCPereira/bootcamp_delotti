


# 🚀 Projeto CRUD de Usuários com Spring Boot

## 📌 Sobre o projeto

Este projeto consiste em uma aplicação web desenvolvida com **Spring Boot**, criada durante o **Bootcamp Java Deloitte - 3ª Turma**, com o objetivo de realizar o gerenciamento de usuários através de operações básicas de um CRUD (Create, Read, Update e Delete).

A aplicação permite:

* Cadastrar usuários
* Listar usuários
* Persistir dados em banco de dados
* Exibir informações em páginas web utilizando templates

O objetivo principal do projeto é aplicar conceitos fundamentais de desenvolvimento backend com boas práticas, organização em camadas e princípios de arquitetura.

---

## 🧠 Arquitetura e Organização

O projeto segue uma arquitetura em camadas:

* **Controller** → Responsável por receber as requisições HTTP
* **Service** → Contém as regras de negócio
* **Repository** → Comunicação com o banco de dados
* **DTO** → Transferência de dados entre camadas
* **Entity** → Representação da tabela no banco
* **Mapper** → Conversão entre DTO e Entity

---

## 🛠️ Tecnologias Utilizadas

### Backend

* Java 17+
* Spring Boot
* Spring Web
* Spring Data JPA
* Bean Validation

### Frontend

* Thymeleaf (template engine)
* HTML / CSS
* Bootstrap

### Banco de Dados

* H2 Database (em memória)

### Ferramentas

* Maven
* Swagger (OpenAPI) para testes de API
* IntelliJ IDEA

---

## 📂 Estrutura do Projeto

```
src/main/java/com/seuprojeto
│
├── controller
├── service
├── repository
├── dto
├── entity
└── mapper
```

---

## 🔄 Funcionalidades

### ✔ Cadastro de Usuário

* Formulário para inserção de dados
* Validação de campos com Bean Validation
* Persistência no banco de dados
* Mensagem de sucesso após salvar

### ✔ Listagem de Usuários

* Exibição de todos os usuários cadastrados

---

## 🧪 Testes

Foram realizados testes para:

* Validação do fluxo completo de cadastro
* Testes de integração da aplicação
* Testes via Swagger e Postman

---

## ⚙️ Como Executar o Projeto

### 1. Clonar o repositório

```bash
git clone https://github.com/RenatoCPereira/bootcamp_delotti.git
```



### 2. Importar na IDE

* Abrir no IntelliJ como projeto Maven

### 3. Executar a aplicação

Rodar a classe principal:

```
BootcampDelottiApplication.java
```

### 4. Acessar no navegador

* Cadastro: http://localhost:8080/cadastro
* Listagem: http://localhost:8080/listar
* H2 Console: http://localhost:8080/h2-console
* Swagger: http://localhost:8080/swagger-ui.html

---

## ⚠️ Problemas Enfrentados

Durante o desenvolvimento, foram enfrentados alguns desafios como:

* Erro **Whitelabel Error Page (500)**
* Problemas de parsing no Thymeleaf
* Conversão entre **Entity e DTO**
* Organização de pacotes e nomenclaturas
* Configuração do H2 Console
* Exposição indevida de dados (ex: senha no Swagger)

Esses problemas foram importantes para o aprendizado e evolução do projeto.

---

## 📚 Conceitos Aplicados

* Princípios **SOLID** (principalmente SRP e OCP)
* Separação de responsabilidades
* Boas práticas com Spring Boot
* Integração com banco de dados
* Uso de templates no backend
* Conversão de dados com Mapper
* Validação de dados com Bean Validation

---

## 🎯 Objetivo do Projeto

Este projeto foi desenvolvido com foco em aprendizado prático de:

* Desenvolvimento backend com Java
* Criação de APIs REST
* Integração com banco de dados
* Estruturação de aplicações reais

---

## 👨‍💻 Autor

Desenvolvido por **Renato Pereira**

---

## 📌 Melhorias Futuras

* Implementar autenticação (login)
* Criptografia de senha
* Paginação na listagem
* API REST completa


---
