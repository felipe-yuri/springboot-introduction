# Springboot Introduction

## O que é?
Loremipsum lore ipsumLoremipsum lore ipsumLoremipsum lore ipsumLoremipsum lore ipsumLoremipsum lore ipsumLoremipsum lore ipsumLoremipsum lore ipsumLoremipsum lore ipsumLoremipsum lore ipsumLoremipsum lore ipsumLoremipsum lore ipsumLoremipsum lore ipsumLoremipsum lore ipsumLoremipsum lore ipsumLoremipsum lore ipsumLoremipsum lore ipsumLoremipsum lore ipsumLoremipsum lore ipsum

## Tecnologias / Frameworks
- Java 11
- Maven 3.8
- Springboot 2.7.0
- Swagger
- Hibernate
- H2

## Anotações
- Toda classe controller, deve ter um @Controller, porém, será necessário acrescentar um @ResponseBody para cada @RequestMapping, caso contrário, o springboot entenderá que o retorno dos métodos da classe será uma interface web e não um corpo json por exemplo. 
 
- Para evitar esse problema, pode-se substituir o @Controller por @RestController, dessa forma, não é necessário utilizar o @ResponseBody, pois o mesmo ficará implicito no código.


- Não é uma boa prática retornar entidades JPA nos métodos dos controllers, sendo mais indicado retornar classes que seguem o padrão DTO (Data Transfer Object);

- Para não precisar reiniciar manualmente o servidor a cada alteração feita no código, basta utilizar o módulo Spring Boot DevTools;

- Para transformar as classes em entidades da JPA, deve-se utilizar a anotação @Entity.
- Para identificar a chave primaria usar a anotação @Id e para autoincrementar usar @GeneratedValue(strategy = GenerationType.IDENTITY)

- Para que o Spring Boot popule automaticamente o banco de dados da aplicação, devemos criar o arquivo src/main/resources/data.sql;

- O arquivo application.properties contém as configurações de datasources, JPA, e outras configurações do springboot.

- No application.properties a propriedade 'spring.jpa.defer-datasource-initialization=true' serve para que o data.sql seja executada após a criação das tabelas do banco.
  
- Para criar consultas que filtram por atributos da entidade, devemos seguir o padrão de nomenclatura de métodos do Spring, como por exemplo findByCursoNome;

- Para criar manualmente a consulta com JPQL, devemos utilizar a anotação @Query;

- @RequestBody serve para explicitar que o parametro de um método vai ser passado através do corpo da requisição.
  
- Para receber dados enviados no corpo da requisição, a boa prática é criar uma classe que também siga o padrão DTO (Data Transfer Object);

- Para montar uma resposta a ser devolvida ao cliente da API, devemos utilizar a classe ResponseEntity do Spring;
  
- A partir da versão 2.3.0 do Spring Boot o Bean Validation (@NotNull @NotEmpty @Size) não vem mais incluído automaticamente no projeto, sendo necessário adicionar essa dependência no arquivo pom.xml:
```xml

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>

```
## Dúvidas
- DTO (Data Transfer Object) e o VO (Value Object) são a mesma coisa?