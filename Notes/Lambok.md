# Lombok Annotations: @Data, @AllArgsConstructor, @NoArgsConstructor

These annotations come from Lombok library.
They reduce boilerplate code (getters, setters, constructors, etc.)

👉 You must have Lombok dependency added in your project.

---

## @Data

### What is it?

@Data automatically generates:
- Getters
- Setters
- toString()
- equals() and hashCode()
- Required constructors

---

### Why use it?

- Removes need to write repetitive code
- Makes class clean and short

---

### Example

@Data
public class Product {
private int id;
private String name;
}

👉 Lombok will generate all getters/setters internally

---

## @AllArgsConstructor

### What is it?

Generates a constructor with ALL fields as parameters.

---

### Example

@AllArgsConstructor
public class Product {
private int id;
private String name;
}

👉 Generated constructor:
Product(int id, String name)

---

## @NoArgsConstructor

### What is it?

Generates a constructor with NO parameters (default constructor).

---

### Example

@NoArgsConstructor
public class Product {
private int id;
private String name;
}

👉 Generated constructor:
Product()

---

## Combined Example

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
private int id;
private String name;
}

👉 This gives:
- All getters/setters
- Full constructor
- Empty constructor
- toString(), equals(), hashCode()

---

## Important Note

- These annotations work at compile time
- You won’t see generated code, but it exists
- IDE plugin for Lombok is required (IntelliJ/Eclipse)

---

## Summary

- @Data → all boilerplate methods
- @AllArgsConstructor → constructor with all fields
- @NoArgsConstructor → empty constructor
- Saves time and keeps code clean