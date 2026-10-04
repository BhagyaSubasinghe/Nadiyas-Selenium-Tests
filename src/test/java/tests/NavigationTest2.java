package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NavigationTest2 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://bhagyasubasinghe.github.io/FirstProject/");
    }

    @Test
    public void testWomenPage() {
        driver.findElement(By.linkText("WOMEN")).click();

        String currentUrl = driver.getCurrentUrl();

        System.out.println("Women URL: " + currentUrl);

        Assert.assertTrue(
                currentUrl.toLowerCase().contains("women"),
                "Women page was not opened"
        );
    }

    @Test
    public void testMenPage() {
        driver.findElement(By.linkText("MEN")).click();

        String currentUrl = driver.getCurrentUrl();

        System.out.println("Men URL: " + currentUrl);

        Assert.assertTrue(
                currentUrl.toLowerCase().contains("men"),
                "Men page was not opened"
        );
    }

    @Test
    public void testKidsPage() {
        driver.findElement(By.linkText("KIDS")).click();

        String currentUrl = driver.getCurrentUrl();

        System.out.println("Kids URL: " + currentUrl);

        Assert.assertTrue(
                currentUrl.toLowerCase().contains("kids"),
                "Kids page was not opened"
        );
    }

    @Test
    public void testUnisexPage() {
        driver.findElement(By.linkText("UNISEX")).click();

        String currentUrl = driver.getCurrentUrl();

        System.out.println("Unisex URL: " + currentUrl);

        Assert.assertTrue(
                currentUrl.toLowerCase().contains("unisex"),
                "Unisex page was not opened"
        );
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}