package tests;

import jdk.jfr.Description;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest {
@Test(priority = 10)
@Description("Test #1: Visits the login page")
void visitTheLoginPage() {
    navPage.getLanguageButton().click();
    navPage.getLanguageButton("EN").click();
    navPage.getLoginButton().click();
    Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "Current URL does not contain \"/login\"");
}

@Test(priority = 20)
@Description("Test #2: Checks input types")
void checksInputTypes() {
    navPage.getLoginButton().click();
    Assert.assertEquals(loginPage.getEmailInput().getAttribute("type"), "email", "input type does not equal \"email\"");
    Assert.assertEquals(loginPage.getPasswordInput().getAttribute("type"), "password",
    "input type does not equal " + "\"password\"");
}

@Test(priority = 30)
@Description("Test #3: Displays errors when user does not exist")
void displaysErrorsWhenUserDoesNotExist() {
    navPage.getLoginButton().click();
    loginPage.getEmailInput().sendKeys("non-existing-user@gmal.com");
    loginPage.getPasswordInput().sendKeys("password123");
    loginPage.getLogInButton().click();
    Assert.assertTrue(loginPage.getErrorMessage().getText().contains("User does not exist"), "Error message does not "
    + "contain \"User does not exist\"");
    Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "Current URL does not contain \"/login\"");
}

@Test(priority = 40)
@Description("Test #4: Displays errors when password is wrong")
void displaysErrorsWhenPasswordIsWrong() {
    navPage.getLoginButton().click();
    loginPage.getEmailInput().sendKeys("admin@admin.com");
    loginPage.getPasswordInput().sendKeys("password123");
    loginPage.getLogInButton().click();
    Assert.assertTrue(loginPage.getErrorMessage().getText().contains("Wrong password"), "Error message does not " +
    "contain \"Wrong password\"");
    Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "Current URL does not contain \"/login\"");
}

@Test(priority = 50)
@Description("Test #5: Login")
void login() {
    navPage.getLoginButton().click();
    loginPage.getEmailInput().sendKeys("admin@admin.com");
    loginPage.getPasswordInput().sendKeys("12345");
    loginPage.getLogInButton().click();
    wait.until(ExpectedConditions.urlContains("/home"));
    Assert.assertTrue(driver.getCurrentUrl().contains("/home"), "Current URL does not contain \"/home\"");
}

@Test(priority = 60)
@Description("Test #6: Logout")
void logout() {
    Assert.assertTrue(navPage.getLogoutButton().isDisplayed(), "Logout button is not visible");
    navPage.getLogoutButton().click();
    Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "Current URL does not contain \"/login\"");
}
}
