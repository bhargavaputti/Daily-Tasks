# UserJwt - Spring Boot JWT Authentication Example

This project demonstrates how to implement JWT (JSON Web Token) based authentication in a Spring Boot application using Spring Security.

---
## 🛠 Technologies Used

- Java 17+
- Spring Boot 3.x
- Spring Security 6.x
- JJWT (Java JWT)
- Maven
- H2 / JPA (for in-memory DB or switchable)

---

## 🚀 How It Works

### 🔑 Authentication Flow

1. User sends POST request to `/authenticate` with username and password.
2. `AuthController` uses `AuthenticationManager` to authenticate the user.
3. On success, a JWT token is generated and returned.
4. On subsequent requests:
   - JWT is passed in `Authorization: Bearer <token>` header.
   - `JwtAuthFilter` validates the token.
   - If valid, the user's Authentication is set in `SecurityContextHolder`.

---
