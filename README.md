# Amazon Automation Testing Assignment

---

## Introduction

### User Story
As a client, I want to perform various actions such as searching, adding, and buying different products on www.Amazon.in.

### Problem Statement
Without a framework, writing test cases for the given user story results in code duplication and increased effort. Each test case requires redundant code to find elements, send keys, and perform actions. As the number of test cases grows, maintenance becomes challenging.

### Solution: Using a Framework
Implementing a framework allows for the creation of reusable methods to handle common tasks such as finding elements, sending keys, and performing actions. This approach results in cleaner, more maintainable code and enhances automation efficiency.

## Page Object Model (POM)

### Overview
The Page Object Model is a design pattern that creates an object repository for web UI elements. It organizes page classes, each representing a web page in the application, and contains methods to interact with the elements on those pages.

### Advantages
- Code cleanliness and readability
- Visualization of test scenarios
- Reduced redundancy and increased reusability
- Easier maintenance and scalability

## Project Details

### Framework Components
- **Maven Project with TestNG**: Utilizes Selenium and Java for automation.
- **Page Objects Pattern**: Organizes web elements and actions into page classes.
- **Data-Driven Testing**: Inputs are passed using data providers and Excel sheets.
- **Properties File**: Stores input parameters like browser type, URL, and login details.

### Structure
1. **basicsetup**: Contains a generic `BaseClass` for test setup and teardown.
2. **pageobjects**: Holds page classes with methods to interact with web elements.
3. **testclass**: Contains test cases that read input data from data providers.

## How to Run Tests

### Prerequisites
- Install Java and set up environment variables.
- Install Maven and set up environment variables.

### Execution Steps
1. Update the `testdata.properties` file with required inputs.
2. Provide the file path of `testdata.properties` in the `BaseClass`.
3. Navigate to the project folder in the command line.
4. Run the following commands:
    ```
    mvn compile
    mvn test
    ```

## Reports

### Output
HTML reports, including test-output like `emailable report.html`, and `index.html`, are generated under the `target` folder. These reports offer comprehensive insights into test results, facilitating analysis and decision-making.

---

By implementing the Page Object Model and utilizing a structured framework, automation testing for Amazon.in becomes more efficient, and maintainable.