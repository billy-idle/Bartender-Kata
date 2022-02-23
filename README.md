# Bartender-Kata

## Descripción

* Este artefacto pretende ser un primer acercamiento al back-end de la aplicación web.
* Aplicando patrones de arquitectura y un desarrollo conducido por pruebas.

### Casos de uso

* SolveKata.

### Entidades

* Kata

## Arquitectura

La arquitectura de la aplicación corresponde a la arquitectura-hexagonal o tambien llamada *ports and adapters* propuesta por Alistair Cockburn y descrita por Tom Hombergs en su libro *Clean Architecture*.

![alt-text][1]

En esta arquitectura-hexagonal tenemos:

  * entidades
  * casos de uso
  * puertos entrantes y salientes
  * adaptadores entrantes y salientes

todos estos como elementos principales de arquitectura.

A continuación se muestra la estructura de paquetes que expresa esta arquitectura:

```console
C:.
│   KataApplication.java
│
├───common
│   ├───annotation
│   │       PersistenceAdapter.java
│   │       UseCase.java
│   │       WebAdapter.java
│   │
│   ├───domain
│   │       BaseDomain.java
│   │
│   ├───i18n
│   │       MessageResourcesConfiguration.java
│   │
│   ├───mapper
│   │       DataMapper.java
│   │       IdMapper.java
│   │
│   ├───persistence
│   │       AuditableEntity.java
│   │       BaseJpaEntity.java
│   │
│   ├───type
│   │       BaseType.java
│   │       Data.java
│   │       Id.java
│   │
│   └───utilities
│       │   ConflictException.java
│       │   Utility.java
│       │
│       └───error
│               CustomError.java
│               DataErrorHandling.java
│               ErrorResponse.java
│               RestResponseEntityExceptionHandler.java
│               ValidationErrorResponse.java
│               Violation.java
│               ViolationHandling.java
│
└───solver
    ├───adapter
    │   ├───in
    │   │   └───web
    │   │           KataController.java
    │   │
    │   └───out
    │       └───persistence
    │               DatasetJpaEntity.java
    │               DatasetPersistenceAdapter.java
    │               DatasetRepository.java
    │
    ├───aplication
    │   ├───mapper
    │   │       KataMapper.java
    │   │
    │   ├───port
    │   │   ├───in
    │   │   │       OutputResponseModel.java
    │   │   │       SetupRequestModel.java
    │   │   │       SolveKataInputPort.java
    │   │   │
    │   │   └───out
    │   │           GetDatasetOutputPort.java
    │   │
    │   └───service
    │           SolveKataUseCase.java
    │
    └───domain
            Kata.java
```

### Swagger

```console
http://localhost:8083/swagger-ui/index.html
```

![alt-text][2]

Se muestran los endpoints desarrollados hasta el momento, los cuáles corresponden con los casos de uso implementados. 

[1]: /src/main/resources/docs/hexagonal-architecture.png
[2]: /src/main/resources/docs/API.png
