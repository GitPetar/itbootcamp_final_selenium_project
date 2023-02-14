package helper;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.NavPage;
import pages.SignupPage;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Helper {
public void takeScreenshot(WebDriver driver) {
    Date date = Calendar.getInstance().getTime();
    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy_hhmmss");
    String datum = dateFormat.format(date);
    TakesScreenshot scrShot = (TakesScreenshot) driver;
    File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
    File screenshot = new File("screenshots/" + datum + ".jpg");
    try {
        Files.copy(SrcFile, screenshot);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}

public void login(WebDriver driver, WebDriverWait wait) {
    NavPage navPage = new NavPage(driver, wait);
    LoginPage loginPage = new LoginPage(driver, wait);
    navPage.getLoginButton().click();
    wait.until(ExpectedConditions.elementToBeClickable(loginPage.getEmailInput()));
    loginPage.getEmailInput().sendKeys("admin@admin.com");
    loginPage.getPasswordInput().sendKeys("12345");
    loginPage.getLogInButton().click();
    
}

public void signup(WebDriver driver, WebDriverWait wait) {
    NavPage navPage = new NavPage(driver, wait);
    SignupPage signupPage = new SignupPage(driver, wait);
    navPage.getSignupButton().click();
    signupPage.getNameInput().sendKeys("Ime i prezime polaznika");
    signupPage.getEmailInput().sendKeys("admin@admin.com");
    signupPage.getPasswordInput().sendKeys("12345");
    signupPage.getConfirmPasswordInput().sendKeys("12345");
    signupPage.getSignupButton().click();
    wait.until(ExpectedConditions.urlContains("/home"));
    wait.until(ExpectedConditions.visibilityOf(signupPage.getVerifyAccountDialogue()));
    System.out.println(signupPage.getVerifyAccountDialogue().getText());
    signupPage.getVerifyAccountDialogueCloseButton().click();
}
}

