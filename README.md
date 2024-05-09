# Supermarket API

Este é um projeto de API RESTful chamado Supermarket, que fornece operações CRUD para gerenciar produtos. Ele foi desenvolvido como uma ferramenta para aprender e praticar conceitos RESTful, utilizando tecnologias Java, Spring, PostgreSQL e outras bibliotecas relacionadas.

## Pré-requisitos

Antes de começar a utilizar o Supermarket API, certifique-se de ter o seguinte instalado em seu ambiente de desenvolvimento:

- PostgreSQL (com credenciais adequadas)
- Java 17
- Maven
- Uma IDE (recomendado: IntelliJ IDEA Community)

## Configuração do Banco de Dados

Certifique-se de ter um banco de dados PostgreSQL instalado em sua máquina. Você pode configurar as credenciais de login no arquivo `application.properties` conforme necessário. Por padrão, o login é `postgres` e a senha é `password`, mas você pode alterá-los de acordo com sua configuração.

## Tecnologias Utilizadas

O projeto Supermarket API faz uso das seguintes tecnologias e bibliotecas:

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Validation
- Flyway
- HATEOAS
- Spring Boot DevTools
- PostgreSQL
- Lombok

## Estrutura do Projeto

- `src/main/java`: Contém o código-fonte da aplicação Java.
  - `com.deisesales.supermarket`: Pacote principal da aplicação.
    - `controllers`: Contém os controladores REST para gerenciar requisições HTTP.
    - `dtos`: Contém os Data Transfer Objects (DTOs) para representar os dados transferidos pela API.
    - `models`: Contém as entidades do domínio da aplicação.
    - `repositories`: Contém interfaces de repositório para acesso aos dados.
    - `services`: Contém a lógica de negócio da aplicação.
- `src/main/resources`: Contém arquivos de configuração da aplicação, como o arquivo `application.properties`.

## Executando a Aplicação

1. Clone o repositório do Supermarket API.
2. Abra o projeto em sua IDE preferida.
3. Configure as credenciais do banco de dados no arquivo `application.properties`, se necessário.
4. Execute o projeto através da IDE ou utilizando o Maven.

## Funcionalidades Principais

- **CRUD de Produtos**: A API permite criar, ler, atualizar e excluir produtos.
- **Validação de Dados**: Utiliza validação de dados para garantir que os campos obrigatórios não estejam vazios.
- **HATEOAS**: Adiciona links de redirecionamento para melhorar a navegabilidade da API.

## Endpoints

- **PUT**: Cria um novo produto.  
  - Endpoint: `http://localhost:8080/product`
  - Retorna HTTP 201 e o json
```json
{
	"id": "dfe77b52-86ec-490e-97ad-4c7404081060",
	"name": "arroz",
	"value": 23.99
}
```

- **GET**: Lista todos os produtos cadastrados.  
  - Endpoint: `http://localhost:8080/product`
  - Retorna HTTP 200 e o json
  - Abaixo lista dois produtos:
```json
	{
		"id": "4915013e-9987-4250-a248-01471a333686",
		"name": "shampoo",
		"value": 33.45,
		"links": [
			{
				"rel": "self",
				"href": "http://localhost:8080/product/4915013e-9987-4250-a248-01471a333686"
			}
		]
	},
	{
		"id": "61bb40fc-fa0f-4352-a187-0e770e4e27e9",
		"name": "sabonete de maos",
		"value": 12.33,
		"links": [
			{
				"rel": "self",
				"href": "http://localhost:8080/product/61bb40fc-fa0f-4352-a187-0e770e4e27e9"
			}
		]
	}
```
- **GET**: Retorna os detalhes de um produto específico com o ID correspondente.  
  - Endpoint: `http://localhost:8080/product/{id}`
  - Retorna HTTP 302 e o json
```json
{
	"id": "dfe77b52-86ec-490e-97ad-4c7404081060",
	"name": "arroz",
	"value": 23.99,
	"_links": {
		"self": {
			"href": "http://localhost:8080/product"
		}
	}
}
```

- **PUT - UPDATE**: Atualiza os detalhes de um produto existente com o ID correspondente.  
  - Endpoint: `http://localhost:8080/product/{id}`
  - Envia um json
  - Retorna HTTP 200 e o json alterado
```json
{
	"id": "dfe77b52-86ec-490e-97ad-4c7404081060",
	"name": "arroz integral",
	"value": 35.33
}
```
```json
{
	"id": "dfe77b52-86ec-490e-97ad-4c7404081060",
	"name": "arroz integral",
	"value": 35.33
}
```

## Observações

- O Flyway é utilizado para gerenciar o versionamento do banco de dados, garantindo que as alterações de esquema sejam controladas e aplicadas de forma consistente.

Este projeto foi desenvolvido com o objetivo de aprender e praticar conceitos de API RESTful, e pode ser usado como referência para outros projetos semelhantes.
Para sugestões, dúvidas ou problemas relacionados ao projeto, entre em contato através do email <strong>deisesalles18@gmail.com</strong> ou <strong><a href="https://www.linkedin.com/in/deise-sales-059612174/" target="_blank" rel="external">LinkedIn<a/></strong>.

---

*Nota: Certifique-se de configurar corretamente o ambiente e o banco de dados antes de executar o projeto.*
