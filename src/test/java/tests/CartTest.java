package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CartTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://bhagyasubasinghe.github.io/FirstProject/");
    }

    @Test
    public void testCart() {

        wait.until(
                ExpectedConditions.elementToBeClickable(By.linkText("WOMEN"))
        ).click();

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector(".product-card")
                )
        ).click();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("size")
                )
        );

        driver.findElement(By.id("size")).click();

        driver.findElement(
                By.cssSelector("#size option:nth-child(2)")
        ).click();

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector(".add-cart")
                )
        ).click();

        Alert alert = wait.until(
                ExpectedConditions.alertIsPresent()
        );

        System.out.println("Alert Message: " + alert.getText());

        Assert.assertEquals(
                alert.getText(),
                "Product added to cart!",
                "Unexpected alert message"
        );

        alert.accept();

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("a[href='cart.html']")
                )
        ).click();

        wait.until(
                ExpectedConditions.urlContains("cart.html")
        );

        String currentUrl = driver.getCurrentUrl();

        System.out.println("Cart URL: " + currentUrl);

        Assert.assertTrue(
                currentUrl.toLowerCase().contains("cart"),
                "Cart page was not opened"
        );

        System.out.println("Cart page opened successfully");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}