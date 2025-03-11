# MovieRepository
MovieRepository is a Java Spring Boot application designed to manage and organize a movie database efficiently. The application leverages modern technologies to provide scalability, reliability, and ease of deployment using containerization.

## Tech Stack
- Language: Java 21

- Framework: Spring Boot

- Build Tool: Maven

- Database: PostgreSQL

- Database Migration Tool: Flyway

- Containerization: Docker, Docker Compose

## How to Run Locally
1. **Clone the Repository**
- Clone the repository to your local machine:
```bash
git clone https://github.com/mLastovsky/MovieRepository.git
cd MovieRepository
```

2.**Create a .env File**
- Create a file named .env in the root directory of the project and add the following variables:

```env
DB_NAME=my_database
DB_USER=my_user
DB_PASSWORD=my_password
```

3. **Run with Docker Compose**
- Ensure Docker and Docker Compose are installed. Then, execute the following command to build and start the application:
```bash
docker-compose up --build
```
The application will be available at http://localhost:8080.
