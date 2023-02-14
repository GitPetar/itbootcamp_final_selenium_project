package tests;

import helper.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public abstract class BasicTest {
protected String baseUrl;
protected WebDriver driver;
protected WebDriverWait wait;
protected Helper helper;
//Pages
protected NavPage navPage;
protected LoginPage loginPage;
protected SignupPage signupPage;
protected CitiesPage citiesPage;
protected ProfilePage profilePage;

@BeforeClass
public void setup() {
    System.setProperty("web-driver.chrome.driver", "drivers/chromedriver.exe");
    baseUrl = "https://vue-demo.daniel-avellaneda.com";
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    helper = new Helper();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    navPage = new NavPage(driver, wait);
    loginPage = new LoginPage(driver, wait);
    signupPage = new SignupPage(driver, wait);
    citiesPage = new CitiesPage(driver, wait);
    profilePage = new ProfilePage(driver,wait);
}

@BeforeMethod
public void beforeMethod() {
    driver.get(baseUrl);
}

@AfterMethod
public void afterMethod(ITestResult result) {
    if (result.getStatus() == ITestResult.FAILURE) {
        helper.takeScreenshot(driver);
    }
}

@AfterClass
public void afterClass() {
    driver.quit();
}
}

