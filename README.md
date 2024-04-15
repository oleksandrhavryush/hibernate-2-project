# Project Description
This project focuses on Hibernate. The main objective is to understand the database structure, map entities to existing tables, and add minimal functionality to verify that the mapping is done correctly.

## Project Details
**Objective:** The main objective is to create all necessary entity classes and map them to the tables of the movie schema.

### Functionality:
- **Create New Customer:** Implement a method that creates a new customer along with all dependent fields in the customer table. Ensure that the method is transactional to avoid inconsistencies.
- **Customer Return Rental:** Add a transactional method describing the event where a customer returns a previously rented movie.
- **Customer Rent Inventory:** Implement a transactional method describing the event where a customer goes to a store, rents inventory, and makes a payment to the staff.
- **Production of New Film:** Add a transactional method describing the event where a new film is produced and made available for rent.

## Database Structure
The project utilizes existing tables within the movie schema. However, there are some improvements suggested, such as adding foreign keys to ensure data integrity.

## Additional Notes
- A foreign key constraint is missing in the film_text table, indicating a potential data integrity issue. Other similar discrepancies need to be identified and documented in the project's root directory in the form of a README file.
