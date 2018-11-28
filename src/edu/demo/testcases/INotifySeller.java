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

public class INotifySeller {
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
  public void testNotifySeller() throws Exception {
	    driver.get("http://mav-market.ddns.net:8080/marketplace/login");
	    Thread.sleep(3000);
	    driver.findElement(By.name("email")).click();
	    driver.findElement(By.name("email")).clear();
	    driver.findElement(By.name("email")).sendKeys("ck1234@gmail.com");
	    Thread.sleep(2000);
	    driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).sendKeys("password");
	    Thread.sleep(2000);
	    driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
	    Thread.sleep(3000);
	    driver.findElement(By.linkText("marketplace")).click();
	    Thread.sleep(7000);
	    driver.findElement(By.id("txtSearch")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.id("txtSearch")).clear();
	    driver.findElement(By.id("txtSearch")).sendKeys("batmobile");
	    Thread.sleep(3000);
	    driver.findElement(By.id("txtSearch")).sendKeys(Keys.ENTER);
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='logout'])[1]/following::div[10]")).click();
	    Thread.sleep(7000);
	    driver.findElement(By.id("notifyBtn")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.name("userName")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.name("userName")).clear();
	    Thread.sleep(1000);
	    driver.findElement(By.name("userName")).sendKeys("Clark");
	    Thread.sleep(2000);
	    driver.findElement(By.name("userEmail")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.name("userPhone")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.name("userPhone")).clear();
	    driver.findElement(By.name("userPhone")).sendKeys("123-456-7890");
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Notify Seller'])[2]/following::form[1]")).click();
	    driver.findElement(By.name("saveChangesBtn")).click();
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
