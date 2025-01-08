# Document Management System (DMS)

This project is a **Document Management System (DMS)** built using **Spring Boot**. It provides RESTful APIs to manage documents in a centralized system. The system allows for creating, updating, deleting, and retrieving documents.

## Features

- **Create Document**: Add a new document with metadata such as title, author, and language.
- **Get Document by ID**: Retrieve a document based on its unique ID.
- **Get All Documents**: Retrieve a list of all documents in the system.
- **Update Document**: Modify an existing document's details.
- **Delete Document**: Remove a document from the system.

## Technologies Used

- **Java 17**
- **Spring Boot 3.4.1**
- **Spring Web** (for RESTful API)
- **Spring Data JPA** (for database operations)
- **PostgreSQL** (for database)
- **Lombok** (for reducing boilerplate code)

## Project Setup

### Prerequisites

- JDK 17 or above
- Maven
- PostgreSQL
- IDE like IntelliJ IDEA or Eclipse

### Steps to Run

1. Clone the repository:

   ```bash
   git clone https://github.com/yourusername/dms-project.git
   ```

2. Navigate to the project directory:

   ```bash
   cd dms-project
   ```

3. Configure **PostgreSQL** database:
   - Create a PostgreSQL database for the project.
   - Update the `application.properties` file with the database connection details.

   Example configuration:

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/dms_db
   spring.datasource.username=your-username
   spring.datasource.password=your-password
   spring.jpa.hibernate.ddl-auto=update
   ```

4. Build and run the project using Maven:

   ```bash
   mvn spring-boot:run
   ```

5. The application will be available at `http://localhost:8080`.

## API Endpoints

### 1. **Create a Document**

- **POST** `/api/document`
- Request Body (JSON):

  ```json
  {
      "documentTitle": "Sample Document",
      "author": "John Doe",
      "language": "English"
  }
  ```

- Response:

  ```json
  {
      "id": 1,
      "documentTitle": "Sample Document",
      "author": "John Doe",
      "language": "English"
  }
  ```

### 2. **Get a Document by ID**

- **GET** `/api/document/{id}`
- Example Request: `/api/document/1`

- Response:

  ```json
  {
      "id": 1,
      "documentTitle": "Sample Document",
      "author": "John Doe",
      "language": "English"
  }
  ```

### 3. **Get All Documents**

- **GET** `/api/document`

- Response:

  ```json
  [
      {
          "id": 1,
          "documentTitle": "Sample Document",
          "author": "John Doe",
          "language": "English"
      },
      {
          "id": 2,
          "documentTitle": "Another Document",
          "author": "Jane Doe",
          "language": "French"
      }
  ]
  ```

### 4. **Update a Document**

- **PUT** `/api/document/{id}`
- Example Request: `/api/document/1`
- Request Body (JSON):

  ```json
  {
      "documentTitle": "Updated Document Title",
      "author": "John Smith",
      "language": "English"
  }
  ```

- Response:

  ```json
  {
      "id": 1,
      "documentTitle": "Updated Document Title",
      "author": "John Smith",
      "language": "English"
  }
  ```

### 5. **Delete a Document**

- **DELETE** `/api/document/{id}`
- Example Request: `/api/document/1`

- Response:

  ```json
  {
      "message": "Document deleted successfully!"
  }
  ```

## Folder Structure

- **src/main/java/com/tcs/dms/controller**: Contains the API controller for handling HTTP requests.
- **src/main/java/com/tcs/dms/dto**: Contains the Data Transfer Object (DTO) classes for transferring data.
- **src/main/java/com/tcs/dms/service**: Contains the service layer logic for business operations related to document management.
- **src/main/resources**: Contains application properties and configurations.

## Database Configuration

This project uses **PostgreSQL** as the database for storing document information. The PostgreSQL database should be configured in `application.properties` as shown below:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/dms_db
spring.datasource.username=your-username
spring.datasource.password=your-password
spring.jpa.hibernate.ddl-auto=update
```

## Future Enhancements

- **Authentication & Authorization**: Add JWT-based authentication and role-based authorization for secure access to document APIs.
- **File Upload**: Add support for uploading and storing document files.
- **Search Functionality**: Implement search functionality based on document title, author, or language.
- **Global Exception Handling**: Implement Exception Handling Based on valrous validations on Global/Project level.

## Contribution Guidelines

We welcome contributions to improve the functionality of the Document Management System.

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/your-feature-name`).
3. Make your changes.
4. Commit your changes (`git commit -m 'Add new feature'`).
5. Push to the branch (`git push origin feature/your-feature-name`).
6. Create a pull request.

---
