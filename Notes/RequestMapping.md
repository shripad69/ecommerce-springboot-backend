# @RequestMapping Annotation (Spring Boot)

## What is @RequestMapping?

@RequestMapping is used to map HTTP requests (URLs) to a controller class or method.

It tells Spring:
👉 "When this URL is called, run this method"

---

## Why do we use it?

We use @RequestMapping to:
- Define API endpoints (URLs)
- Handle client requests
- Organize routes in backend

---

## Where is it used?

It can be used in two places:

1. On Class → to define base URL
2. On Method → to define specific endpoint

---

## Example Code

@RestController
@RequestMapping("/api")   // Base URL
public class HelloController {

    @RequestMapping("/hello")   // Endpoint
    public String sayHello() {
        return "Hey";
    }
}

👉 Final URL: /api/hello

---

## How it works

1. Client sends request → /api/hello
2. Spring matches URL with @RequestMapping
3. Method runs
4. Response is returned

---

## HTTP Methods in @RequestMapping

By default, it supports ALL methods (GET, POST, etc.)

You can restrict it:

@RequestMapping(value = "/hello", method = RequestMethod.GET)

---

## Shortcut Annotations (Recommended)

Instead of @RequestMapping, we use:

- @GetMapping    → for GET
- @PostMapping   → for POST
- @PutMapping    → for UPDATE
- @DeleteMapping → for DELETE

---

## Example with Shortcut

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hey";
    }
}

---

## Summary

- @RequestMapping maps URL to methods
- Can be used on class and method level
- Supports all HTTP methods
- Shortcut annotations are preferred