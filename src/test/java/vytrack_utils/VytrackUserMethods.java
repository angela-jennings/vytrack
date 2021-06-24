package vytrack_utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class VytrackUserMethods {

    public static void truckDriverLogin(){
        WebElement usernameField = Driver.getDriver().findElement(By.xpath("//input[@name='_username']"));
        usernameField.sendKeys(ConfigurationReader.getProperty("username"));

        WebElement passwordField = Driver.getDriver().findElement(By.xpath("//input[@name='_password']"));
        passwordField.sendKeys(ConfigurationReader.getProperty("password"));

        WebElement submitButton = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();

        BrowserUtils.sleep(2);
    }
    public static void salesManagerLogin(){
        WebElement usernameField = Driver.getDriver().findElement(By.xpath("//input[@name='_username']"));
        usernameField.sendKeys("storemanager53");

        WebElement passwordField = Driver.getDriver().findElement(By.xpath("//input[@name='_password']"));
        passwordField.sendKeys("UserUser123");

        WebElement submitButton = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();

        BrowserUtils.sleep(2);
    }
    public static void storeMangerLogin(){
        WebElement usernameField = Driver.getDriver().findElement(By.xpath("//input[@name='_username']"));
        usernameField.sendKeys("salesmanager104");

        WebElement passwordField = Driver.getDriver().findElement(By.xpath("//input[@name='_password']"));
        passwordField.sendKeys("UserUser123");

        WebElement submitButton = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();

        BrowserUtils.sleep(2);
    }

    public static void clickFleetClickVehicles(){

        Actions actions = new Actions(Driver.getDriver());
        WebElement fleetModuleTab = Driver.getDriver().findElement(By.xpath("//span[@class='title title-level-1'][1]"));
        actions.moveToElement(fleetModuleTab).perform();

        WebElement vehiclesTab = Driver.getDriver().findElement(By.xpath("//a[@href='entity/Extend_Entity_Carreservation']"));
        actions.moveToElement(vehiclesTab).perform();
        vehiclesTab.click();

        BrowserUtils.sleep(2);


    }
}
