# Web-service based on Spring Webflux.

Gradle, Webflux, Spring Boot 2.7.5, JAXB, JPA, H2

### Endpoint:

```json
REST <server-name>:<port>/data/create

Input body:
{"id":123, "message":"555"}

Result:
555
```

### Features:

1. Receives attribute as String and transforms into Integer.
2. If number was successfully converted, stores input into DB.
3. Contains example of storing values into reactive request context.
4. Can generate code from WSDL.
5. Can generate code from XSD.