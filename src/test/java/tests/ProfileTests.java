package tests;

import jdk.jfr.Description;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ProfileTests extends BasicTest {
boolean isLoggedIn = false;

@BeforeMethod
void login() {
    if (!isLoggedIn) {
        helper.login(driver, wait);
        isLoggedIn = true;
    }
    navPage.getProfileButton().click();
}

@Test(priority = 10)
@Description("Test #1: Visits the profile page")
void visitsTheProfilePage() throws InterruptedException {
    Assert.assertTrue(driver.getCurrentUrl().contains("/profile"), "Current url does not contain \"/profile\"");
    Assert.assertEquals(profilePage.getEmailInput().getAttribute("value"), "admin@admin.com",
    "Attribute value of " + "retrieved" + " elemen does not equal \"admin@admin.com\"");
    navPage.getLogoutButton().click();
}

@Test(priority = 20)
@Description("Test #2: Checks input types")
void checksInputTypes() {
    SoftAssert softAssert = new SoftAssert();
    softAssert.assertEquals(profilePage.getEmailInput().getAttribute("type"), "email",
    "input type does not equal " + "\"email\"");
    softAssert.assertEquals(profilePage.getEmailInput().getAttribute("disabled"), "disabled",
    "input disabled does " + "not " + "equal \"disabled\"");//TODO
    softAssert.assertEquals(profilePage.getNameInput().getAttribute("type"), "text", "input type does not equal " +
    "\"text\"");
    softAssert.assertEquals(profilePage.getCityInput().getAttribute("type"), "text", "input type does not equal " +
    "\"text\"");
    softAssert.assertEquals(profilePage.getCountryInput().getAttribute("type"), "text",
    "input type does not equal " + "\"text\"");
    softAssert.assertEquals(profilePage.getTwitterInput().getAttribute("type"), "url",
    "input type does not equal " + "\"url\"");
    softAssert.assertEquals(profilePage.getGitHubInput().getAttribute("type"), "url", "input type does not equal " +
    "\"url\"");
    softAssert.assertEquals(profilePage.getPhoneInput().getAttribute("type"), "tel", "input type does not equal " +
    "\"tel\"");
    navPage.getLogoutButton();
    softAssert.assertAll();
}

@Test(priority = 30)
@Description("Test #3: Edits profile")
void editsProfile() throws InterruptedException {
    SoftAssert softAssert = new SoftAssert();
    JavascriptExecutor js = (JavascriptExecutor) driver;
    profilePage.clear();
    profilePage.getNameInput().sendKeys("ime i prezime polaznika");
    profilePage.getPhoneInput().sendKeys("+38161283223");
    profilePage.getCityInput().sendKeys("Bucaramanga");
    profilePage.getCountryInput().sendKeys("Spain");
    profilePage.getTwitterInput().sendKeys("https://twitter.com/profile/milan1232");
    profilePage.getGitHubInput().sendKeys("https://github.com/GitPetar");
    profilePage.getSaveButton().sendKeys(Keys.ENTER);
    softAssert.assertTrue(profilePage.getMessage().isDisplayed(), "Save message is not displayed");
    softAssert.assertTrue(profilePage.getMessage().getText().contains("Profile saved successfuly"),
    "Message does " + "not" + " " + "contain \"Profile saved successfuly\"");
    softAssert.assertTrue(profilePage.getNameInput().getAttribute("value").contains("ime i prezime polaznika"), "Name"
    + " input" + " does not contain expected value");
    softAssert.assertTrue(profilePage.getPhoneInput().getAttribute("value").contains("+38161283223"),
    "Phone input" + " does not contain expected value");
    softAssert.assertTrue(profilePage.getCityInput().getAttribute("value").contains("Bucaramanga"), "City input " +
    "does not contain expected value");
    softAssert.assertTrue(profilePage.getCountryInput().getAttribute("value").contains("Spain"), "Country input " +
    "does not contain expected value");
    softAssert.assertTrue(profilePage.getTwitterInput().getAttribute("value").contains("https://twitter" + ".com" +
    "/profile/milan1232"), "Twitter input" + " does not contain expected value");
    softAssert.assertTrue(profilePage.getGitHubInput().getAttribute("value").contains("https://github.com/gitpetar"),
    "GitHub input" + " does not contain expected value");
    softAssert.assertAll();
    navPage.getLogoutButton().click();
}
}
