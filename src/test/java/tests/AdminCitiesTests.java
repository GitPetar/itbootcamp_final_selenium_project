package tests;

import jdk.jfr.Description;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest {
boolean isLoggedIn = false;

@BeforeMethod
void login() {
    if (!isLoggedIn) {
        helper.login(driver, wait);
        isLoggedIn = true;
        
    }
}

@Test(priority = 10)
@Description("Test #1: Visits the admin cities page and list cities")
void visitsTheAdminCitiesPageAndListCities() {
    navPage.getAdminButton().click();
    navPage.getCitiesButton().click();
    Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"),
    "Current URL does not contain " + "\"/admin" + "/cities\"");
}

@Test(priority = 20)
@Description("Test #2: Checks input types for create/edit new city")
void checksInputTypesForCreateEditNewCity() {
    navPage.getAdminButton().click();
    navPage.getCitiesButton().click();
    citiesPage.getNewItemButton().click();
    Assert.assertEquals(citiesPage.getItemInput().getAttribute("type"), "text", "Input type does not equal " +
    "\"text\"");
}

@Test(priority = 30)
@Description("Test #3: Create new city")
void createNewCity() {
    navPage.getAdminButton().click();
    navPage.getCitiesButton().click();
    citiesPage.getNewItemButton().click();
    citiesPage.getItemInput().sendKeys("Petar Kotevski's City");
    citiesPage.getItemSaveButton().click();
    Assert.assertTrue(citiesPage.getSaveMessage().getText().contains("Saved successfully"));
}

@Test(priority = 40)
@Description("Test #4: Edit city")
void editCity() throws InterruptedException {
    navPage.getAdminButton().click();
    navPage.getCitiesButton().click();
    citiesPage.getSearchInput().sendKeys("Petar Kotevski's City");
    citiesPage.waitForRowsToBe(1);
    citiesPage.getEditButton(1).click();
    //clear method doesn't work
    citiesPage.getItemInput().sendKeys(Keys.CONTROL+"a");
    citiesPage.getItemInput().sendKeys(Keys.BACK_SPACE);
    citiesPage.getItemInput().sendKeys("Petar Kotevski's City Edited");
    citiesPage.getItemSaveButton().click();
    Assert.assertTrue(citiesPage.getSaveMessage().getText().contains("Saved successfully"));
}

@Test(priority = 50)
@Description("Test #5: Search city")
void searchCity() {
    navPage.getAdminButton().click();
    navPage.getCitiesButton().click();
    citiesPage.getSearchInput().sendKeys("Petar Kotevski's City Edited");
    citiesPage.waitForRowsToBe(1);
    Assert.assertEquals(citiesPage.getCityName(1).getText(), "Petar Kotevski's City Edited", "Name in row 1 does not "
    + "match" + " " + "expected");
}

@Test(priority = 60)
@Description("Test #5: Delete city")
void deleteCity() {
    navPage.getAdminButton().click();
    navPage.getCitiesButton().click();
    citiesPage.getSearchInput().sendKeys("Petar Kotevski's City Edited");
    citiesPage.waitForRowsToBe(1);
    Assert.assertEquals(citiesPage.getCityName(1).getText(), "Petar Kotevski's City Edited", "Name in row 1 does not "
    + "match expected");
    citiesPage.getDeleteButton(1).click();
    citiesPage.getItemDeleteButton().click();
    Assert.assertTrue(citiesPage.getDeleteMessage().getText().contains("Deleted successfully"), "Delete message does "
    + "not contain \"Deleted successfully\"");
}
}
