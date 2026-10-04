package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductDetails{

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://bhagyasubasinghe.github.io/FirstProject/");
    }

    @Test
    public void testProductDetails() {

        driver.findElement(By.linkText("WOMEN")).click();

        driver.findElement(By.cssSelector(".product-card")).click();

        String currentUrl = driver.getCurrentUrl();

        System.out.println("Product Details URL: " + currentUrl);

        Assert.assertTrue(
                currentUrl.toLowerCase().contains("product"),
                "Product details page was not opened"
        );

        Assert.assertTrue(
                driver.findElement(By.tagName("h1")).isDisplayed(),
                "Product name is not displayed"
        );
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
