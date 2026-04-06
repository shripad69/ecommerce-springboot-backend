# Spring Boot + MySQL (Docker Container) Setup Guide

## 📌 Goal
Connect a Spring Boot backend application to a MySQL database running inside a Docker container.

---

## 🧱 Step 1: Run MySQL Container

docker run -d \
  --name mysql-container \
  -e MYSQL_ROOT_PASSWORD=root \
  -e MYSQL_DATABASE=testdb \
  -p 3306:3306 \
  mysql:8

👉 This will:
- Create a MySQL container
- Set root password = root
- Create database = testdb
- Expose port 3306

---

## 🔍 Step 2: Verify Container is Running

docker ps

---

## 💻 Step 3: Connect via MySQL CLI (Optional)

docker exec -it mysql-container mysql -u root -p

Enter password: root

---

## 📦 Step 4: Add Dependency (pom.xml)

<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
</dependency>

---

## ⚙️ Step 5: Configure application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/testdb
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

---

## 🧠 Step 6: Create Entity

import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
}

---

## 📚 Step 7: Create Repository

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

---

## 🚀 Step 8: Run Spring Boot App

mvn spring-boot:run

---

## 🧪 Step 9: Verify Tables

docker exec -it mysql-container mysql -u root -p

USE testdb;
SHOW TABLES;

---

## 🎯 Summary

- Docker runs MySQL
- Spring Boot is backend
- JDBC connects app to DB
- JPA/Hibernate handles table creation and queries

---

## ⚠️ Common Issues

- Wrong port → check 3306
- Container not running → docker ps
- Wrong DB name → testdb
- Missing driver dependency

---

## 🧩 Flow

Spring Boot → JDBC → MySQL Driver → MySQL (Docker Container)