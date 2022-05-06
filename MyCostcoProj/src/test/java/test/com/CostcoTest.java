/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package test.com;

import java.time.Duration;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



/**
 *
 * @author 18478
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CostcoTest {

//        static {
//       System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");
//        }
//       ChromeDriver driver = new ChromeDriver();
   
    private WebDriver driver;
    private String baseUrl;

    public CostcoTest() {
    }

    @Test
   
    public void test1CostcoSearch() throws Exception {
        System.out.println("1test");
        System.setProperty("webdriver.chrome.driver", "c:\\\\data\\\\chromedriver.exe");
        
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("headless");
//        ChromeDriver driver = new ChromeDriver(options);
        
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com/";
        
        driver.get("https://www.costco.com/");
        driver.manage().window().maximize();
// Search
        driver.findElement(By.id("search-field")).click();
        driver.findElement(By.id("search-field")).clear();
        driver.findElement(By.id("search-field")).sendKeys("dell laptop");
        driver.findElement(By.id("formcatsearch")).submit();
        //Thread.sleep(3000);
        test2AddToCart();
    }
//Add to cart
 
    public void test2AddToCart() throws Exception {
        System.out.println("2test");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 200)");
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@automation-id=\"productImageLink_0\"]")));

        driver.findElement(By.xpath("//img[@automation-id=\"productImageLink_0\"]")).click();

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait1.until(ExpectedConditions.visibilityOfElementLocated((By.id("add-to-cart-btn"))));

        driver.findElement(By.id("add-to-cart-btn")).click();
        //Thread.sleep(15000);

        // Wait for the pop up element to be visible
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='costcoModal']/div/div/div/button/span")));
        WebElement elem = driver.findElement(By.xpath("//div[@id='costcoModal']/div/div/div/button/span"));
        elem.click();
        //driver.findElement(By.xpath("//div[@id='costcoModal']/div/div/div/button/span")).click();

        //Go to cart        
        driver.findElement(By.id("cart-d")).click();

        //JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 400)");

        driver.findElement(By.id("shopCartCheckoutSubmitButton")).click();
        test3LogIn();
    }
    //Login   

    
    
    public void test3LogIn() throws Exception {
        System.out.println("3test");
        
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInName")));
        WebElement elem1 = driver.findElement(By.id("signInName"));
        elem1.sendKeys("liliana4.d.s@gmail.com");
        
        //driver.findElement(By.id("signInName")).sendKeys("liliana4.d.s@gmail.com");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("Infotek123@");
        driver.findElement(By.xpath("//button[@id=\"next\"]")).click();
       
        
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollTo(0, 200)");
        
        WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait4.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//input[@id=\"shopAsNonMemberBtn\"]"))));
        driver.findElement(By.xpath("//input[@id=\"shopAsNonMemberBtn\"]")).click();
        
        Thread.sleep(4000);
        
        driver.quit();
    }
}
