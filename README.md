# Library Management System

This is a full-stack web application built for learning and practice purposes.
It allows managing books, authors, and loans in a simple and functional way.

The project is structured as a monorepo, containing both the backend and frontend in a single repository.

---

## Technologies Used

### Backend

* Java
* Spring Boot
* REST API
* Maven

### Frontend

* Angular
* TypeScript
* HTML
* CSS

### Database

* H2 (in-memory database for development)

---

## Project Structure

```
/Backend              → Spring Boot API  
/library-frontend     → Angular application  
```

---

## Features

* Manage books (create, update, delete)
* Manage authors (prevents duplicates at backend level)
* Search authors dynamically when creating books
* Manage users
* Handle book loans and returns
* Backend validation and business logic

---

## How to Run the Project

### 1. Clone the repository

```
git clone https://github.com/YOUR_USERNAME/YOUR_REPOSITORY.git
cd YOUR_REPOSITORY
```

---

### 2. Run Backend

```
cd Backend
mvn spring-boot:run
```

Backend runs on:

```
http://localhost:8080
```

---

### 3. Run Frontend

```
cd library-frontend
npm install
ng serve
```

Frontend runs on:

```
http://localhost:4200
```

---

## API Endpoints (Examples)

* GET /api/libros
* POST /api/libros
* DELETE /api/libros/{id}
* POST /api/prestamos
* POST /api/prestamos/devolver

---

## Notes

* The backend prevents duplicate authors automatically.
* Dates are handled using the format `yyyy-MM-dd`.
* This project is intended for educational and portfolio use.

---

## Future Improvements

* Integration with a persistent database (MySQL or PostgreSQL)
* UI/UX improvements

---

## Author

Andrew Bedoy
