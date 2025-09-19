# Demo Spring Boot Project – Course Management API

## **Project Overview**
Ye project ek simple **Course Management API** hai, jo Spring Boot aur H2 in-memory database ka use karta hai.  
API **role-based access** provide karti hai:  

- **Student**: Limited course details.  
- **Teacher / Developer / Content Developer**: Full course details.  

Ye project CRUD operations support karta hai aur easily extendable hai.

---

## **Technologies Used**
- Java 17  
- Spring Boot 3  
- Spring Data JPA  
- H2 Database (In-memory)  
- Lombok  
- Maven  

---

## **Project Structure**
src/main/java/com/example/demo
│
├── DemoApplication.java # Main Spring Boot application
├── controller
│ └── CourseController.java # REST API controller
├── model
│ └── Course.java # Course entity
├── repository
│ └── CourseRepository.java # JPA repository
└── dto
└── StudentCourseDTO.java # DTO for student view


---

## **APIs**

### 1️⃣ Create Course
POST /course/create
Body:
{
"courseName": "Java Basics",
"subject": "Programming",
"numberOfChapters": 10,
"type": "Personalised",
"mode": "Self-learning"
}


### 2️⃣ Update Course
PUT /course/update/{id}
Body: Updated course object


### 3️⃣ Get Courses (Role-based)
GET /course/get?role=student
GET /course/get?role=teacher
GET /course/get?role=developer

Features

CRUD operations for Courses

Role-based access for students, teachers, and developers

Easy to extend for additional roles or APIs

Uses H2 in-memory database for quick development/testing

Author

Avinash Gupta

