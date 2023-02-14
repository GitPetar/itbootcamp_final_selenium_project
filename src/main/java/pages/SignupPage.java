package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage extends BasePage {
public SignupPage(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
}

public WebElement getNameInput() {return driver.findElement(By.id("name"));}

public WebElement getEmailInput() {
    return driver.findElement(By.id("email"));
}

public WebElement getPasswordInput() {
    return driver.findElement(By.id("password"));
}

public WebElement getConfirmPasswordInput() {
    return driver.findElement(By.id("confirmPassword"));
}

public WebElement getSignupButton() {
    return driver.findElement(By.xpath("//button[@type='submit']"));
}

public WebElement getErrorMessage() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@role='status']")));
    return driver.findElement(By.xpath("//*[@role='status']"));
}

public WebElement getVerifyAccountDialogue() {
    return driver.findElement(By.xpath("//*[contains(text(),'IMPORTANT: Verify your account')]"));
}

public WebElement getVerifyAccountDialogueCloseButton() {
    return driver.findElement(By.xpath("//button[contains(@class,'btnClose')]"));
}
}
