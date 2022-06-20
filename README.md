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
> Toda classe controller, deve ter um @Controller, porém, será necessário acrescentar um @ResponseBody para cada @RequestMapping, caso contrário, o springboot entenderá que o retorno dos métodos da classe será uma interface web e não um corpo json por exemplo. 
> 
> Para evitar esse problema, pode-se substituir o @Controller por @RestController, dessa forma, não é necessário utilizar o @ResponseBody, pois o mesmo ficará implicito no código.