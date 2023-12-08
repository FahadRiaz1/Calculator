# Calculator Project

## Overview

This calculator application, developed by Fahad Riaz, is a versatile tool capable of evaluating both Reverse Polish Notation (RPN) and standard infix mathematical expressions. The application is built using JavaFX for a user-friendly graphical interface and features an implementation of the Shunting Yard algorithm for infix expression evaluation.

## Features

- **Two Modes of Calculation:** 
  - Reverse Polish Notation (RPN)
  - Standard Infix (with operator precedence)
- **Graphical User Interface:** Built with JavaFX, providing an intuitive and easy-to-use interface.
- **Error Handling:** Robust error handling for invalid expressions, including checks for insufficient operands and invalid operators.
- **Literate Programming:** Extensive use of Javadoc for easy understanding and modification of the code.
- **Compliance with Programming Standards:** Adheres to Google's Java coding standards, enforced with Checkstyle.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 11 or higher
- Maven (for dependency management and building the project)

### Installation

1. Clone the repository
2. Navigate to the project directory
3. Build the project with Maven:  mvn clean install (If this fails, please change jacoco line ratio from 0.9 to 0.8 in pom file)


### Running the Application

After building the project, run the application using the following command:
java -jar target/Calculator-1.0-SNAPSHOT-jar-with-dependencies.jar



## Usage

- Select the desired calculation mode (RPN or Standard) using the toggle buttons.
- Enter your expression in the input field.
- Click the "Calculate" button to see the result in the answer field.

## Development

### Testing

The application includes a comprehensive suite of unit tests, ensuring the accuracy and reliability of calculations. Tests are written following Test-Driven Development (TDD) principles.

### Customization

The application's appearance can be customized via the provided CSS file (`application.css`). The FXML file (`view.fxml`) defines the layout and can be modified for further customization.

### Design Patterns

This project utilizes several design patterns, including:
- **Factory Pattern:** Used for creating calculator instances.
- **MVC Pattern:** For separating the application logic, UI, and user input handling.

## Contributions

Contributions to the project are welcome. Please follow the existing coding standards and include tests for any new features or bug fixes.

## Known Issues and Future Enhancements

- **Complex Expressions Handling:** Currently, the application may struggle with extremely complex expressions, especially those containing numerous nested brackets. This can lead to incorrect calculations or errors.
- **Expression Type Handling in Standard Calculator:** The standard calculator mode incorrectly processes expressions formatted in Reverse Polish Notation (RPN), which should ideally be exclusive to the RPN mode.

### Future enhancements 
- Future enhancements could include additional functionalities like scientific calculations.
- **Improved Parsing Algorithm:** Enhancement of the expression parsing algorithm to accurately handle more complex and deeply nested expressions.
- **Mode-Specific Expression Validation:** Implementing stricter validation in standard calculator mode to ensure only appropriate infix expressions are processed.



## Developer

Fahad Riaz






