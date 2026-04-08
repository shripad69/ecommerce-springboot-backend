# 📦 @Repository Annotation in Spring Boot

## 📌 Introduction

In Spring Boot, the `@Repository` annotation is used to indicate that a class is responsible for **data access logic**. It is a specialization of the `@Component` annotation and is part of the Spring Data layer.

---

## 🎯 Purpose of @Repository

- Marks a class as a **Data Access Object (DAO)**.
- Handles interaction with the **database**.
- Provides **automatic exception translation** (converts database exceptions into Spring’s DataAccessException).

---

## 🧠 Key Features

- Detected automatically during **component scanning**.
- Used in the **persistence layer**.
- Enables **clean separation of concerns**.
- Works seamlessly with **Spring Data JPA**.

---

## 🏗️ Where It Is Used

Typically used in:
- DAO classes
- Repository interfaces (with Spring Data JPA)

---

## 🔧 Example 1: Using @Repository with a Class

```java
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

    public void saveProduct() {
        System.out.println("Saving product to database...");
    }

    public void getProduct() {
        System.out.println("Fetching product from database...");
    }
}
```

## 🔧 Example 2: Using @Repository with Spring Data JPA

```java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    // Custom query methods can be defined here
}
```

⚙️ How It Works Internally

Spring scans classes during startup.
Finds classes annotated with @Repository.
Registers them as Spring Beans.
Injects them where needed using @Autowired.