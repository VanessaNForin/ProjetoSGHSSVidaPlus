# 🏥 VidaPlus – Sistema de Gestão Hospitalar 

Desenvolvimento de uma API REST para gerenciamento de unidades de saúde, permitindo controle de hospitais, clínicas, laboratórios, leitos, cadastro de profissionais da saúde, administradores e pacientes, além de permitir o gerenciamento de exames, consultas, internações e receitas digitais.
Esse projeto é referente ao projeto de conclusão de curso de Tecnologia em Análise e Desenvolvimento de Sistemas da faculdade Uninter.

## ✅ Principais funcionalidades

CRUD completo de:
- Hospitais, Clínicas e Laboratórios
- Médicos, Enfermeiros, Técnicos, Pacientes e Administradores
- Leitos hospitalares, Consultas, Exames, Internações e Receitas.

Também inclui: 
- Relacionamento entre entidades (ex: administrador → hospital)
- API REST padronizada
- Suporte a execução via Docker

### 🛠 Tecnologias Utilizadas

- IntelliJ
- Java 21
- Spring Boot 3
- Spring Data JPA
- PostgreSQL
- Hibernate
- Maven
- Docker & Docker Compose
- Testes via Swagger UI

## ✅ Requisitos e Como Rodar

Antes de rodar o projeto, você precisa ter instalado: <br>
Java 17+ <br>
Maven 3.8+ <br>
Docker e Docker Compose <br>
Git <br>
(Opcional) Postman ou Insomnia para testar a API

⬇️ Como baixar o projeto?

1. Clone o repositório
```
git clone https://github.com/seu-usuario/seu-repo.git
```
2. Acesse a pasta do projeto
```
cd seu-repo
```

🐳 Subindo o ambiente com Docker

1. Iniciar o MySQL via Docker
``` 
docker compose up -d
```

2. Rodar o projeto
```
mvn spring-boot:run
```

Ou, se estiver usando sua IDE: Executar a classe Application.java <br>
🌍 A API ficará disponível em: <br>
http://localhost:8080/ <br>
Ou, se preferir: <br>
http://localhost:8080/swagger-ui.html

## 🚀 Possíveis Evoluções

- Spring Security + JWT
- Paginação e filtros dinâmicos
- Dashboard de ocupação de leitos


## 👩‍💻 Autoria

**Projeto desenvolvido por Vanessa Forin** <br>
Estudante de TI e pós-graduação em Ciência de Dados <br>
Foco em desenvolvimento Back-End com Java & Spring Boot

