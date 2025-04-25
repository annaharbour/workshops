# 📚 LibraryApp

A simple Java console-based library management system that allows users to check out and return books.

## 🧾 Features

- View available books
- View checked-out books
- Check out a book by entering your name
- Check in a book by providing its ID
- Input validation and clean user prompts
- Object-oriented structure for scalability

---

## 📘 Book.java Class Overview

The `Book` class represents a book in the system with the following properties:

- `id`: Unique identifier
- `isbn`: ISBN number
- `title`: Title of the book
- `isCheckedOut`: Status of the book
- `checkedOutTo`: Name of the person who checked out the book

---

## 🚀 Getting Started

### Prerequisites

- Java 8 or above
- A Java IDE (like IntelliJ IDEA, Eclipse) or terminal access

### Running the Application

1. Clone this repository or download the `.java` files.
2. Ensure both `LibraryApp.java` and `Book.java` are in the same package (`com.pluralsight`).
3. Compile the code:

    ```bash
    javac com/pluralsight/*.java
    ```

4. Run the program:

    ```bash
    java com.pluralsight.LibraryApp
    ```




