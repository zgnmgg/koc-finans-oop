# Koç Finans OOP Practice Service

## Requirements

For building and running the application you need:

- [JDK 11]
- [Gradle]
- Environment Variables =>
    -  DATABASE_URL (PostgreSQL host name)
    -  DATABASE_USERNAME (PostgreSQL username)
    -  DATABASE_PASSWORD (PostgreSQL password)

## Build
```
./gradlew clean build
```
### Unit Tests
```
./gradlew clean test
```

## Package

```
./gradlew clean bootJar
```

## How to run after packaged

```
  java -jar -DATABASE_URL=jdbc:postgresql://localhost:5432/kocfinans -DDATABASE_USERNAME=kocfinans -DDATABASE_PASSWORD=Koçfinans123! build/libs/api-service-1.0-SNAPSHOT.jar -p 8080
```

## Docker Build

```
docker build . -t api-service
```

## S.O.L.I.D Java

### Single Responsibility Principle (SRP)
A class should have only one reason to change.

### Open/Closed Principle (OCP)
Software** entities should be open for extension, but closed for modification.

### Liskov Substitution Principle (LSP)
Let O(x) be a property provable about objects x of type T. Then O(y) should be true for objects y of type S where S is a subtype of T. Child classes should never break the parent class type definitions.

### Interface Segregation Principle (ISP)
The interface-segregation principle states that no client should be forced to depend on methods it does not use. No client should be forced to depend on methods it does not use. The number of members in the interface that is visible to the dependent class should be minimised.Large classes implement multiple smaller interfaces that group functions according to their usage

### Dependency Inversion Principle (DIP)
High-level modules should not depend on low-level modules. Both should depend on abstractions. Abstractions should not depend upon details.