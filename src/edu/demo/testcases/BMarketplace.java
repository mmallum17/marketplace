package edu.demo.testcases;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class BMarketplace {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
	driver = new ChromeDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testMarketplace() throws Exception {
    driver.get("http://mav-market.ddns.net:8080/marketplace/items");
    Thread.sleep(7000);
    driver.findElement(By.id("txtSearch")).click();
    driver.findElement(By.id("txtSearch")).clear();
    driver.findElement(By.id("txtSearch")).sendKeys("chicken");
    Thread.sleep(4000);
    driver.findElement(By.id("txtSearch")).sendKeys(Keys.ENTER);
    Thread.sleep(3000);
    driver.findElement(By.id("txtSearch")).click();
    driver.findElement(By.id("txtSearch")).clear();
    driver.findElement(By.id("txtSearch")).sendKeys("nothing");
    Thread.sleep(4000);
    driver.findElement(By.id("txtSearch")).sendKeys(Keys.ENTER);
    Thread.sleep(3000);
    driver.findElement(By.id("txtSearch")).click();
    driver.findElement(By.id("txtSearch")).clear();
    driver.findElement(By.id("txtSearch")).sendKeys("dirt");
    Thread.sleep(4000);
    driver.findElement(By.id("txtSearch")).sendKeys(Keys.ENTER);
    Thread.sleep(3000);
    driver.findElement(By.id("txtSearch")).click();
    driver.findElement(By.id("txtSearch")).sendKeys(Keys.ENTER);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='sign up'])[1]/following::button[1]")).click();
    Thread.sleep(5000);
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
