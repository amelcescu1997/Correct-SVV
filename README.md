# JUnit Mockito Selenium Test

## Introduction

Run the SeleniumTestApplication class and visit http://localhost:8080/ to see the application running.

### Credentials

Student
> username: student
>
> password: student

## Test Cases

### JUnit - 3p

Unit test the class [GradeCalculator](src/main/java/org/loose/vvs/seleniumtest/services/GradeCalculator.java)

You should have at least 3 different test cases.

### Mockito - 3p

Test the [GradeService](src/main/java/org/loose/vvs/seleniumtest/services/GradesService.java) where `GradeCalculator` is
the mock.

Write 3 different test cases using the 3 mocking methods (anonymous class, separate class, Mockito)

### Selenium - 3p

1. Login for student
2. As a student, I want to calculate the mean of my 3 biggest grades. I will click on the add grade button and enter a grade in
   the input field. I will click on the calculate button and the mean will be displayed in the mean field.
3. Logout for student
