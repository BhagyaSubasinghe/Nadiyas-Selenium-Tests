package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NavigationTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://bhagyasubasinghe.github.io/FirstProject/");
    }

    @Test
    public void testWomenPage() {

        // Click Women
        driver.findElement(By.linkText("WOMEN")).click();

        // Get current URL
        String currentUrl = driver.getCurrentUrl();

        System.out.println("Current URL: " + currentUrl);

        // Verify Women page opened
        Assert.assertTrue(
                currentUrl.toLowerCase().contains("women"),
                "Women page was not opened"
        );
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
