# Springboot Introduction

## O que é?
Introdução ao springboot.

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

- Para o Spring disparar as validações do Bean Validation e devolver um erro 400, caso alguma informação enviada pelo cliente esteja inválida, devemos utilizar a anotação @Valid;
  
- Para interceptar as exceptions que forem lançadas nos métodos das classes controller, devemos criar uma classe anotada com @RestControllerAdvice;
  
- Para tratar os erros de validação do Bean Validation e personalizar o JSON, que será devolvido ao cliente da API, com as mensagens de erro, devemos criar um método na classe @RestControllerAdvice e anotá-lo com @ExceptionHandler e @ResponseStatus.

- Nas últimas versões do Spring Boot os métodos getOne() e getById(), das interfaces repository, foram marcados como deprecated, sendo que agora devemos utilizar o novo método getReferenceById().
  
  >Lista de deprecated: https://docs.spring.io/spring-data/jpa/docs/current/api/deprecated-list.html

- O springboot 2.7.0 utiliza um conversor (jackson) que binda objetos para json, porém, ao utiliza-lo com lombok, é necessário sentar a anotação @JsonAutoDetect(fieldVisibility = Visibility.ANY) para que o jackson enxergue os métodos (getters e setters).
  
- Para receber parâmetros dinâmicos no path da URL, devemos utilizar a anotação @PathVariable;
  
- Para fazer o controle transacional automático, devemos utilizar a anotação @Transactional nos métodos do controller, ou seja, dessa forma é feito commit no banco após a execução sem erros/exceptions e a conexão com o banco é fechada.
## Dúvidas
- DTO (Data Transfer Object) e o VO (Value Object) são a mesma coisa?
- Diferença entre métodos Put e Patch? Put atualiza e sobreescreve tudo, já o Patch atualiza apenas uma parte?