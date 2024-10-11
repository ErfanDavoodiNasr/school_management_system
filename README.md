# 🏫 School Management System

Welcome to the **School Management System**! 🚀 This project is a **console-based Java application** that allows you to manage students, teachers, and courses in an educational institution.

## 💡 Project Overview

This system provides an interactive and user-friendly interface for three types of users:
- **Students** 👩‍🎓: Enroll, drop, and view your courses.
- **Admins** 👨‍💼: Add, update, or remove students, teachers, and courses.
- **Teachers** 👩‍🏫: (Coming Soon!) Manage your courses, view your students.

**Features**:
- Manage student enrollment and course registration.
- Admin control panel to manage users and courses.
- Secure login for each user type.

---

## 🚀 Getting Started

### Prerequisites
Make sure you have the following installed on your machine:
- **Java 17+** (for building and running the project)
- **Maven** (for managing dependencies)

### Installation

Clone this repository to your local machine:

```bash
gir clone https://github.com/ErfanDavoodiNasr/school_management_system.git
```

To compile and run the project:

```bash
javac Main.java
```

---

## 🔧 How to Use

### 1️⃣ Start the Application

Run the program with the command:

```bash
java Main
```

You will be greeted with a welcome screen:

```
**** welcome ****
1 - student setting
2 - admin setting
3 - teacher setting
4 - exit
```

### 2️⃣ Choose Your Role
- **1** for **Student**: Sign in, enroll in courses, or view your courses.
- **2** for **Admin**: Manage students, teachers, and courses.
- **3** for **Teacher**: (Coming Soon!)
- **4** to exit the application.

### 3️⃣ Student Features
Once logged in, as a **student**, you can:
- **Add Courses** 🎓
- **Remove Courses** 💼
- **View Your Courses** 📚
- **View All Available Courses** 🌍

### 4️⃣ Admin Features
Admins can:
- **Add, Update, or Remove Students** 👩‍🎓👨‍🎓
- **Add, Update, or Remove Teachers** 👩‍🏫
- **Add, Update, or Remove Courses** 📅

### 5️⃣ Teacher Features (Coming Soon)
- Manage your courses and view the students enrolled.

---

## 🔥 Features

### 👨‍💻 **Admin Dashboard**:
- **Manage Users**: Add, update, or remove students and teachers.
- **Course Management**: Create, edit, or delete courses and exams.

### 👩‍🎓 **Student Dashboard**:
- **Course Enrollment**: Add or drop courses with a simple command.
- **View Your Courses**: See the list of courses you’re enrolled in along with exam details.

### 🛡️ **Security & Authentication**:
- Each user type (student, admin, teacher) has a secure login system.
- Unique IDs and national codes are used for secure identification.

---

## ⚙️ Project Structure

Here's a brief overview of the key classes and packages:

```
src/
|-- ui/
|   |-- Runner.java                # Main runner class to start the application
|   |-- RunnerAdmin.java            # Admin interface and actions
|   |-- RunnerStudent.java          # Student interface and actions
|-- model/
|   |-- Student.java                # Student class
|   |-- Teacher.java                # Teacher class
|   |-- Course.java                 # Course class
|   |-- Exam.java                   # Exam class
|   |-- dto/CourseDto.java          # Data Transfer Object for Course
|-- util/
|   |-- ApplicationContext.java     # Application context for services
|   |-- Help.java                   # Utility functions (input, print, etc.)
|   |-- SecurityContext.java        # Security management (sign-in, sign-out)
```

---

## 🧑‍🤝‍🧑 Contributing

We welcome contributions to this project! 🤗 If you'd like to improve the project, please feel free to fork it and submit a pull request.

### How to Contribute:
1. Fork the repository.
2. Create your feature branch: `git checkout -b feature-name`.
3. Commit your changes: `git commit -am 'Add new feature'`.
4. Push to the branch: `git push origin feature-name`.
5. Submit a pull request.

---

## 🎉 Future Enhancements

- **Teacher Dashboard**: A fully functional interface for teachers to manage their courses and students.
- **Database Integration**: Add support for a database backend (e.g., MySQL or MongoDB) to persist data.
- **Graphical User Interface (GUI)**: Create a web or desktop GUI to replace the console interface.

---

## 🎨 Screenshots

**Student Menu**:
```
**** welcome ****
1 - student setting
2 - admin setting
3 - teacher setting
4 - exit
```

**Course Management**:
```
1 - add course
2 - remove course
3 - show my courses
4 - show all courses
5 - exit
```

