package vytrack_assignment5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import vytrack_utils.ConfigurationReader;
import vytrack_utils.Driver;
import vytrack_utils.VytrackUserMethods;

public class AC_8 {
    @BeforeClass
    public void setUp() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env")); //going to our webpage, using configurations
        VytrackUserMethods.truckDriverLogin();// logging in as truck driver
        VytrackUserMethods.clickFleetClickVehicles();
    }

    @Test
    public void ac8(){   //8.Verify That Grid Setting button is on the right of the page
        WebElement GridSettingsButton =Driver.getDriver().findElement(By.xpath("//a[@title='Grid Settings']"));
        boolean isGridSettingButtonOnTheRightOfThePage = false;
        WebElement parentOfGridSettings = Driver.getDriver().findElement(By.xpath("//a[@title='Grid Settings']/../../.."));
        String rightOrLeft=parentOfGridSettings.getAttribute("class");
        if (rightOrLeft.contains("pull-right")){
            isGridSettingButtonOnTheRightOfThePage = true;
        }
        Assert.assertTrue(isGridSettingButtonOnTheRightOfThePage);

    }
    @AfterClass
    public void tearDown(){
        Driver.closeDriver();
    }
}
