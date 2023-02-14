package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage extends BasePage {
public NavPage(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
}

public WebElement getLoginButton() {
    // wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("LOGIN"))));
    return driver.findElement(By.linkText("LOGIN"));
}

public WebElement getLogoutButton() {
    return driver.findElement(By.xpath("//*[contains(text(),' Logout ')]"));
}

public WebElement getSignupButton() {
    return driver.findElement(By.linkText("SIGN UP"));
}

public WebElement getHomeButton() {
    return driver.findElement(By.linkText("HOME"));
}

public WebElement getAdminButton() {return driver.findElement(By.xpath("//button[contains(@class,'Admin')]"));}

public WebElement getCitiesButton() {return driver.findElement(By.linkText("Cities"));}

public WebElement getLanguageButton() {return driver.findElement(By.xpath("//button[contains(@class,'btnLocale')]"));}

public WebElement getLanguageButton(String lang) {
    /*
   wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[contains(@class,'" + lang +
    "')]"))));
   */
    return driver.findElement(By.xpath("//div[contains(@class,'" + lang + "')]"));
}
public WebElement getProfileButton(){return driver.findElement(By.linkText("MY PROFILE"));}
public WebElement getHeader(){
    return driver.findElement(By.xpath("//h1"));
}
}
