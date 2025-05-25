# HEXAGONAL ARQUITECTURE

## 1. ¿Qué es el dominio?
Es el corazón del negocio. Contiene las reglas, entidades y lógica pura que resuelve problemas reales.
Ej: Usuario, Producto, Pedido, Inventario.

#### **Dominio** = "Lo que tu software necesita resolver en el mundo real".

Ejemplo: si estás haciendo una app para una tienda online, el dominio incluye:

- Producto
- Usuario
- Pedido
- Carrito
- Inventario

## 2. ¿Modelo ≠ Entidad?
Sí, son diferentes:

**Modelo de dominio**: representa el concepto puro del negocio. <br>
**Entidad**: representa cómo guardar ese modelo en la base de datos

```java 
// Dominio
public class User {
    private Long id;
    private String name;
}

// Entidad JPA
@Entity
public class UserEntity {
    @Id
    private Long id;
    private String name;
}
```

## 3. ¿Repository es solo para DB?

representa una **interfaz para acceder a datos**, ya sea en DB, archivos o APIs.

``java``

```java
public interface UserRepository {
    void save(User user);
    Optional<User> findById(Long id);
}
```

## 4. ¿Servicios = lógica de negocio?

**Encapsulan la lógica del negocio**.<br>
Ejemplo en tienda: agregar productos al carrito, pagar, registrar usuario.

- java
- Copiar
- Editar

```java 
public class OrderService {
    public void placeOrder(User user) { ... }
}
```

## 5. ¿Qué son los UseCases?
**Coordinan servicios**. <br>
Orquestan un flujo completo del usuario. 

```java
public class RegisterUserUseCase {
    public void execute(String name, String email) { ... }
}
```
## 6. ¿Infraestructura?
Todo lo que conecta tu sistema con el mundo externo:

- Controladores HTTP
- Repositorios con JPA
- Clientes API
- Email
- Redis
- Kafk

## 7. ¿Persistencia?
Módulo que se encarga de leer/escribir datos:

- Entidades (@Entity)
- Repositorios (ej. JpaRepository)
- Mappers

## 8. ¿Entidades = Tablas?
Son clases que representan tablas:

```java
@Entity
@Table(name = "users")
public class UserEntity { ... }
```

## ***Estructura hexagonal***

``` txt
src/
 ├─ domain/
 │   ├─ model/         ← Modelos puros (User, Product)
 │   ├─ repository/    ← Interfaces para datos
 │   └─ service/       ← Lógica del negocio
 ├─ application/
 │   └─ usecase/       ← Coordinadores de flujo
 ├─ infrastructure/
 │   ├─ controller/    ← REST Controllers
 │   └─ persistence/   ← DB (entidades, impls)
 │       ├─ entity/    ← Tablas
 │       └─ impl/      ← JpaRepository o Mongo impls
```