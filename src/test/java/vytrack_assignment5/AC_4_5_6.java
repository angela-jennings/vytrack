package vytrack_assignment5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import vytrack_utils.BrowserUtils;
import vytrack_utils.ConfigurationReader;
import vytrack_utils.Driver;
import vytrack_utils.VytrackUserMethods;

import java.util.List;

public class AC_4_5_6 {


    @BeforeClass
    public void setUp()  {

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        VytrackUserMethods.truckDriverLogin();
        VytrackUserMethods.clickFleetClickVehicles();

    }

    @Test
    public void tc004_reset_button() {

        // Scenario 1: Driver can click reset button and page refreshes

//        Given truck driver log into Vytrack
//        When truck driver click on fleet module tab
//        And click on reset button
//        Then the truck driver able to refresh the page


//          BrowserUtils.sleep(2);
//        WebElement page4 = Driver.getDriver().findElement(By.xpath("//a[@data-grid-pagination-direction='next']"));
//        page4.click();
//
//        BrowserUtils.sleep(2);
//        WebElement resetButton = Driver.getDriver().findElement(By.xpath("(//i[@class='fa-refresh'])[2]"));
//        resetButton.click();
//
//        WebElement page1 = Driver.getDriver().findElement(By.xpath("//input[contains(@value,'1')]"));
//
//        if(page1.getAttribute("value").equals("1")){
//
//            System.out.println("Page successfully refresh");
//        }
//        else {
//            System.out.println("Page is not successfully refresh");
//        }

        // Second Way
        WebElement resetButton = Driver.getDriver().findElement(By.xpath("//a[@title='Reset']"));
        resetButton.click();
        Assert.assertTrue(resetButton.isEnabled());

    }


    @Test
    public void tc005_grid_settings() {

//           Scenario 1: Driver can click grid settings button and drop down menu appears
//        Given truck driver log into Vytrack
//        When truck driver click on fleet module tab
//        And click on grid settings button
//        Then the truck driver able to see drop down menu


        BrowserUtils.sleep(2);
        WebElement gritSettingButton = Driver.getDriver().findElement(By.xpath("//div/a[@ title = 'Grid Settings']/i"));
        gritSettingButton.click();

        BrowserUtils.sleep(2);
        WebElement setting = Driver.getDriver().findElement(By.xpath("//div[.='Grid Settings']"));

        String expected = "Grid Settings";
        String actual = setting.getText();

        Assert.assertEquals(actual, expected);
        BrowserUtils.sleep(2);

    }


    @Test
    public void tc006_refresh_button_on_the_left_side_of_the_reset_button() {

//             Scenario 1: Driver verifies refresh button is on the left side of the Reset button
//        Given truck driver log into Vytrack
//        When truck driver click on fleet module tab
//        And click on refresh button
//        Then the truck driver able to see that refresh button on the left side of the Reset button


        BrowserUtils.sleep(2);
        WebElement refresh = Driver.getDriver().findElement(By.xpath("//a[@title = 'Refresh']//following-sibling::a[@title='Reset']"));

        Assert.assertTrue(refresh.isDisplayed());


    }

}
