# AlzaNGsample ![CI status](https://img.shields.io/badge/build-passing-brightgreen.svg)

AlzaNGsample is my sample test automation project that demonstrates what I've learned using Selenium and TestNG. Test are for Czech ecommerce site Alza.cz
More tests, features and refactoring to come.

The most information comes from:
* https://www.udemy.com/selenium-webdriver-with-java-testng-and-log4j/learn/v4/content
* https://www.swtestacademy.com/


## Features

Project is using:
* Selenium with Java bindings
* TestNG framework
* TestNG listeners
* Page Object design pattern
* Data Driven testing with Data Providers
* Log4j for logging
* Allure for beautiful reports with lots of information and self-describing tests in BDD style
* Maven for building
* Jenkins can be used for Continuous Integration


## Running tests

### Requirements
* Java - http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html
* Maven - http://maven.apache.org/install.html
* Allure - https://docs.qameta.io/allure/#_installing_a_commandline

### Usage
Clone project from GitHub and run commands in project root. Maven runs tests and Allure starts web server with reports.
```
$ git clone git@github.com:oferdan/alzangsample.git
$ mvn clean test -PBasicSuite
$ allure serve target/allure-results
```

## Screenshots
![Allure Overview](https://imgur.com/pZYEkR5 "Allure Overview")
![Allure Graphs](https://imgur.com/1BjDQfE "Allure Graphs")
![Allure Behaviors](https://imgur.com/QhdmXY5 "Allure Behaviors")

## Log sample
```
2018-09-20 10:19:03.478 [main] INFO  com.ferdano.utilities.Log - ============================================================
2018-09-20 10:19:03.488 [main] INFO  com.ferdano.utilities.Log - ===== Test Class: Alza.cz sample tests is Starting... ======
2018-09-20 10:19:03.488 [main] INFO  com.ferdano.utilities.Log - ============================================================
2018-09-20 10:19:03.488 [main] INFO  com.ferdano.utilities.Log - ===== Test Class: Alza.cz sample tests is Starting... ======
2018-09-20 10:19:09.706 [main] INFO  com.ferdano.utilities.Log - ------------------------------------------------------------
2018-09-20 10:19:09.706 [main] INFO  com.ferdano.utilities.Log - === Test Method: orderMostExpensiveTelevisionTest is Starting... ====
2018-09-20 10:19:09.706 [main] INFO  com.ferdano.utilities.Log - ------------------------------------------------------------
2018-09-20 10:19:09.706 [main] INFO  com.ferdano.utilities.Log - === Test Method: orderMostExpensiveTelevisionTest is Starting... ====
2018-09-20 10:19:09.806 [main] INFO  com.ferdano.utilities.Log - Opening home page.
2018-09-20 10:19:13.352 [main] INFO  com.ferdano.utilities.Log - Opening televisions.
2018-09-20 10:19:18.846 [main] INFO  com.ferdano.utilities.Log - Sorting products.
2018-09-20 10:19:21.012 [main] INFO  com.ferdano.utilities.Log - Opening product.
2018-09-20 10:19:23.376 [main] INFO  com.ferdano.utilities.Log - Adding product to basket.
2018-09-20 10:19:25.152 [main] INFO  com.ferdano.utilities.Log - Continuing to basket.
2018-09-20 10:19:26.026 [main] INFO  com.ferdano.utilities.Log - Continuing to shipping and payments page.
2018-09-20 10:19:26.315 [main] INFO  com.ferdano.utilities.Log - Handling not in stock warning.
2018-09-20 10:19:27.212 [main] INFO  com.ferdano.utilities.Log - Setting delivery method.
2018-09-20 10:19:31.662 [main] INFO  com.ferdano.utilities.Log - Setting dispatching.
2018-09-20 10:19:31.942 [main] INFO  com.ferdano.utilities.Log - Setting payment method.
2018-09-20 10:19:35.062 [main] INFO  com.ferdano.utilities.Log - Continuing to order confirmation.
2018-09-20 10:19:35.342 [main] INFO  com.ferdano.utilities.Log - PASSED Test: [TestClass name=class com.ferdano.alzangsample.OrderMostExpensiveTelevisionTest]: orderMostExpensiveTelevisionTest
2018-09-20 10:19:35.342 [main] INFO  com.ferdano.utilities.Log - PASSED Test: [TestClass name=class com.ferdano.alzangsample.OrderMostExpensiveTelevisionTest]: orderMostExpensiveTelevisionTest
2018-09-20 10:19:35.502 [main] INFO  com.ferdano.utilities.Log - Quitting driver.
```

## License

[The Unlicense](https://choosealicense.com/licenses/unlicense/)