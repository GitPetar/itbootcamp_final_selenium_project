package tests;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest {
@Test(priority = 10)
@Description("Test #1: Set locale to EN")
void setLocaleToEN() {
    navPage.getLanguageButton().click();
    navPage.getLanguageButton("EN").click();
    Assert.assertEquals(navPage.getHeader().getText(), "Landing", "Header text does not have expected value");
}

@Test(priority = 20)
@Description("Test #2: Set locale to ES")
void setLocaleToES() throws InterruptedException {
    navPage.getLanguageButton().click();
    navPage.getLanguageButton("ES").click();
    Assert.assertEquals(navPage.getHeader().getText(), "Página de aterrizaje", "Header text does not have expected " +
    "value");
}

@Test(priority = 30)
@Description("Test #3: Set locale to CN")
void setLocaleToCN() {
    navPage.getLanguageButton().click();
    navPage.getLanguageButton("CN").click();
    Assert.assertEquals(navPage.getHeader().getText(), "首页", "Header text does not have expected value");
}

@Test(priority = 40)
@Description("Test #4: Set locale to FR")
void setLocaleToFR() {
    navPage.getLanguageButton().click();
    navPage.getLanguageButton("FR").click();
    Assert.assertEquals(navPage.getHeader().getText(), "Page d'atterrissage", "Header text does not have expected " +
    "value");
}
@Test(priority = 50)
@Description("Test #4: Set locale to UA")
void setLocaleToUA() {
    navPage.getLanguageButton().click();
    navPage.getLanguageButton("UA").click();
    Assert.assertEquals(navPage.getHeader().getText(), "Лендінг", "Header text does not have expected " +
    "value");
}
}
