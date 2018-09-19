# AlzaNGsample ![CI status](https://img.shields.io/badge/build-passing-brightgreen.svg)

AlzaNGsample is my sample project that demonstrates what I've learned using Selenium and TestNG. Test are for Czech ecommerce site Alza.cz

## Running tests

### Requirements
* Java - http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html
* Maven - http://maven.apache.org/install.html
* Allure - https://docs.qameta.io/allure/#_installing_a_commandline

`$ pip install foobar`

### Usage
```
$ git clone git@github.com:oferdan/alzangsample.git
$ ./mvn clean test -PBasicSuite
$ allure serve target/allure-results
```

## License
[MIT](https://choosealicense.com/licenses/mit/)