# @RestController Annotation (Spring Boot)

## What is @RestController?

@RestController is a Spring annotation used to create REST APIs.

It is a combination of:
- @Controller → marks the class as a Spring controller
- @ResponseBody → tells Spring to return data (JSON/XML) instead of a view (HTML)

So, instead of returning a webpage, it directly returns data.

---

## Why do we use it?

We use @RestController when:
- Building backend APIs
- Returning JSON data to frontend (React, Android, etc.)
- Creating RESTful services

---

## Where is it used?

It is used on top of a class (Controller class).

Example:
@RestController
public class ProductController {
// API methods here
}

---

## Example Code

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/")
    public String sayHello() {
        return "Hey";
    }
}

---

## How it works

1. Client sends request → GET /api/
2. Spring finds matching method
3. Method returns "Hey"
4. Spring automatically converts it into HTTP response
5. Output is sent directly to browser/Postman

---

## Without @RestController

@Controller
public class HelloController {

    @GetMapping("/")
    @ResponseBody
    public String sayHello() {
        return "Hey";
    }
}

👉 Here we must write @ResponseBody manually

---

## With @RestController

@RestController
public class HelloController {

    @GetMapping("/")
    public String sayHello() {
        return "Hey";
    }
}

👉 Cleaner and shorter (recommended)

---

## Summary

- @RestController = @Controller + @ResponseBody
- Used to build REST APIs
- Returns data (JSON), not HTML pages