package org.loose.vvs.seleniumtest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.loose.vvs.seleniumtest.exceptions.InvalidGradeCountException;
import org.loose.vvs.seleniumtest.services.GradeCalculator;
import org.loose.vvs.seleniumtest.services.GradesProvider;
import org.loose.vvs.seleniumtest.services.GradesService;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class SeleniumTest {

    public static final String URL = "http://localhost:8080";
    private static WebDriver webDriver;

    private static WebDriverManager webDriverManager;

    @BeforeAll
    static void beforeAll() {
        if (WebDriverManager.chromedriver().getBrowserPath().isPresent()) {
            webDriverManager = WebDriverManager.chromedriver();
            return;
        }
        if (WebDriverManager.firefoxdriver().getBrowserPath().isPresent()) {
            webDriverManager = WebDriverManager.firefoxdriver();
        }
    }

    @BeforeEach
    public void setup() {
        assertNotNull(webDriverManager);
        webDriverManager.setup();
        webDriver = webDriverManager.create();
        webDriver.manage().timeouts().implicitlyWait(Duration.of(5, ChronoUnit.SECONDS));
    }

    @AfterEach
    void tearDown() {
        webDriver.quit();
    }

    public static void LoginStudent() throws InterruptedException{
        webDriver.get("http://localhost:8080/");

        WebElement loginField = webDriver.findElement(By.id("username"));
        loginField.sendKeys("student");
        loginField.sendKeys(Keys.ENTER);

        Thread.sleep(1000);

        WebElement passwordField = webDriver.findElement(By.id("password"));
        passwordField.sendKeys("student");
        passwordField.sendKeys(Keys.ENTER);

        Thread.sleep(1000);

        WebElement loginButton = webDriver.findElement(By.cssSelector("button[type='button']"));
        loginButton.click();

        Thread.sleep(1000);

    }


    //1. Login for student
    @Test
    public void TestLoginForStudent() throws InterruptedException{
        webDriver.get("http://localhost:8080/");

        WebElement loginField = webDriver.findElement(By.id("username"));
        loginField.sendKeys("student");
        loginField.sendKeys(Keys.ENTER);

        Thread.sleep(1000);

        WebElement passwordField = webDriver.findElement(By.id("password"));
        passwordField.sendKeys("student");
        passwordField.sendKeys(Keys.ENTER);

        Thread.sleep(1000);

        WebElement loginButton = webDriver.findElement(By.cssSelector("button[type='button']"));
        loginButton.click();

        Thread.sleep(1000);

        assertEquals("http://localhost:8080/student", webDriver.getCurrentUrl());

    }



/*2. As a student, I want to calculate the mean of my 3 biggest grades. I will click on the add grade button and enter a grade in
    the input field. I will click on the calculate button and the mean will be displayed in the mean field.
    */


    @Test
    public void TestMeanGrades() throws InterruptedException {
        LoginStudent();
        assertEquals("http://localhost:8080/student", webDriver.getCurrentUrl());


        WebElement addGradeButton = webDriver.findElement(By.xpath("html/body/div/div/div[2]/div/button"));

//        "button[type='button']
        addGradeButton.click();

//        WebElement inputGrade = webDriver.findElement(By.xpath("html/body/div/div/div[2]/div/button"));
        WebElement inputGrade = webDriver.findElement(By.cssSelector("input[id='grade-field-0']"));
        inputGrade.sendKeys("9");
        inputGrade.sendKeys(Keys.ENTER);

        Thread.sleep(1000);
        addGradeButton.click();
        Thread.sleep(1000);


        WebElement inputGrade1 = webDriver.findElement(By.cssSelector("input[id='grade-field-1']"));
        inputGrade1.sendKeys("8");
        inputGrade1.sendKeys(Keys.ENTER);

        addGradeButton.click();
        Thread.sleep(1000);

        WebElement inputGrade2 = webDriver.findElement(By.cssSelector("input[id='grade-field-2']"));
        inputGrade2.sendKeys("8");
        inputGrade2.sendKeys(Keys.ENTER);

        addGradeButton.click();
        Thread.sleep(1000);


//        WebElement calculateMean = webDriver.findElement(By.xpath("//*[contains(text(), 'calculate-button')]"));
        WebElement calculateMean = webDriver.findElement(By.xpath("html/body/div/div/div[2]/button"));
        calculateMean.click();

        Thread.sleep(1000);

//        WebElement getMean = webDriver.findElement(By.xpath("html/body/div/div[2]/h5"));

        WebElement getMean2 = webDriver.findElement(By.cssSelector("h5[class='MuiTypography-root MuiTypography-h5 mean-typography css-zq6grw']"));

        String name = getMean2.getText();

        System.out.println("name");
        System.out.println(name);

        String[] splits = name.split(" ");

        System.out.println(splits[0]);
        System.out.println(splits[1]);


        int theMean = Integer.parseInt(splits[1]);




        List<Double> grades = new ArrayList<>();
        grades.add(9.0);
        grades.add(8.0);
        grades.add(8.0);


        GradeCalculator calc = new GradeCalculator();

//        name = name.replaceAll("[^0-9]", " "); // regular expression

        // Replace all the consecutive white
        // spaces with a single space
//        name = name.replaceAll(" +", " ");

        System.out.println(name);

//        assertEquals(calc.calculateMeanFromThreeMaxGrades(grades), splits[1]);



//        By.xpath("//*[contains(text(), 'ADD'

//        WebElement addGradeButton = webDriver.findElement(By.xpath("html/body/div/div/div[2]/div/button"));

    }




// 3. Logout for student

    @Test
    public void TestLogoutForStudent() throws InterruptedException{
        LoginStudent();
        assertEquals("http://localhost:8080/student", webDriver.getCurrentUrl());

        WebElement logoutButton = webDriver.findElement(By.xpath("html/body/div/div/div/header/div/button"));
        logoutButton.click();

        assertEquals("http://localhost:8080/", webDriver.getCurrentUrl());

    }


}

class JunitTest {
    //JUNIT
    @Test
    void testCalculateMeanFromThreeMaxGradesWithThreeGrades() {
        List<Double> grades = new ArrayList<>();
        grades.add(10.0);
        grades.add(9.0);
        grades.add(5.0);
        GradeCalculator calc = new GradeCalculator();
        double actual = calc.calculateMeanFromThreeMaxGrades(grades);
        assertEquals(8.0, actual);
    }

    //JUNIT
    @Test
    void testCalculateMeanFromThreeMaxGradesWithFourGrades() {
        List<Double> grades = new ArrayList<>();
        grades.add(10.0);
        grades.add(9.0);
        grades.add(5.0);
        grades.add(4.0);
        GradeCalculator calc = new GradeCalculator();
        double actual = calc.calculateMeanFromThreeMaxGrades(grades);
        assertEquals(8.0, actual);
    }

    //JUNIT
    @Test
    void testCalculateMeanFromThreeMaxGradesWithFiveGrades() {
        List<Double> grades = new ArrayList<>();
        grades.add(10.0);
        grades.add(9.0);
        grades.add(5.0);
        grades.add(2.0);
        grades.add(8.0);
        GradeCalculator calc = new GradeCalculator();
        double actual = calc.calculateMeanFromThreeMaxGrades(grades);
        assertEquals(9.0, actual);
    }
}

//inline/anonymous class test
class GradesServiceTest {
    @Test
    void testCalculateMeanWithMockitoWithThreeGrades() {
        GradeCalculator calc = new GradeCalculator();
        GradesService service = new GradesService(calc);
        service.setGradesProvider(new GradesProvider() {
            @Override
            public List<Double> getGrades() {
                List<Double> grades = new ArrayList<>();
                grades.add(10.0);
                grades.add(9.0);
                grades.add(5.0);
                return grades;
            }
        });
        double actual = service.calculateMean();
        assertEquals(8.0, actual);
    }
}

//separate class test
class MockitoGradesServiceTest {
    @Test
    void testCalculateMeanWithMockitoWithThreeGrades() {
        List<Double> grades = new ArrayList<>();
        grades.add(10.0);
        grades.add(9.0);
        grades.add(5.0);
        GradeCalculator calc = new GradeCalculator();
        GradesService service = new GradesService(calc);
        service.setGradesProvider(new MockGradesProvider());
        double actual = service.calculateMean();
        assertEquals(8.0, actual);
    }

    private static class MockGradesProvider implements GradesProvider {
        @Override
        public List<Double> getGrades() {  List<Double> grades = new ArrayList<>();
            grades.add(10.0);
            grades.add(9.0);
            grades.add(5.0);
            return grades;
        }
    }
}

@ExtendWith(MockitoExtension.class)
class Mockito {
    @Mock
    private GradesProvider gradesProvider;

    @Test
    void testCalculateMeanWithMockitoWithThreeGrades(@Mock GradesProvider gradesProvider) {
        List<Double> grades = new ArrayList<>();
        grades.add(10.0);
        grades.add(9.0);
        grades.add(5.0);
        GradesService gradesService = new GradesService(new GradeCalculator());
        gradesService.setGradesProvider(gradesProvider);

        when(gradesProvider.getGrades()).thenReturn(grades);
        //when -> allows to mock the provider
        double actual = gradesService.calculateMean();
        assertEquals(8.0, actual);
    }
}

//    @Test
//    void testCalculateMeanWithMockitoWithNullGrades() {
//        List<Double> grades = null;
//        GradeCalculator calc = new GradeCalculator();
//        GradesService service = new GradesService(calc);
//        assertThrows(InvalidGradeCountException.class, () -> service.calculateMean(grades));
//    }