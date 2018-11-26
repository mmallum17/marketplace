/**
 * Tests the ability of users to delete their listings
 * 
 * Verifies recreating listing if non-duplicate
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
public class Ideleteitemtest {
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
  public void testIdeleteitem() throws Exception {
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
    driver.findElement(By.linkText("list item")).click();
    Thread.sleep(1000);
    driver.findElement(By.name("itemName")).click();
    driver.findElement(By.name("itemName")).clear();
    driver.findElement(By.name("itemName")).sendKeys("Dentures");
    Thread.sleep(1000);
    driver.findElement(By.name("price")).clear();
    driver.findElement(By.name("price")).sendKeys("1");
    driver.findElement(By.name("price")).click();
    Thread.sleep(1000);
    driver.findElement(By.name("description")).click();
    driver.findElement(By.name("description")).clear();
    driver.findElement(By.name("description")).sendKeys("barely used.");
    Thread.sleep(1000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='List new item'])[1]/following::input[5]")).click();
    Thread.sleep(1000);
    driver.findElement(By.linkText("my items")).click();
    Thread.sleep(4000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='$15Location'])[1]/following::div[3]")).click();
    Thread.sleep(3000);
    driver.findElement(By.id("deleteButton")).click();
    Thread.sleep(3000);
    driver.findElement(By.name("confirmBtn")).click();
    Thread.sleep(3000);
    driver.findElement(By.linkText("marketplace")).click();
    Thread.sleep(1000);
    driver.findElement(By.name("search")).click();
    driver.findElement(By.name("search")).clear();
    driver.findElement(By.name("search")).sendKeys("dentures");
    Thread.sleep(4000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='logout'])[1]/following::button[1]")).click();
    Thread.sleep(4000);
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
