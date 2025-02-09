# Sistema de Gerenciamento de Imóveis

Uma API RESTful para gerenciar imóveis, permitindo realizar operações de criação, leitura, atualização e exclusão (
CRUD), além de filtrar e paginar resultados com base em critérios específicos, como categoria e tipo de transação.

---

## Funcionalidades

**CRUD Completo**:

- Criação, leitura, atualização e exclusão de imóveis.
- Validação de dados para garantir a integridade das informações.

**Paginação e Filtros**:

- Listagem de imóveis com suporte a paginação.
- Filtros dinâmicos por categoria (apartamento, casa) e tipo de transação (venda, aluguel).

**Testes Unitários**:

- Cobertura de testes para as camadas de Controller, Service e Repository.
- Uso de JUnit e Mockito para garantir a qualidade do código.

**Arquitetura Organizada**:

- Projeto estruturado em camadas (Controller, Service, Repository, Domain).
- Uso de DTOs (Data Transfer Objects) para transferência de dados.

---

## Tecnologias Utilizadas

- **Linguagem**: Java 17
- **Framework**: Spring Boot
- **Banco de Dados**: MySQL
- **Testes**: JUnit, Mockito
- **Ferramentas**: Lombok, Swagger (documentação da API), Docker
---

## Configuração do Ambiente

### Pré-requisitos
Certifique-se de ter as seguintes ferramentas instaladas:

- Java 17 ou superior
- Maven
- MySQL
- Docker (opcional, para uso com contêineres)
- Postman (opcional, para testes manuais da API)

## Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/LeandroEdv/Study_projects.git
2. Configure o banco de dados no arquivo application.properties.
   ```bash
   spring.datasource.url=jdbc:mysql://localhost:3306/imoveis_db
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   spring.jpa.hibernate.ddl-auto=update

4. Configure o Docker (Opcional):
   ```bash
   services:
   mysql:
   image: 'mysql:latest'
   environment:
   - 'MYSQL_DATABASE=imoveis_db'
     - 'MYSQL_PASSWORD=sua_senha'
     - 'MYSQL_ROOT_PASSWORD=seu_rootPassword'
     - 'MYSQL_USER=seu_usuario'
     ports:
     - '3306:3306'
     volumes:
     - real_state_data:/var/lib/mysql
     volumes:
     real_state_data:

5. Compile e execute o projeto:
   ```bash
   mvn clean install
   mvn spring-boot:run

3. Acesse a documentação da API no Swagger:
   ```bash
   http://localhost:8080/swagger-ui.html

## Considerações Finais

Este projeto foi desenvolvido como parte de estudos e práticas em desenvolvimento Java com Spring Boot. Sinta-se à vontade para entrar em contato ou contribuir!

- [LinkedIn](https://www.linkedin.com/in/leandro-edvan/)
- [GitHub](https://github.com/LeandroEdv/)