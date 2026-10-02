package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testHomePage() {

        driver.get("https://bhagyasubasinghe.github.io/FirstProject/");

        String title = driver.getTitle();

        System.out.println("Page Title: " + title);

        Assert.assertTrue(
                title.toLowerCase().contains("nadiyas"),
                "Nadiyas title was not found"
        );
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
