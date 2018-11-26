/**
 * Test search functionality in the marketplace
 * 
 * Verifies by visiting "Item Details" pages relevant to search
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
public class Gsearchitemtest {
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
  public void testGsearchitem() throws Exception {
    // driver.get("http://mav-market.ddns.net:8080/marketplace/home");
	driver.get("http://localhost:8080/marketplace/home");
	Thread.sleep(2000);
    driver.findElement(By.linkText("marketplace")).click();
    Thread.sleep(2000);
    driver.findElement(By.name("search")).click();
    Thread.sleep(1000);
    driver.findElement(By.name("search")).clear();
    driver.findElement(By.name("search")).sendKeys("palm trees");
    Thread.sleep(3000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='sign up'])[1]/following::button[1]")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Search'])[1]/following::div[5]")).click();
    Thread.sleep(2000);
    driver.findElement(By.linkText("marketplace")).click();
    Thread.sleep(2000);
    driver.findElement(By.name("search")).click();
    Thread.sleep(1000);
    driver.findElement(By.name("search")).clear();
    driver.findElement(By.name("search")).sendKeys("lamp");
    Thread.sleep(3000);
    driver.findElement(By.name("search")).sendKeys(Keys.ENTER);
    Thread.sleep(3000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Search'])[1]/following::div[5]")).click();
    Thread.sleep(2000);
    driver.findElement(By.linkText("home")).click();
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
