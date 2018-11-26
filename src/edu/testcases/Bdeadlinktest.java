/**
 * Tests every external link on every navigation bar page for dead links
 * 
 * Verifies by visiting one subsequent external page link
 * 
 * Note: possibility for outside factors to create false test failure
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
public class Bdeadlinktest {
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
  public void testBdeadlink() throws Exception {
	// driver.get("http://mav-market.ddns.net:8080/marketplace/home");
    driver.get("http://localhost:8080/marketplace/home");
    Thread.sleep(2000);
    driver.findElement(By.linkText("University of Nebraska Omaha")).click();
    driver.findElement(By.linkText("my.unomaha.edu")).click();
    // driver.get("http://mav-market.ddns.net:8080/marketplace/items");
    driver.get("http://localhost:8080/marketplace/items");
    Thread.sleep(2000);
    driver.findElement(By.linkText("University of Nebraska Omaha")).click();
    driver.findElement(By.linkText("my.unomaha.edu")).click();
    // driver.get("http://mav-market.ddns.net:8080/marketplace/login");
    driver.get("http://localhost:8080/marketplace/login");
    Thread.sleep(2000);
    driver.findElement(By.linkText("University of Nebraska Omaha")).click();
    driver.findElement(By.linkText("my.unomaha.edu")).click();
    // driver.get("http://mav-market.ddns.net:8080/marketplace/signup");
    driver.get("http://localhost:8080/marketplace/signup");
    Thread.sleep(2000);
    driver.findElement(By.linkText("University of Nebraska Omaha")).click();
    driver.findElement(By.linkText("my.unomaha.edu")).click();
    // driver.get("http://mav-market.ddns.net:8080/marketplace/home");
    driver.get("http://localhost:8080/marketplace/home");
    Thread.sleep(2000);
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
