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

public class GEditItem {
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
  public void testEditItem() throws Exception {
    driver.get("http://mav-market.ddns.net:8080/marketplace/login");
    Thread.sleep(3000);
    driver.findElement(By.name("email")).click();
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("bw327155@gmail.com");
    Thread.sleep(2000);
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("password");
    Thread.sleep(2000);
    driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
    Thread.sleep(5000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Batmobile'])[1]/following::img[1]")).click();
    Thread.sleep(3000);
    driver.findElement(By.name("price")).click();
    Thread.sleep(1000);
    driver.findElement(By.name("price")).clear();
    Thread.sleep(1000);
    driver.findElement(By.name("price")).sendKeys("70");
    Thread.sleep(2000);
    driver.findElement(By.name("description")).click();
    Thread.sleep(1000);
    driver.findElement(By.name("description")).clear();
    Thread.sleep(1000);
    driver.findElement(By.name("description")).sendKeys("It's an electric car");
    Thread.sleep(3000);
    driver.findElement(By.name("saveChangesBtn")).click();
    Thread.sleep(5000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Batmobile'])[1]/following::img[1]")).click();
    Thread.sleep(5000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='$70'])[1]/following::span[1]")).click();
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
