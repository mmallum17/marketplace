/**
 * Tests the ability of users to edit their listings
 * 
 * Verifies by searching and finding new listing
 */

package edu.testcases;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

@SuppressWarnings("unused")
public class Hedititemtest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "/home/beef/Documents/chromedriver_linux64/chromedriver");
	driver = new ChromeDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testHedititem() throws Exception {
    // driver.get("http://mav-market.ddns.net:8080/marketplace/home");
	driver.get("http://localhost:8080/marketplace/login");
    Thread.sleep(1000);
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("aesmith@unomaha.edu");
    Thread.sleep(1000);
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("pass");
    Thread.sleep(2000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Email: Password:'])[1]/input[3]")).click();
    Thread.sleep(2000);
    driver.findElement(By.linkText("my items")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='logout'])[1]/following::div[5]")).click();
    Thread.sleep(3000);
    driver.findElement(By.name("itemName")).clear();
    Thread.sleep(1000);
    driver.findElement(By.name("itemName")).sendKeys("Goose");
    Thread.sleep(4000);
    driver.findElement(By.name("saveChangesBtn")).click();
    Thread.sleep(4000);
    driver.findElement(By.linkText("marketplace")).click();
    Thread.sleep(2000);
    driver.findElement(By.name("search")).click();
    Thread.sleep(1000);
    driver.findElement(By.name("search")).clear();
    driver.findElement(By.name("search")).sendKeys("Goose");
    Thread.sleep(2000);
    driver.findElement(By.name("search")).sendKeys(Keys.ENTER);
    Thread.sleep(2000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Search'])[1]/following::div[5]")).click();
    Thread.sleep(2000);
    driver.findElement(By.linkText("my items")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='logout'])[1]/following::div[5]")).click();
    Thread.sleep(3000);
    driver.findElement(By.name("itemName")).clear();
    Thread.sleep(1000);
    driver.findElement(By.name("itemName")).sendKeys("Chicken");
    Thread.sleep(4000);
    driver.findElement(By.name("saveChangesBtn")).click();
    Thread.sleep(4000);
    driver.findElement(By.linkText("logout")).click();
    Thread.sleep(1000);
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
