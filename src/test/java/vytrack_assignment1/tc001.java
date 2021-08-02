package vytrack_assignment1;

import vytrack_utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class tc001 {
WebDriver driver;

//Acceptance Criteria:
//1.Verify that truck driver should be able to see all Vehicle information once navigate to Vehicle page.
//	Given that I am logged into Vytrack
//	When I click on Fleet Module tab
//	and click on Vehicle
//	Then I should be able to view all Vehicle information

    /*

    1. Navigate to vytrack login page: https://qa3.vytrack.com/user/login
    2. Enter username for truck driver: user4
    3. Enter password for truck driver: UserUser123
        3a. Title match - Expected: Dashboard
    4. Hover over "Fleet"
    5. Click to "Vehicle"
    6. Ensure driver has access to all vehicles
        6a. Title match - Expected: Car - Entities - System - Car - Entities - System

     */
@BeforeClass
    public void setUp(){
    driver = WebDriverFactory.getDriver("chrome");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("https://qa3.vytrack.com/user/login");
}

@Test
    public void truckDriverLogIn() throws InterruptedException {

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

    String expAllVehiclesTitle = "Car - Entities - System - Car - Entities - System";
    Assert.assertEquals(driver.getTitle(), expAllVehiclesTitle, "Title does not match - Vehicles page not accessed");

    //Test

    //PracticeTest
    //PracticeTest
    //PracticeTest
    //PracticeTest
    //PracticeTest
}

}
