### Hexlet tests and linter status:
[![Actions Status](https://github.com/IlnazKamalov/java-project-78/workflows/hexlet-check/badge.svg)](https://github.com/IlnazKamalov/java-project-78/actions)
[![Java CI](https://github.com/IlnazKamalov/java-project-3/actions/workflows/JavaCI.yml/badge.svg)](https://github.com/IlnazKamalov/java-project-3/actions/workflows/JavaCI.yml)
<a href="https://codeclimate.com/github/IlnazKamalov/java-project-3/maintainability"><img src="https://api.codeclimate.com/v1/badges/ad6f495d5dc56a878f91/maintainability" /></a>
<a href="https://codeclimate.com/github/IlnazKamalov/java-project-3/test_coverage"><img src="https://api.codeclimate.com/v1/badges/ad6f495d5dc56a878f91/test_coverage" /></a>


<h1 align="center">Welcome<img src="https://github.com/blackcater/blackcater/raw/main/images/Hi.gif" height="32"/></h1>
<h2> Project Data Validator.</h2>

<h3 align="">Description:

Data validator is a library that can be used to check the correctness of any data. 
There are many such libraries in every language, since almost all programs work with external data that needs to be checked for correctness. 
First of all, we are talking about the data of forms filled out by users. 
The [yup](https://github.com/jquense/yup) library is taken as the basis for the project.

* Usage example:</h3>
```java
    Validator validator = new Validator();

        // strings structure check
        
    StringSchema schema = validator.string().required();
    schema.isValid("what does the fox say"); // true
    schema.isValid(""); // false
        
        // numbers structure check
        
    NumberSchema schema = validator.number().required().positive();
    schema.isValid(-10); // false
    schema.isValid(10); // true
        
        // map structure check
        
    MapSchema schema = validator.map();
    Map<String, String> data = new HashMap<>();
    data.put("key", "value");
    schema.isValid(data); // true
        
    schema.sizeof(2);
    schema.isValid(data);  // false
    data.put("key2", "value2");
    schema.isValid(data); // true
    
```