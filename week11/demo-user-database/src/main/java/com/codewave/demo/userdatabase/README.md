### Microservice to call internal data
- H2 / MySQL
- Jpa/Hiberate, Entity -> @OneToMany, @ManytoOne
- Controller for RESTful API, Get/Post/Delete/Put
- Jpa, @Query JPQL/Native Query, Jpa method
- Controller/ Service/ Repository/ Configuration (Componment)
- Bean Concept/ Spring Context
- @SpringBootApplication -> @Configuration/ @ComponmentScan/ @EnableAutoConfiguration
- @Value, retrieve static data from application.yml
- DTO, mainly for controller interacting between consumer and Entity (RequestDTO, ResponseDTO)
- ModelMapper, convert between DTOs
- Scheduled Jobs
- Actuator (health check/ metrics)
- RestTemplate to invoke API
- ApiResponse, common API JSON response type
- Global Exception Handler (TODO: throw exception in Service layer)
- Maven, version, parent, inject program/class
- Deserialization (JSON -> Object), Serialization (Object -> JSON)   <@RestController = @Controller + @ResponseBody (JSON)>