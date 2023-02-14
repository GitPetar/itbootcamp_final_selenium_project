package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePage {
public ProfilePage(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
}

public WebElement getEmailInput() {
    return driver.findElement(By.id("email"));
}

public WebElement getSaveButton() {
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@type='submit']"))));
    return driver.findElement(By.xpath("//button[@type='submit']"));
}

private void waitForElementToHaveValue(WebElement webElement) {
    wait.until(ExpectedConditions.attributeToBeNotEmpty(webElement, "value"));
}

private void waitForElementsToHaveValue() {
    waitForElementToHaveValue(getCityInput());
    waitForElementToHaveValue(getCountryInput());
    waitForElementToHaveValue(getGitHubInput());
    waitForElementToHaveValue(getPhoneInput());
    waitForElementToHaveValue(getTwitterInput());
    waitForElementToHaveValue(getNameInput());
}

private void clearElement(WebElement webElement) {
    String value = webElement.getAttribute("value");
    for (int i = 0; i < value.length(); i++) {
        webElement.sendKeys(Keys.BACK_SPACE);
    }
    if (!webElement.getAttribute("value").equals("")) {
        clearElement(webElement);
    }
    //    value = webElement.getText();
    //    for (int i = 0; i < value.length(); i++) {
    //        webElement.sendKeys(Keys.BACK_SPACE);
    //    }
    //    if (!webElement.getText().equals("")){
    //        clearElement(webElement);
    //    }
    System.out.println(webElement.getText());
}

public void clear() {
    waitForElementsToHaveValue();
    clearElement(getCityInput());
    clearElement(getCountryInput());
    clearElement(getGitHubInput());
    clearElement(getPhoneInput());
    clearElement(getTwitterInput());
    clearElement(getNameInput());
}

public WebElement getNameInput() {
    return driver.findElement(By.id("name"));
}

public WebElement getPhoneInput() {
    return driver.findElement(By.id("phone"));
}

public WebElement getCityInput() {
    return driver.findElement(By.id("city"));
}

public WebElement getTwitterInput() {
    return driver.findElement(By.id("urlTwitter"));
}

public WebElement getGitHubInput() {
    return driver.findElement(By.id("urlGitHub"));
}

public WebElement getCountryInput() {
    return driver.findElement(By.id("country"));
}

public WebElement getMessage() {
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'Profile saved " +
    "successfuly')]"))));
    return driver.findElement(By.xpath("//*[contains(text(),'Profile saved successfuly')]"));
}
}
