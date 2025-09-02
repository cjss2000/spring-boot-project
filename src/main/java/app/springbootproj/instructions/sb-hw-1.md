# 📝 Take-Home Assignment: Jelly Bean CRUD API (Spring Boot, In-Memory)

Design and implement a small Spring Boot REST service that manages **JellyBeans** in memory using an `ArrayList`.  
This assignment is **instructions-only**: follow the steps precisely, but do **not** paste these instructions into your application code.

---

## 🎯 Objectives

1. **Remove** the existing `GET /hello` endpoint.
2. Extend the `JellyBean` model with an `id` field.
3. Create a **service interface** declaring CRUD operations for JellyBeans.
4. Implement the interface in a **service class** that uses an in-memory `ArrayList`.
5. Expose **REST endpoints** for full CRUD via a controller.
6. Add **logic in the controller** to generate a random `id` when a new bean is created.
7. Provide **clear status codes** and **JSON response shapes**.

> Constraint: No database or external storage. Data lives only in memory for the life of the application process.

---

## 🧱 Starting Point

You have:
- A Spring Boot project
- A `JellyBean` POJO with `color`, `flavor`
- A `JellyBeanController` with `GET /hello`

---

## 1) Update the Model

- **File:** `app/springbootproj/JellyBean.java`
- **Fields to keep/add:**
    - `String id` (new field, will hold a generated unique id)
    - `String color`
    - `String flavor`
- **Annotations:** Keep Lombok annotations already present (`@Getter`, `@Setter`, `@ToString`, etc.)

**Important:**  
Do not generate the `id` in the model itself. The controller will handle `id` generation when creating new beans.

---

## 2) Create a service interface (contract)

- **File to create:** `app/springbootproj/JellyBeanService.java`
- **Type:** `interface`
- **Purpose:** Describe what operations the app supports — **no code inside methods**, only method **signatures** and **JavaDoc** explaining behavior.

**Required methods (signatures only — no bodies here):**
- `JellyBean add(JellyBean bean);`
    - Adds the bean to the list and returns the stored bean.
- `List<JellyBean> getAll();`
    - Returns all beans stored.
- `Optional<JellyBean> getById(String id);`
    - Retu**rns the bean** with the given id, or empty if not found.
- `Optional<JellyBean> replace(String id, JellyBean bean);`
    - Replaces `color` and `flavor` of the bean with this id. Returns updated bean if found.
- `boolean deleteById(String id);`
    - Removes the bean with the given id. Returns `true` if something was removed.
- `void deleteAll();`
    - Clears the whole list.

**JavaDoc to include:**
- What each method does in 1–2 sentences.
- What happens if the id is not found (e.g., return `Optional.empty()` or `false`).
- That `replace` **does not** create a new item — it only updates an existing one.

**I think you might not be familiar with Optional yet, so you might want to give this one a read:**

Intro to Optional in Java 8 (Baeldung):
👉 https://www.baeldung.com/java-optional

Official Oracle docs:
👉 https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html
---

## 3) Implement the service with an ArrayList

- **File to create:** `app/springbootproj/JellyBeanServiceImpl.java`
- **Type:** `class`
- **Annotations:** Add `@Service` on the class so Spring can find it.
- **Implements:** `JellyBeanService`

**Required elements (describe, don’t implement here):**
- A private field: `ArrayList<JellyBean>` to store items in memory.
- A **no-args constructor** (or default) that initializes the list.
- Implement each interface method by operating on the ArrayList:
    - `add`: append to the list; return the same bean that was added.
    - `getAll`: return a copy of the list.
    - `getById`: search for a bean with the given `id`. If not found, return empty.
    - `replace`: search for a bean with the given `id`; if found, update its `color` and `flavor`.
    - `deleteById`: search for a bean with the given `id` and remove it.
    - `deleteAll`: clear the list.

---

## 4) Create a REST controller for CRUD

- **File to create:** `app/springbootproj/JellyBeanController.java`
- **Annotation on class:** `@RestController`
- **Base mapping:** `@RequestMapping("/jellybeans")`
- **Constructor injection:** Add a constructor that receives a `JellyBeanService` so Spring injects it.

**Important:**  
The controller must generate a random `id` when a new JellyBean is created.
- Use `UUID.randomUUID().toString()` to generate an id.
- Assign the id to the bean before calling the service’s `add` method.

---

## 5) Endpoints to implement

1) **Create**
    - **HTTP:** `POST /jellybeans`
    - **Input:** JSON body with `color`, `flavor`
    - **Controller responsibility:** Generate a random `id`, set it on the bean, then pass it to the service.
    - **Output:** The stored bean as JSON (including generated `id`)
    - **Status:** `201 Created`

2) **Read all**
    - **HTTP:** `GET /jellybeans`
    - **Output:** JSON array of beans (may be empty)
    - **Status:** `200 OK`

3) **Read one (by id)**
    - **HTTP:** `GET /jellybeans/{id}`
    - **Path variable:** `id` is a string
    - **Output:** JSON bean
    - **Status:** `200 OK` if found, otherwise `404 Not Found`

4) **Update (replace color & flavor by id)**
    - **HTTP:** `PUT /jellybeans/{id}`
    - **Input:** JSON body with new `color`, `flavor`
    - **Output:** Updated bean as JSON
    - **Status:** `200 OK` if updated, `404 Not Found` if id invalid

5) **Delete one (by id)**
    - **HTTP:** `DELETE /jellybeans/{id}`
    - **Status:** `204 No Content` if deleted, `404 Not Found` if id invalid

6) **Delete all**
    - **HTTP:** `DELETE /jellybeans`
    - **Status:** `204 No Content`

**You would need to read these articles first**

ResponseEntity (Spring Boot)

Beginner guide with examples (Baeldung):
👉 https://www.baeldung.com/spring-response-entity

Official Spring docs on ResponseEntity:
👉 https://docs.spring.io/spring-framework/reference/web/webmvc/mvc-controller/ann-methods/responseentity.html
---

## 6) Beginner-level input validation

You can choose **one** of these simple approaches:

- **Option A (annotations):**  
  Add `jakarta.validation` annotations like `@NotBlank` to `color` and `flavor`, and use `@Valid` in controller method parameters.
- **Option B (manual checks):**  
  In controller methods that accept a request body, check if `color` or `flavor` is null/blank. If invalid, return `400 Bad Request`.

---

## 7) HTTP status codes (what to return)

- **201 Created** → After a successful `POST /jellybeans`
- **200 OK** → Successful `GET` or `PUT` returning a body
- **204 No Content** → Successful `DELETE`
- **400 Bad Request** → Invalid input (e.g., blank `color` or `flavor`)
- **404 Not Found** → No bean exists with that `id`

---

## 8) Test with postman

## Additional reading materials: 

JSON Basics

What JSON is (w3schools):
👉 https://www.w3schools.com/js/js_json_intro.asp

JSON Syntax and Examples:
👉 https://www.json.org/json-en.html

 Spring Boot REST Returning JSON

Simple example:
👉 https://spring.io/guides/gs/rest-service/

How Spring Boot automatically converts objects to JSON:
👉 https://www.baeldung.com/spring-boot-formatting-json-responses