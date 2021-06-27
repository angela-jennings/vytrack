package vytrack_assignment5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import vytrack_utils.ConfigurationReader;
import vytrack_utils.Driver;
import vytrack_utils.VytrackUserMethods;

public class AC_7 {   //7.Verify That Grid Settings should be on the right side of the Reset button
    @BeforeClass
    public void setUp() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env")); //going to our webpage, using configurations
        VytrackUserMethods.truckDriverLogin();// logging in as truck driver
        VytrackUserMethods.clickFleetClickVehicles();
    }
//
    @Test
    public void ac7() {
        boolean isGridSettingsOnTheRightOfResetButton = false;
        WebElement GridSettingsButton =Driver.getDriver().findElement(By.xpath("//a[@title='Grid Settings']"));
        WebElement ResetButton =Driver.getDriver().findElement(By.xpath("//a[@title='Reset']"));
        String xPath = "//a[@title='Grid Settings']/..//preceding-sibling::a[@title='Reset']";
        WebElement element = Driver.getDriver().findElement(By.xpath(xPath));
       if (element.isDisplayed()){
           isGridSettingsOnTheRightOfResetButton = true;
       }
       Assert.assertTrue(isGridSettingsOnTheRightOfResetButton);
    }


    @AfterClass
    public void tearDown(){
        Driver.closeDriver();
    }

}

