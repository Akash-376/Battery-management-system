<h1 align="center"> Nunam Battery Monitoring System</h1>

<img src="https://i.ytimg.com/vi/w1VjDBhL82k/hq720.jpg?sqp=-oaymwEhCK4FEIIDSFryq4qpAxMIARUAAAAAGAElAADIQj0AgKJD&rs=AOn4CLB220PBDbEOUsKkWmK0gCdezmCKyQ" alt="Image Description" width="100%" height="350">

<p align="center">
  <b>This Java project provides a RESTful API for monitoring battery data, including current, voltage, and temperature. The project is built using Spring Boot and integrates with a MySQL database for data storage. Swagger documentation is available for easy API exploration.</b>
</p>

## Table of Contents
- [Prerequisites](#prerequisites)
- [Frameworks-and-Libraries-Used](#frameworks-and-Libraries-Used)
- [Installation](#installation)
- [Configuration](#configuration)
- [Running-the-Application](#running-the-Application)
- [API-Endpoints](#api-Endpoints)
- [Usage](#usage)

## Prerequisites
Before you begin, ensure you have met the following requirements:

- Java: You need Java 8 or higher installed on your system.
- MySQL: Make sure you have a MySQL database instance set up.
- Maven: You'll need Maven as the build tool.

## Frameworks_and_Libraries_Used
- Spring Boot: A powerful framework for building Java applications.
- Swagger: Used for API documentation.
- Hibernate: Object-relational mapping library.
- Apache HttpClient: For making HTTP requests.
- Lombok: For reducing boilerplate code.
- Jackson: For JSON serialization and deserialization.

## Installation
1. Clone the repository:
```
git clone <https://github.com/Akash-376/Battery-management-system.git>
```
2. Navigate to the project directory:
   In which POM.xml is visible
```
cd Battery-management-system
```
3. Build the project using Maven:
```
mvn clean install
```

## Configuration
1. Create the database named 'nunam_batteries' using MySQL Workbench
2. Open application.properties in the src/main/resources directory.
3. Configure your database settings:
```
spring.datasource.url=jdbc:mysql://localhost:3306/nunam_batteries
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=root
```
Replace username and password with yours.

## Running the Application
1. Run the application using Maven:
```
mvn spring-boot:run
```
2. The application should now be running on the specified port (default is 8080).

## API Endpoints
Swagger documentation is available at http://localhost:8088/swagger-ui.html. You can use it to explore and test the API endpoints.

## Usage
### Creating a New Battery
To create a new battery instance, send a POST request to:
```
http://localhost:8080/nunam/battery
```
Note: In the payload, you only need to send the battery model (data type: String) in the format provided below.
```
{
    "battery_model":"abc"
}
```

### Retrieving Detailed Information about a Battery
To retrieve detailed information about a specific battery, send a GET request to:
```
http://localhost:8080/nunam/battery/{batteryId}
```
### Starting Data Transmission from a Battery
To start sending data from a battery, send a POST request to:
```
http://localhost:8080/nunam/battery/startsendingdata/{batteryId}
```
### Retrieving All Data Entries of a battery
To retrieve all data for a specific battery, send a GET request to:
```
http://localhost:8080/nunam/battery/info/{batteryId}
```
### Retrieving the Latest Voltage Record
To retrieve the latest voltage record for a specific battery, send a GET request to:
```
http://localhost:8080/nunam/battery/voltage/{batteryId}
```
### Retrieving the Latest Current Record
To retrieve the latest current record for a specific battery, send a GET request to:
```
http://localhost:8080/nunam/battery/current/{batteryId}
```
### Retrieving the Latest Temperature Record
To retrieve the latest temperature record for a specific battery, send a GET request to:
```
http://localhost:8080/nunam/battery/temperature/{batteryId}
```
### Retrieving Battery Data Entries Within a Time Range
To retrieve battery data entries within a specific time range, send a GET request to:
```
http://localhost:8080/nunam/battery/track/{batteryId}/{startTime}/{endTime}
```
Example of time : 2023-08-31T21:10:17

Replace {batteryId}, {startTime}, and {endTime} with the appropriate values.

## Contact

We appreciate your interest in Nunam Battery Monitoring System. If you have any questions, feedback, or need support, you can reach out to us through the following channels:

- **Email**: For general inquiries or support, you can contact us at akchauhan376@gmail.com. 📧

- **LinkedIn**: Connect with us on LinkedIn to stay updated on the latest news and announcements. [LinkedIn Profile](https://www.linkedin.com/in/akash-chauhan-729184247/) 🔗


---

<p align="center">
  🙏🏻🙏🏻🙏🏻<br>
  <b> Nunam Battery Monitoring System</b>
</p>

---




























