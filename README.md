# Hibernate Project: Database Management and Mapping

This project is a comprehensive exploration of Hibernate, a Java framework that simplifies the development of Java application to interact with the database. The primary objective is to understand the structure of a database, map entities to existing tables, and add minimal functionality to ensure the mapping is done correctly.

## Project Overview

The project revolves around a movie schema, with the main focus on creating necessary entity classes and mapping them to the tables within the schema. It involves implementing transactional methods that simulate real-world scenarios, such as a customer renting and returning a movie, and the production of a new film.

## Features

- **Customer Creation:** A transactional method that creates a new customer along with all dependent fields in the customer table, ensuring data consistency.
- **Movie Rental and Return:** Transactional methods that simulate a customer renting and returning a movie, providing a practical application of the database mappings.
- **New Film Production:** A transactional method that simulates the production of a new film and its availability for rent.

## Database Structure

The project utilizes existing tables within the movie schema. However, it also identifies and suggests improvements, such as adding missing foreign keys to ensure data integrity.

## Getting Started

To get the project up and running, follow these steps:

1. **Build the Docker Image:** Navigate to the directory containing the Dockerfile and `dump-hibernate-2.sql` using a terminal. Execute the following command to build the Docker image named `my-db`:

    ```bash
    docker build -t my-db .
    ```

2. **Run the Docker Container:** Execute the following command to run the Docker container using the `my-db` image:

    ```bash
    docker run --name my-db -d -p 3306:3306 my-db
    ```

This will create a Docker container with the MySQL database, import the SQL dump, and have it ready for use with the Hibernate project.

## Conclusion

This project serves as a practical guide to understanding Hibernate and its application in managing databases. It provides hands-on experience in mapping entities to database tables and implementing transactional methods to manipulate the data.
