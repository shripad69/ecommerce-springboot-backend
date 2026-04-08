# ✅ Steps to Fetch All Products (1-Mark Points)

1. Create **Entity (Model)** class to map the Product table
2. Create **Repository** interface extending JPA Repository
3. Create **Service** class to handle business logic
4. Call `findAll()` method from repository inside service
5. Create **Controller** class to expose REST API
6. Add `@GetMapping` endpoint to fetch all products
7. Connect frontend/client to the API endpoint
8. Return data as JSON response to client  


# 📦 Step 1: Model (Entity Layer)

Represents the database table.

```java
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;
    private String brand;
    private BigDecimal price;
    private String category;
    private Date releaseDate;
    private boolean available;
    private int quantity;
}




```
# 📦 Step 2: Repository (Data Access Layer)

Handles database operations.

```java
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}



```
# 📦 Step 3: Service (Business Logic Layer)

Contains application logic.

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public List<Product> getAllProducts() {
        return repo.findAll();
    }
}