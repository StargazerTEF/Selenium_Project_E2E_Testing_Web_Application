# Selenium_Project_E2E_Testing_Web_Application
### End to End Software Application Testing With Selenium &amp; TestNG Libraries
#### Technologies - ***Java***, ***Maven***, ***Selenium***, ***TestNG***, ***Git***
#### Tasks:
1. ***Automated functional testing*** of web application [Swag Labs](https://www.saucedemo.com/)
2. Implementation of ***Page Object Model(POM)*** for structured organization of automated tests
3. Utilization of ***Selenium library*** for web-page interaction
4. ***Test implementation*** for:  
   a) *login*  
   b) *product selection and adding to the cart*  
   c) *checkout*  
   d) *payment*

Project consists of 253 tests arranged into 6 categories:

- [x] **[Login tests](test_cases/LoginTests.md)**: Verifying login page features and functionalities - login with valid credentials, verifying error messages for login with invalid credentials or blank input fields, header and footer tests 
- [x] **[Products tests](test_cases/ProductsTests.md)**: Verifying features and functionalities for inventory page - products features, adding to the cart, left menu navigation features and functionalities, header and footer tests
- [x] **[Cart tests](test_cases/CartTests.md)**: Verifying features and functionalities for cart page - comparing features and number of added products, left menu navigation features and functionalities, header and footer tests
- [x] **[Checkout tests](test_cases/CheckoutTests.md)**: Verifying features and functionalities for checkout page - checkout with valid inputs, verifying error messages for invalid inputs or blank input fields, left menu navigation features and functionalities, header and footer tests
- [x] **[Payment tests](test_cases/PaymentTests.md)**: Verifying features and functionalities for payment page - comparing features and prices of added products, verifying payment information, left menu navigation features and functionalities, header and footer tests
- [x] **[Confirmation tests](test_cases/ConfirmationTests.md)**: Verifying confirmation page features and functionalities - verifying successful purchase information, returning to the inventory page, left menu navigation features and functionalities, header and footer tests

Tests are being organized and implemented using testng.xml to support testing in different browsers. To run tests from command line use:   
**mvn clean test -Dsurefire.suiteXmlFiles=testng.xml**