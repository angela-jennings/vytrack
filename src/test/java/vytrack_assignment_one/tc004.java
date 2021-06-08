package vytrack_assignment_one;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class tc004 {

  // I opened a new project for this code that's why there is no WebDriverFactory
    WebDriver driver;

    @BeforeClass
    public void setupMethod() {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        driver.get("https://qa3.vytrack.com/user/login");
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa3.vytrack.com/user/login");
    }

    @Test
    public void loginMethod() throws InterruptedException {

        WebElement usernameField = driver.findElement(By.xpath("//input[@name='_username']"));
        usernameField.sendKeys("user4");

        WebElement passwordField = driver.findElement(By.xpath("//input[@name='_password']"));
        passwordField.sendKeys("UserUser123");

        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();

        Thread.sleep(5000);

        String expTitle = "Dashboard";
        Assert.assertEquals(driver.getTitle(), expTitle, "Title does not match - Login not successful");

        Actions action = new Actions(driver);
        WebElement fleetModuleTab = driver.findElement(By.xpath("//span[@class='title title-level-1'][1]"));
        action.moveToElement(fleetModuleTab).perform();

        WebElement vehiclesTab = driver.findElement(By.xpath("//a[@href='entity/Extend_Entity_Carreservation']"));
        action.moveToElement(vehiclesTab).perform();
        vehiclesTab.click();

        Thread.sleep(5000);

        //click to a new page so that you can see it reset
        WebElement pageSelector = driver.findElement(By.xpath("//i[@class='fa-chevron-right hide-text']"));
        pageSelector.click();

        Thread.sleep(5000);

        WebElement reset = driver.findElement(By.xpath("//a[@class='action btn reset-action mode-text-only']"));
        reset.click();
    }
}
