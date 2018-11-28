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

public class JRemoveItem {
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
  public void testRemoveItem() throws Exception {
    driver.get("http://mav-market.ddns.net:8080/marketplace/login");
    Thread.sleep(3000);
    driver.findElement(By.name("email")).click();
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("bw327155@gmail.com");
    Thread.sleep(3000);
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("password");
    Thread.sleep(3000);
    driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
    Thread.sleep(3000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Batmobile'])[1]/following::img[1]")).click();
    Thread.sleep(5000);
    driver.findElement(By.id("deleteButton")).click();
    Thread.sleep(5000);
    driver.findElement(By.name("confirmBtn")).click();
    Thread.sleep(5000);
    driver.findElement(By.linkText("marketplace")).click();
    Thread.sleep(3000);
    driver.findElement(By.id("txtSearch")).click();
    driver.findElement(By.id("txtSearch")).clear();
    driver.findElement(By.id("txtSearch")).sendKeys("batmobile");
    Thread.sleep(3000);
    driver.findElement(By.id("txtSearch")).sendKeys(Keys.ENTER);
    Thread.sleep(3000);
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
