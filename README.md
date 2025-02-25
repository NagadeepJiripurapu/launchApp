Project Name: Veeva Automation coding Assessment Test
Introduction
This framework automates the testing of various web applications and ensures that all user-facing functionality (UI) works correctly. The core of the test suite is built using Selenium WebDriver, Cucumber for BDD, core Java, TestNG and ExtentReports for test reporting. The tests cover critical user journeys such as navigating through different sections of the site, validating page elements, and ensuring content accuracy.
Features
Cross-Browser Testing: The tests can be executed on multiple browsers such as Chrome, and Firefox.
BDD Framework: Written using Cucumber for a readable and maintainable approach to writing tests.
Test Reporting: Generates detailed and visually appealing test reports using ExtentReports.
Data-Driven Testing: Incorporates data-driven testing techniques by reading data from external sources and files.
Error Handling: Well-structured error handling ensures that all exceptions are logged with meaningful error messages.
Test Scenarios: Includes a variety of test scenarios including UI navigation, form validation, and element verification.
Core-Product-Automation-Test/
├── src/
│   ├──  ──  ── main/
│   │──test  │    └── java/
│   │  │     │   ├── commons/
│   │  │     │   └── BaseTest.java
│   │  │     │   ├── GenericMethods.java
│   │  │     │   └── UiActions.interface
│   │  │     │──Exception
│   │  │         └──UiActionsException
│   │  │──────────── pages/
│   │  │         ├── cpPages.java
│   │  │         ├── dp1Pages.java
│   │  │         ├── dp2Pages.java
│   │  │         └──cpPages2.java
│   │  │──────── stepDefs/
│   │  │     │   └── stepDefinitions.java
│   │  │     └── utilities/
│   │  │         ├── ConfigReader.java
│   │  │         └── ExtentReportManager.java
│   │  │         
│   ├  └──  resources/
│   │          └── features/
│   │          └── coreProduct.feature
│   │       
│   │       
│   │   └── config/
│   │       └── config.properties
├── pom.xml
├── README.md
└── .gitignore

Technologies Used
Selenium WebDriver - Browser automation
Cucumber - BDD testing framework
Java - Programming language
JUnit - Testing framework
Maven - Build and dependency management tool
ExtentReports - Reporting tool
Git - Version control
Log4j - Logging framework
Java 8+ - Java version used in the project

Folders and Files Description
src/main/java/commons/: Contains utility classes like BaseTest.java for managing WebDriver and GenericMethods.java for reusable actions and UiActions Interface which is going to implemented by GenericMethods.java file.
src/test/java/pages/: Contains classes representing pages for different sections of the application (e.g., cpPages.java, dp1Pages.java).
src/test/java/stepDefs/: Contains step definition files where the actual automation steps are mapped to Cucumber steps.
src/test/resources/: Contains feature files (.feature) and configuration files (config.properties).
pom.xml: Maven build configuration file.
README.md: Project documentation.
.gitignore: Git ignore file for excluding unnecessary files from version control.
Setup and Installation
Prerequisites
To run the tests, you need to have the following installed on your machine:

Java 8+: Install the latest version of Java.
Maven: Ensure Maven is installed. You can download it from here.
Git: Install Git for version control.
IDE: Use an IDE like IntelliJ IDEA or Eclipse to edit and run the code.
Installation Steps
Clone the repository to your local machine:
git clone https://github.com/your-repo/your-project.git
Navigate to the project folder:
cd my-project
Install the project dependencies using Maven:
mvn clean install
