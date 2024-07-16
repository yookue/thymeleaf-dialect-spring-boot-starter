# Thymeleaf Dialect Spring Boot Starter

Spring Boot application integrates `thymeleaf` dialects quickly, to boost your template development.

## Quickstart

- Import dependencies
```xml
    <dependency>
        <groupId>com.yookue.springstarter</groupId>
        <artifactId>thymeleaf-dialect-spring-boot-starter</artifactId>
        <version>LATEST</version>
    </dependency>
```

> By default, this starter will auto take effect, you can turn it off by `spring.thymeleaf-dialect.enabled = false`

- Configure Spring Boot `application.yml` with prefix `spring.thymeleaf-dialect` (**Optional**)
```yml
spring:
    thymeleaf-dialect:
        commons-lang-dialect:
            processor-order: 0
        commons-rng-dialect:
            processor-order: 0
```

- This starter creates the following dialects with their associated artifacts:

| Dialect Class                | Associated Artifact                   |
|------------------------------|---------------------------------------|
| CommonsLangExpressionDialect | org.apache.commons:commons-lang3      |
| CommonsRngExpressionDialect  | org.apache.commons:commons-rng-simple |

- The `CommonsLangExpressionDialect` provides expressions with their associated classes as following:

| Expression         | Associated Class                           |
|--------------------|--------------------------------------------|
| #arrayUtils        | org.apache.commons.lang3.ArrayUtils        |
| #booleanUtils      | org.apache.commons.lang3.BooleanUtils      |
| #charUtils         | org.apache.commons.lang3.CharUtils         |
| #numberUtils       | org.apache.commons.lang3.math.NumberUtils  |
| #objectUtils       | org.apache.commons.lang3.ObjectUtils       |
| #randomStringUtils | org.apache.commons.lang3.RandomStringUtils |
| #regexUtils        | org.apache.commons.lang3.RegExUtils        |
| #stringUtils       | org.apache.commons.lang3.StringUtils       |
| #systemUtils       | org.apache.commons.lang3.SystemUtils       |

- The `CommonsRngExpressionDialect` provides expressions with their associated classes as following:

| Expression      | Associated Class                               |
|-----------------|------------------------------------------------|
| #randomProvider | org.apache.commons.rng.simple.RandomSource#JDK |

- Write your template code as following (take `img` as an example)
```
<img th:src="@{${'/asset/img/foobar-' + #randomProvider.nextInt(1,3) + '.png'}}">
```
Ah, does it look cool?

## Document

- Github: https://github.com/yookue/thymeleaf-dialect-spring-boot-starter
- Thymeleaf github: https://github.com/thymeleaf/thymeleaf
- Thymeleaf homepage: https://thymeleaf.org

## Requirement

- jdk 17+

## License

This project is under the [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0)

See the `NOTICE.txt` file for required notices and attributions.

## Donation

You like this package? Then [donate to Yookue](https://yookue.com/public/donate) to support the development.

## Website

- Yookue: https://yookue.com
