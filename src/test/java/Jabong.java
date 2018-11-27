import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.fail;
import org.openqa.selenium.interactions.Actions;

public class Jabong {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass

    public void setUp() throws Exception {
        String sDirpath=System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", sDirpath+ "/driver/chromedriver.exe");
        driver =  new ChromeDriver();
       // baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void JabongTest() throws Exception {
       driver.get("https://www.jabong.com/");
        driver.findElement(By.name("button")).click();
        WebElement element = driver.findElement(By.xpath("//a[@data-pos='1']"));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        driver.findElement(By.xpath("//a[@data-hpos='3'][contains(text(),'Flats')]")).click();
        driver.findElement(By.xpath("//section[@class='row search-product animate-products']//div[9]//a[1]//figure[1]//img[1]")).click();
       driver.findElement(By.xpath("//a[@class='back-page']")).click();
        driver.findElement(By.xpath("//div[@class='preference']//label[@class='hide-on-mobile']//small[contains(text(),'[6]')]")).click();

     //  driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Jeans");
       // driver.findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.BACK_SPACE);
      //  driver.findElement(By.xpath("//span[@class='top-search-icon hidden-xs']")).click();
       // driver.findElement(By.xpath("//section[@class='row search-product animate-products']//div[3]//a[1]//figure[1]//div[2]//div[1]")).click();

       // for(String winHandle : driver.getWindowHandles()){
       //     driver.switchTo().window(winHandle);
       // }
//        driver.findElement(By.name("button")).click();
       //river.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Amazon Scout | Style explorer'])[1]/following::span[2]")).click();
       // driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Smart speaker with Alexa'])[1]/following::span[1]")).click();

     //   Reporter.log("This scenario has been PASSED");
   //  WebElement element1 = driver.findElement(By.xpath("//span[contains(@class,'nav-item')]//span[@class='nav-text'][contains(text(),\"Women's Fashion\")]"));
     //  action.moveToElement(element1).build().perform();
  //    driver.findElement(By.xpath("//a[@data-hpos='3'][contains(text(),'Flats')]")).click();
    //   Reporter.log("This scenario has been PASSED");
//
//        //System.out.println("MHH Passed");
//     driver.findElement(By.xpath("//span[contains(text(), 'Full Store Directory')]")).click();
  //     driver.findElement(By.xpath("//div[@id='100_dealView_0']//div[@class='a-row layer backGround']")).click();
//        //driver.findElement(By.xpath("//h2[contains(text(),\"Neo Analog Black Dial Men's Watch-1766SL02\")]")).click();

      //  driver.findElement(By.id("lst-ib")).sendKeys("amazon");
      //  driver.findElement(By.id("lst-ib")).sendKeys(Keys.ENTER);


        // driver.get("https://www.google.co.in/search?q=amazon&rlz=1C1GCEU_enIN823&oq=amazon&aqs=chrome.0.69i59j69i60l3j0l2.3527j0j7&sourceid=chrome&ie=UTF-8");
          //  driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Web results'])[1]/following::h3[1]")).click();
           // driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Screen Protectors'])[1]/following::span[1]")).click();
          //  driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Power Banks'])[4]/following::img[1]")).click();
          /*  driver.findElement(By.id("nav-cart")).click();
            driver.findElement(By.id("a-autoid-0-announce")).click();
            driver.findElement(By.id("dropdown1_4")).click();
            driver.findElement(By.name("proceedToCheckout")).click();
            driver.findElement(By.id("ap_email")).click();
            driver.findElement(By.id("ap_email")).clear();
            driver.findElement(By.id("ap_email")).sendKeys("sharmisain123@gmail.com");
            driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Enter your email or mobile phone number'])[1]/following::input[2]")).click();
            driver.findElement(By.id("ap_password")).clear();
            driver.findElement(By.id("ap_password")).sendKeys("rayan@143");
            driver.findElement(By.id("signInSubmit")).click();
            driver.findElement(By.linkText("Deliver to this address UST Global, Carnival sez, Infopark, Kakkanad")).click();
            driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Looking'])[1]/following::img[3]")).click(); */
        }


    @AfterClass
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
