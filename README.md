# BranchOffice API - Java 17 & Spring Boot (Async Methods)

Esta API está implementada en **Java 17** y **Spring Boot**, utilizando métodos asíncronos con `@Async`. Proporciona funcionalidades CRUD para la entidad **BranchOffice** (sucursal), permitiendo la gestión asíncrona de operaciones como creación, actualización y consulta.

## Características

- Implementación en Java 17 y Spring Boot.
- Métodos asíncronos usando `@Async`.
- Gestión de sucursales (BranchOffice).
- Validación y manejo de excepciones personalizado.
- Controlador REST con endpoints para operaciones CRUD.

## Instalación y Ejecución

```bash
git clone https://github.com/usuario/repo.git
cd repo
./mvnw clean install
./mvnw spring-boot:run
```

## Ejemplos de Código

### Método asíncrono para obtener sucursales
```java
@Async("asyncExecutor")
@Override
public CompletableFuture<GetBranchOfficeResult> getAllAsync(GetBranchOfficeQuery query) {
    return CompletableFuture.supplyAsync(() -> {
        var result = branchOfficeRepository.findByCompanyId(query.id());
        return new GetBranchOfficeResult(result);
    });
}
```

### Método asíncrono para crear una sucursal
```java
@Async("asyncExecutor")
@Override
@Transactional
public CompletableFuture<CreateBranchOfficeResult> saveAsync(CreateBranchOfficeCommand command) {
    return CompletableFuture.supplyAsync(() -> {
        var branch = new BranchOffice();
        branch.setCompanyId(command.companyId());
        branch.setName(command.name());
        branch.setAddress(command.address());
        branch.setPhone(command.phone());
        branch.setStatus(StatusBranchOffice.ENABLED.getValue());
        branch.setCreationDate(new Date());

        branchOfficeRepository.save(branch);
        return new CreateBranchOfficeResult(branch.getId(), branch.getCompanyId(), branch.getName(), branch.getCreationDate());
    });
}
```

## Endpoints

- `GET /api/branchoffices/{id}`: Obtiene todas las sucursales por IdEmpresa.
- `POST /api/branchoffices`: Crea una nueva sucursal.
- `PUT /api/branchoffices/{id}`: Actualiza una sucursal existente.

## Tecnologías Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Métodos asíncronos con `@Async`
- Hibernate
- Azure SQL Database

## Despliegue en Azure

La API está desplegada en Azure y puedes probarla usando el siguiente enlace de Swagger:

[Documentación de API (Swagger)]([http://tu-url-de-swagger](https://ms-pos.azurewebsites.net/swagger-ui/index.html))




