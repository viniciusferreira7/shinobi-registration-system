# Shinobi Registration System

A Java-based web application built with Spring Boot that manages **ninjas** and **missions** using a clean layered architecture. It demonstrates CRUD operations, data validation, and relational mapping using modern tools like JPA, Hibernate, Flyway, Lombok, and an in-memory H2 database.

## 📦 Tech Stack

- **Java 17+**
- **Spring Boot**
- **Spring Data JPA**
- **Hibernate**
- **H2 Database** (in-memory for development)
- **Flyway** (database migration)
- **Swagger** (documentation)
- **Lombok**
- **Thymeleaf** (HTML templates)
- **Layered architecture** (Controller, Service, Repository, DTO, Model)

---

## 📁 Project Structure

```
   src/
   ├── main/
   │   └── java/dev/java10/ShinobiRegistrationSystem/
   │       ├── Ninjas/
   │       │   ├── NinjaModel.java         # Entity class mapped to the database
   │       │   ├── NinjaDTO.java           # Data Transfer Object for ninja data
   │       │   ├── NinjaController.java    # REST controller for ninjas
   │       │   ├── NinjaControllerUi.java  # REST and UI controller for ninjas
   │       │   ├── NinjaService.java       # Business logic layer
   │       │   ├── NinjaRepository.java    # Data access layer (Spring Data JPA)
   │       │   ├── NinjaMapper.java        # Converts between Model and DTO
   │       │   └── NinjaRank.java          # Enum defining ninja ranks
   │
   │       ├── Missions/
   │       │   ├── MissionModel.java       # Entity class for missions
   │       │   ├── MissionDTO.java         # Data Transfer Object for mission data
   │       │   ├── MissionController.java  # REST controller for missions
   │       │   ├── MissionControllerUi.java  # REST and UI controller for missions
   │       │   ├── MissionService.java     # Business logic layer
   │       │   ├── MissionRepository.java  # Data access layer
   │       │   ├── MissionMapper.java      # Converts between Model and DTO
   │       │   └── MissionRank.java        # Enum defining mission difficulty
```

## 🧠 Key Concepts

- **Layered Architecture:** Separates business logic (Service), data access (Repository), and presentation (Controller + Thymeleaf).
- **DTOs:** Prevents direct exposure of entity classes.
- **Mapping:** Uses custom mappers (`NinjaMapper`, `MissionMapper`) to convert between DTO and Model.
- **Flyway:** Manages versioned database schema migrations.
- **H2:** Provides a lightweight in-memory DB for development/testing.
- **Lombok:** Reduces boilerplate code using annotations like `@Data`, `@AllArgsConstructor`.

---

## 🧪 How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/shinobi-registration-system.git
   cd shinobi-registration-system
```

2. Build and run the project with Maven:

   ```bash
   mvn spring-boot:run
   ```

3. Access the app at:

   ```
   http://localhost:8080/swagger-ui/index.html
   http://localhost:8080/ninjas
   http://localhost:8080/missions
   ```

4. Access the H2 console (for development):

   ```
   http://localhost:8080/h2-console
   ```

---

## 🗃️ Example Features

* Create, view, update, and delete ninjas
* Assign ninjas to missions
* View mission participants
* Enum usage for `NinjaRank` and `MissionRank`

---

## 📄 License

This project is licensed under the MIT License. Feel free to use and modify it.