package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectSizeTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://bhagyasubasinghe.github.io/FirstProject/");
    }

    @Test
    public void testSelectSize() {

        driver.findElement(By.linkText("WOMEN")).click();

        driver.findElement(By.cssSelector(".product-card")).click();

        Assert.assertTrue(
                driver.getCurrentUrl().toLowerCase().contains("product"),
                "Product details page was not opened"
        );

        driver.findElement(By.cssSelector("select")).click();

        driver.findElement(
                By.cssSelector("select option:nth-child(2)")
        ).click();

        Assert.assertTrue(
                driver.findElement(By.cssSelector("select")).isDisplayed(),
                "Size selection was not displayed"
        );

        System.out.println("Size selected successfully");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}