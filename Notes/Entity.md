# @Data and @Entity (Spring Boot + JPA)

---

## @Data (Lombok)

### What is it?

@Data is a Lombok annotation that automatically generates:
- Getters
- Setters
- toString()
- equals() and hashCode()
- Required constructors

---

### Why use it?

- Removes boilerplate code
- Keeps class clean and short

---

### Example

@Data
public class Product {
private int id;
private String name;
}

👉 No need to manually write getters/setters

---

## @Entity (JPA)

### What is it?

@Entity is a JPA annotation that marks a class as a database table.

👉 This tells Spring:
"This class should be mapped to a table in the database"

---

### Why use it?

- To store objects in database
- To map Java class ↔ database table

---

### Where is it used?

Placed on top of a class

---

### Example

@Entity
public class Product {
private int id;
private String name;
}

👉 This class becomes a table in DB

---

## Important with @Entity

You usually also use:

@Id → marks primary key

@GeneratedValue → auto-generates id

---

### Full Example

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String desc;
}

---

## How it works

1. You create a class with @Entity
2. Spring Boot (Hibernate) reads it
3. Table is created in DB
4. Each object = one row in table

---

## Summary

- @Data → removes boilerplate code
- @Entity → maps class to database table
- Used together in backend models