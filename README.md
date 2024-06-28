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
```

- This starter creates the following dialects with their associated artifacts:

| Dialect Class                | Associated Artifact              |
| ---------------------------- | -------------------------------- |
| CommonsLangExpressionDialect | org.apache.commons:commons-lang3 |

- The `CommonsLangExpressionDialect` provides expressions with their associated classes as following:

| Expression         | Associated Class                           |
| ------------------ | ------------------------------------------ |
| #arrayUtils        | org.apache.commons.lang3.ArrayUtils        |
| #booleanUtils      | org.apache.commons.lang3.BooleanUtils      |
| #charUtils         | org.apache.commons.lang3.CharUtils         |
| #numberUtils       | org.apache.commons.lang3.math.NumberUtils  |
| #objectUtils       | org.apache.commons.lang3.ObjectUtils       |
| #randomUtils       | org.apache.commons.lang3.RandomUtils       |
| #randomStringUtils | org.apache.commons.lang3.RandomStringUtils |
| #regexUtils        | org.apache.commons.lang3.RegExUtils        |
| #stringUtils       | org.apache.commons.lang3.StringUtils       |
| #systemUtils       | org.apache.commons.lang3.SystemUtils       |

- Write your template code as following (take `img` as an example)
```
<img th:src="@{${'/asset/img/foobar-' + #randomUtils.nextInt(1,3) + '.png'}}">
```
Ah, does it looks cool?

## Document

- thymeleaf-dialect-spring-boot-starter github: https://github.com/yookue/thymeleaf-dialect-spring-boot-starter
- thymeleaf-dialect-spring-boot-starter javadoc: https://javadoc.wiki/public/apidoc/com.yookue.springstarter/thymeleaf-dialect-spring-boot-starter/latest
- thymeleaf github: https://github.com/thymeleaf/thymeleaf
- thymeleaf homepage: https://thymeleaf.org

## Requirement

- jdk 1.8+

## Contribution

We accept Pull Requests via GitHub. There are some guidelines which will make applying PRs easier for us:
- No tabs! Please use spaces for indentation.
- Respect the code style.
- Create minimal diffs - disable on save actions like reformat source code or organize imports. If you feel the source code should be reformatted, create a separate PR for this change.

## License

This code is under the [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0)
See the `NOTICE.txt` file for required notices and attributions.

## Donation

You like this package? Then [donate back to Yookue](https://yookue.com/public/donate) to support the development.

## Website

- Yookue: https://yookue.com
