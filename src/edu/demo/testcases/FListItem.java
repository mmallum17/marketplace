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

public class FListItem {
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
  public void testListItem() throws Exception {
    driver.get("http://mav-market.ddns.net:8080/marketplace/login");
    Thread.sleep(3000);
    driver.findElement(By.name("email")).click();
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("bw327155@gmail.com");
    Thread.sleep(2000);
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("password");
    Thread.sleep(2000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Email: Password:'])[1]/input[3]")).click();
    Thread.sleep(4000);
    driver.findElement(By.linkText("here")).click();
    Thread.sleep(1000);
    driver.findElement(By.name("itemName")).click();
    driver.findElement(By.name("itemName")).clear();
    driver.findElement(By.name("itemName")).sendKeys("Batmobile");
    Thread.sleep(3000);
    driver.findElement(By.name("price")).clear();
    driver.findElement(By.name("price")).sendKeys("100");
    Thread.sleep(3000);
    driver.findElement(By.name("description")).click();
    driver.findElement(By.name("description")).clear();
    driver.findElement(By.name("description")).sendKeys("Gets 1000 MPG");
    Thread.sleep(3000);
//    driver.findElement(By.name("photo")).click();
//    driver.findElement(By.name("photo")).clear();
    driver.findElement(By.name("photo")).sendKeys("C:\\batmobile-the-tumbler-3d-model-max-obj-fbx-stl.jpg");
    Thread.sleep(3000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='List new item'])[1]/following::input[5]")).click();
    Thread.sleep(7000);
    driver.findElement(By.linkText("my items")).click();
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
