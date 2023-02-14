package tests;

import jdk.jfr.Description;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BasicTest {
@Test(priority = 10)
@Description("Test #1: Visits the signup page")
void visitsTheSignupPage() {
    navPage.getSignupButton().click();
    Assert.assertTrue(driver.getCurrentUrl().contains("/signup"), "Current URL does not contain \"/signup\"");
}

@Test(priority = 20)
@Description("Test #2: Checks input types")
void checksInputTypes() {
    navPage.getSignupButton().click();
    Assert.assertEquals(signupPage.getEmailInput().getAttribute("type"), "email", "input type does not equal " +
    "\"email\"");
    Assert.assertEquals(signupPage.getPasswordInput().getAttribute("type"), "password",
    "input type does not equal " + "\"password\"");
    Assert.assertEquals(signupPage.getConfirmPasswordInput().getAttribute("type"), "password",
    "input type does not " + "equal " + "\"password\"");
}

@Test(priority = 30)
@Description("Test #3: Displays errors when user already exists")
void displaysErrorsWhenUserAlreadyExists() {
    navPage.getSignupButton().click();
    Assert.assertTrue(driver.getCurrentUrl().contains("/signup"), "Current URL does not contain \"/signup\"");
    signupPage.getNameInput().sendKeys("Another User");
    signupPage.getEmailInput().sendKeys("admin@admin.com");
    signupPage.getPasswordInput().sendKeys("12345");
    signupPage.getConfirmPasswordInput().sendKeys("12345");
    signupPage.getSignupButton().click();
    wait.until(ExpectedConditions.visibilityOf(signupPage.getErrorMessage()));
    Assert.assertTrue(signupPage.getErrorMessage().getText().contains("E-mail already exists"),
    "Error message does " + "not contain \"E-mail already exists\"");
    Assert.assertTrue(driver.getCurrentUrl().contains("/signup"), "Current URL does not contain \"/signup\"");
}

@Test(priority = 40)
@Description("Test #4: Signup")
void signup() {
    navPage.getSignupButton().click();
    signupPage.getNameInput().sendKeys("Ime i prezime polaznika");
    signupPage.getEmailInput().sendKeys("ime.prezime@itbootcamp.rs");
    signupPage.getPasswordInput().sendKeys("12345");
    signupPage.getConfirmPasswordInput().sendKeys("12345");
    signupPage.getSignupButton().click();
    wait.until(ExpectedConditions.urlContains("/home"));
    wait.until(ExpectedConditions.visibilityOf(signupPage.getVerifyAccountDialogue()));
    System.out.println(signupPage.getVerifyAccountDialogue().getText());
    Assert.assertTrue(signupPage.getVerifyAccountDialogue().getText().contains("IMPORTANT: Verify your account"),
    "Message does not contain \"IMPORTANT: Verify your account\"");
    signupPage.getVerifyAccountDialogueCloseButton().click();
    navPage.getLogoutButton().click();
}
}
