package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CitiesPage extends BasePage {
public CitiesPage(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
}

public WebElement getNewItemButton() {
    return driver.findElement(By.xpath("//button[contains(@class,'NewItem')]"));
}

public WebElement getItemInput() {
    wait.until(ExpectedConditions.elementToBeClickable(By.id("name")));
    return driver.findElement(By.id("name"));
}

public WebElement getItemSaveButton() {
    return driver.findElement(By.xpath("//*[contains(@class,'Save')]"));
}

public WebElement getSaveMessage() {
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'Saved successfully')"
    + "]"))));
    return driver.findElement(By.xpath("//*[contains(text(),'Saved successfully')]"));
}

public WebElement getSearchInput() {
    return driver.findElement(By.id("search"));
}

public List<WebElement> getTableRows() {
    return driver.findElements(By.xpath("//tbody/tr"));
}

public void waitForRowsToBe(int rows) {
    wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//tbody/tr"), rows));
}

public WebElement getEditButton(int row) {
    return driver.findElement(By.xpath("(//button[@id='edit'])[" + row + "]"));
}

public WebElement getDeleteButton(int row) {
    return driver.findElement(By.xpath("(//button[@id='delete'])[" + row + "]"));
}

public WebElement getCityName(int row) {
    return driver.findElement(By.xpath("//tbody/tr[" + row + "]/td[@class='text-left']"));
}

public WebElement getItemDeleteButton() {
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'red') and not( contains" +
    "(@class,'Cancel'))]")));
    return driver.findElement(By.xpath("//button[contains(@class,'red') and not( contains(@class,'Cancel'))]"));
}
public WebElement getDeleteMessage() {
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'Deleted successfully')"
    + "]"))));
    return driver.findElement(By.xpath("//*[contains(text(),'Deleted successfully')]"));
}
}
