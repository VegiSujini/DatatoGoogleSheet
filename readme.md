# FIFA World Cup Data Extraction and Google Sheets Integration

This project automates the extraction of FIFA World Cup finals data from Wikipedia and appends it to a Google Sheet using Google Sheets API. Below are the details for setting up and running the project.

## Features
- Extracts data (Year, Winner, Score, Runners-up) from the first 10 rows of the "List of FIFA World Cup finals" table on Wikipedia.
- Appends the extracted data to a specified Google Sheet.

## Prerequisites

### Software Requirements
- Java 21
- Maven
- Spring Boot

### Libraries and Dependencies
The project uses the following dependencies:
- **Spring Boot Starter Web**: For REST API creation.
- **Jsoup**: For web scraping.
- **Google API Client Libraries**: For integrating with Google Sheets API.
- **Jackson**: For JSON processing.

### API and Credentials
- A Google Cloud project with Google Sheets API enabled.
- A service account JSON key file with access to the Google Sheet.

## Installation Steps

### 1. Clone the Repository
```bash
git clone <repository-url>
cd fifa-world-cup-scrape
```

### 2. Add Credentials
- Place the service account credentials JSON file (`credentials.json`) in `src/main/resources`.
- Update the file path in `GoogleSheetsService` to match your `credentials.json` location.

### 3. Configure Maven
Ensure the Maven dependencies in `pom.xml` are up-to-date:
```xml
<dependencies>
    <!-- List of dependencies, refer to pom.xml in this project -->
</dependencies>
```

### 4. Update Spreadsheet ID and Range
- Open `GoogleSheetsService.java`.
- Update the `SPREADSHEET_ID` and `RANGE` with your Google Sheet ID and target range.

## Project Structure
- **controller**: Contains `DataController` to handle API requests.
- **dto**: Contains `MatchDetails` class for storing match information.
- **service**: Contains `ScraperService` for scraping data and `GoogleSheetsService` for interacting with Google Sheets.
- **resources**: Store application configurations and credentials.
- **pom.xml**: Lists project dependencies.

## Running the Application

### 1. Build the Project
Run the following command to build the project:
```bash
mvn clean install
```

### 2. Run the Application
Use the command below to start the Spring Boot application:
```bash
mvn spring-boot:run
```

### 3. Access the API
Use a tool like **Postman** to send a POST request to the API endpoint:
```http
POST http://localhost:8080/append
Content-Type: application/json

[
    ["Year", "Winner", "Score", "Runners-up"],
    ["1930", "Uruguay", "4–2", "Argentina"],
    ...
]
```

## Workflow Overview
1. **ScraperService**: Scrapes FIFA World Cup data from Wikipedia using Jsoup.
2. **GoogleSheetsService**: Authenticates with Google Sheets API using service account credentials and appends data to the sheet.
3. **DataController**: Handles the POST request and orchestrates the services.

## Google Sheets API Setup

### 1. Enable Google Sheets API
- Visit the [Google Cloud Platform](https://console.cloud.google.com/).
- Create a new project and enable the Google Sheets API.

### 2. Create a Service Account
- Generate a service account key (JSON) and download it.
- Share your target Google Sheet with the service account email.

## Flowchart
A detailed flowchart illustrating the steps from scraping to appending data to Google Sheets is included in the documentation folder.

## Contributing
- Fork the repository.
- Create a feature branch.
- Submit a pull request.

## License
This project is licensed under the MIT License. See the LICENSE file for details.

## Contact
For issues or support, feel free to reach out via email or create an issue in the repository.
