package vytrack_assignment1;

import vytrack_utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class tc002 {
    WebDriver driver;
    @BeforeMethod
    public void setupMethod() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://qa3.vytrack.com/user/login");

    }
    @Test
    public void testing() throws IOException, InterruptedException {
        //Logging it
        WebElement usernameField = driver.findElement(By.xpath("//input[@name='_username']"));
        usernameField.sendKeys("user4");

        WebElement passwordField = driver.findElement(By.xpath("//input[@name='_password']"));
        passwordField.sendKeys("UserUser123");

        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();

        Thread.sleep(5000);

        String expTitle = "Dashboard";
        Assert.assertEquals(driver.getTitle(), expTitle, "Title does not match - Login not successful");

//clicking on fifth vehicle(can be any vehicle by requirements):
        driver.findElement(By.xpath("//tr[@class='grid-row row-click-action'][5]")).click();
        // Thread.sleep(4000);

//clicking on "ADD EVENT" button, and window pops up
        WebElement addEventButton= driver.findElement(By.xpath("//a[@title='Add an event to this record']"));
        //  Thread.sleep(3000);
        addEventButton.click();

//now  add TITLE and click SAVE button.
        String eventTitle="Cybertek2";
        driver.findElement(By.xpath("(//input[contains(@id, 'oro_calendar_event')])[1]")).sendKeys(eventTitle+ Keys.ENTER);
//finding and opening Activity
        WebElement x= driver.findElement(By.xpath("//a[@href='#scroll-2-1603']"));
        x.click();

        //checking if our event is there

        String actualResult =driver.findElement(By.xpath("(//strong[.='Cybertek2'])[1]")).getText();
        String expectedResult="Cybertek2";

        Assert.assertEquals(actualResult,expectedResult);

    }
}
