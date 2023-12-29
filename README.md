![Project Logo](https://www.slotsuk.co.uk/images/local/misc/playtechplaytechlogopng1.png)
# Playtech Sports Server

This server provides statistics about football players, allowing users to access information about various players, their teams, and performance metrics.

## Table of Contents

- [Introduction](#introduction)
- [Purpose](#Purpose)
- [Key Features](#key-features)
- [Limitations](#limitations)
- [Why Choose the Playtech Sports Server Solution?](#Solutions)
- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Technologies Used](#technologies-used)
    - [Installation](#installation)
- [Endpoints](#endpoints)

## Introduction

The Football Player Statistics Server is designed to provide comprehensive statistics and information about football players. Whether you're an enthusiast, researcher, or developer, this server offers a centralized platform to access detailed insights into the performance of various football players.

## Purpose
The primary purpose of this project is to:

- Aggregate and present statistical data for a wide range of football players.
- Facilitate easy access to player profiles, including details on teams, positions, rankings, and performance metrics.

## Key Features

- **Player Listing:** Retrieve a comprehensive list of all football players available in the database.


- **Player Statistics:** Access detailed statistics for a specific player by providing their unique identifier (playerId).


By providing these features, the Football Player Statistics Server aims to offer a user-friendly and versatile solution for accessing valuable football player information.

Feel free to explore the server, discover insights about your favorite players, and leverage the filtering options to tailor your search based on specific preferences. Whether you're a fan looking for player details or a developer integrating football player statistics into your application, this server has you covered.

## Limitations

- No endpoint to save the player data.
- No endpoint to update the player data.
- No endpoint to delete the player data.
- Unable to filter and search for players based on specific criteria, such as team affiliation, playing position, or overall ranking.

## Why Choose the Playtech Sports Server Solution?

1. **Centralized Platform:**
    - By creating a centralized platform for football player statistics, the Playtech Sports Server streamlines access to valuable insights, eliminating the need to navigate multiple sources.


2. **Scalability and Flexibility:**
    - The chosen solution is designed with scalability and flexibility in mind, accommodating potential future enhancements and the inclusion of additional features.


3. **Swagger API Documentation:**
    - The inclusion of Swagger API documentation enhances the developer experience, providing clear and interactive documentation for API endpoints.


4. **Gradle Build System:**
    - The use of the Gradle build system simplifies project management, dependency resolution, and builds, contributing to a more efficient development process.


5. **MongoDB Integration:**
    - Integration with MongoDB offers a robust and scalable database solution, suitable for storing football player data and supporting future data management requirements.


6. **Open Source Libraries:**
    - Leveraging open-source libraries, such as Spring Boot and Springdoc, ensures that the project benefits from a community-driven ecosystem, regular updates, and proven solutions.


7. **Clear Project Structure:**
    - The project adheres to a clear and organized structure, facilitating collaboration, maintenance, and future development.

## Getting Started

To set up and run the Playtech-Sports-Server project locally on your machine, follow these steps:

### Prerequisites

Make sure you have the following installed on your machine:

- Java Development Kit (JDK) 17 or later
- Gradle
- MongoDB


### Technologies Used

The Playtech Sports Server is built using the following technologies:

- Java: Version 17
- Spring Boot: Version 3.2.0
- Swagger: API documentation tool
- MongoDB: NoSQL database
- Gradle: Build and dependency management tool
- Postman
- MongoDB Compass

### Installation

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/yourusername/Playtech-Sports-Server.git

- Open application.yml file and change the Database information.


- Navigate to the Project Directory using CMD or Terminal:
    - cd Playtech-Sports-Server


- Build the Project:
    - gradle build


- Run the jar file:
    - java -jar build/libs/Playtech-Sports-Server-0.0.1-SNAPSHOT.jar

2. **Access to the Swagger API Documentation.**

      ```bash
      http://localhost:8081/swagger-ui/index.html

## Endpoints

### Player Listing

- **Endpoint:** `/api/players`
- **Method:** GET
- **Description:** Retrieve a lightweight list of all football players.
- **Example:** `GET /api/players`

*Get All Players output*

![All Players](/src/main/resources/static/All_Players.png)

### Player Statistics

- **Endpoint:** `/api/player/{playerId}`
- **Method:** GET
- **Description:** Retrieve detailed statistics for a specific player.
- **Example:** `GET /api/player/5583`

*Get Player By ID output*

![All Players](/src/main/resources/static/Player_By_Id.png)