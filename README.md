# Employee Management System

## Overview

Employee Management System is a Java-based console application that performs employee record management using JDBC and MySQL.

## Features

* Add Employee
* Search Employee By ID
* Search Employee By Name
* Update Employee Salary
* Delete Employee
* View All Employees
* Count Employees
* Sort Employees By Salary

## Technologies Used

* Java
* JDBC
* MySQL
* Object-Oriented Programming (OOP)

## Database

Database Name:
employee_db

Table:
employee

Columns:

* id
* name
* department
* salary

## Project Structure

EmployeeManagementSystem
├── Employee.java
├── DBConnection.java
├── EmployeeDAO.java
├── Main.java
└── lib/mysql-connector-j-9.6.0.jar

## How to Run

1. Compile:

javac -cp ".;lib\mysql-connector-j-9.6.0.jar" *.java

2. Run:

java -cp ".;lib\mysql-connector-j-9.6.0.jar" Main

## Learning Outcomes

* JDBC Connectivity
* CRUD Operations
* MySQL Integration
* Java OOP Concepts
* Menu Driven Applications
