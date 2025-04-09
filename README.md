# 🧪 Eteration Web Automation Framework

This project is a scalable and maintainable web automation test framework using the BDD (Behavior Driven Development) approach. It utilizes Java, Cucumber, Selenium, and TestNG technologies.

## 📋 Features

- **BDD Approach**: Clear scenarios written with Cucumber
- **Multi-Browser Support**: Chrome, Firefox, Edge, and Safari
- **Parallel Test Execution**: Parallel testing with TestNG
- **POM (Page Object Model)**: Page-specific object definitions
- **Thread-Safe WebDriver Management**: Secure multi-threading support with ThreadLocal<WebDriver>
- **Detailed Reporting**: Allure and Cucumber HTML reporting
- **Automatic Screenshots**: Automatic screenshot capture for failed tests
- **Multi-Environment Support**: Configuration for different environments such as dev, test, prod
- **Log Management**: Comprehensive logging with Log4j2
- **Multilingual Feature Files**: Support for feature files in different languages (including Turkish)

## 🛠️ Technology Stack

| Technology | Version |
|-----------|-------|
| Java | 11 |
| Selenium | 4.16.1 |
| Cucumber | 7.15.0 |
| TestNG | 7.9.0 |
| WebDriverManager | 5.6.3 |
| Log4j2 | 2.22.1 |
| Maven | 3.x |

## 📁 Project Structure

```
src
├── main
│   ├── java
│   │   └── com.eteration.automation
│   │       ├── config       # Configuration management
│   │       ├── driver       # WebDriver factory and manager
│   │       ├── models       # Test data models
│   │       ├── pages        # Page Object Model classes
│   │       └── utils        # Utility classes
│   └── resources
│       └── log4j2.xml       # Log4j2 configuration
│
└── test
    ├── java
    │   └── com.eteration.automation
    │       ├── runner       # TestNG runners
    │       └── stepdefinitions # Cucumber step definitions
    └── resources
        ├── features         # Cucumber feature files
        ├── config           # Environment configuration files
        └── testdata         # Test data
```

## 🚀 Getting Started

### Prerequisites

- Java 11 or higher
- Maven 3.x
- Internet connection (for WebDriverManager to download drivers)

### Installation

1. Clone the project:
   ```bash
   git clone https://github.com/your-username/eteration-webAutomation.git
   cd eteration-webAutomation
   ```

2. Install dependencies:
   ```bash
   mvn clean install -DskipTests
   ```

### Running Tests

Running all tests:
```bash
mvn clean test
```

Running tests with specific tags:
```bash
mvn clean test -Dcucumber.filter.tags="@homepage"
```

Running a specific feature:
```bash
mvn clean test -Dcucumber.features="src/test/resources/features/HomePage.feature"
```

Running tests in a different environment:
```bash
mvn clean test -Denv=test
```

## 📊 Reporting

After running tests, reports are generated in the following locations:

- **Cucumber HTML Reports**: `target/cucumber-reports/`
- **Allure Reports**: `target/allure-results/`

To view Allure reports:
```bash
mvn allure:serve
```

## 🧩 POM Structure

The framework uses the Page Object Model pattern:

- Separate class for each page
- All page objects inherit from the `BasePageObject` class
- Elements are defined with `@FindBy` and kept `private`
- Page actions are defined as `public` methods

Example:
```java
public class HomePage extends BasePageObject {
    
    @FindBy(css = "nav.main-navigation")
    private WebElement mainNavigationMenu;
    
    public HomePage(WebDriver driver) {
        super(driver);
    }
    
    public void navigateToHomePage() {
        driver.get(ConfigReader.getProperty("base.url"));
        waitForPageLoad();
    }
    
    public boolean isMainNavigationMenuDisplayed() {
        return isDisplayed(mainNavigationMenu);
    }
}
```

## 📝 Feature Files

Cucumber feature files support multiple languages:

```gherkin
# language: en
@homepage
Feature: Eteration Homepage Functionality
  
  Scenario: User should be able to successfully access the homepage
    Given user navigates to the homepage
    Then the page title should contain "Eteration"
    And the main navigation menu should be displayed
```

## ⚙️ Configuration

Configuration files for different environments:
- `src/test/resources/config/dev.properties` - Development environment
- `src/test/resources/config/test.properties` - Test environment
- `src/test/resources/config/prod.properties` - Production environment

To change the environment, use the `-Denv` parameter:
```bash
mvn clean test -Denv=test
```

## 🛡️ WebDriver Management

- Parallel execution support with ThreadLocal<WebDriver>
- Automatic driver setup with WebDriverManager
- Different browser support with DriverFactory pattern
- Test lifecycle management with Hooks class

## 🤝 Contributing

1. Fork the project
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add: Amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the [MIT License](LICENSE). 