#BOOK MANAGEMENT SYSTEM
=======================

This is a Java-based desktop application that enables users to perform CRUD (Create, Read, Update, Delete) operations on a book database. The application is built using Java Swing for the user interface and MySQL as the backend database. It follows the MVC (Model-View-Controller) design pattern to maintain a clean and modular codebase.

#TECHNOLOGIES USED
-----------------
- Java (Swing) – for creating the GUI
- MySQL – for data storage
- JDBC – for database connectivity
- MVC Design Pattern – to separate data, logic, and UI

#FEATURES
--------
- Add new books to the database
- Update existing book details
- Delete books from the list
- Search for books by ID
- Display all books in a table
- Simple, responsive, and user-friendly interface

#PROJECT STRUCTURE
-----------------
BookshopMVC/
│
├── main/
│   └── Main.java                -> Launches the application
│
├── controller/
│   └── BookController.java      -> Handles application logic and UI interaction
│
├── dao/
│   └── BookDAO.java             -> Handles database operations (JDBC)
│
├── model/
│   └── Book.java                -> Represents the Book object
│
└── view/
    └── BookForm.java            -> GUI using Java Swing

#DATABASE SETUP
--------------
1. Create a MySQL database named 'bookshop'.
2. Run the following SQL command to create the table:

   CREATE TABLE book (
       id INT PRIMARY KEY AUTO_INCREMENT,
       name VARCHAR(100),
       edition VARCHAR(50),
       price DOUBLE
   );

3. Open 'BookDAO.java' and update the MySQL connection details:

   String url = "jdbc:mysql://localhost:3306/bookshop";
   String user = "your_mysql_username";
   String password = "your_mysql_password";

#HOW TO RUN
----------
1. Download or clone the project files.
2. Open the project in your preferred IDE (Eclipse, IntelliJ, etc.).
3. Make sure MySQL is running and the 'bookshop' database is set up.
4. Run Main.java to launch the application.

#LICENSE
-------
This project is open for educational and learning purposes. You may use or modify the code as needed.
