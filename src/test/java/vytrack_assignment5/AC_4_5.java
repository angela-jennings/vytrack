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

public class AC_4_5 {


    @BeforeClass
    public void setUp()  {

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        VytrackUserMethods.truckDriverLogin();
        VytrackUserMethods.clickFleetClickVehicles();

    }

    @Test
    public void tc4(){


        BrowserUtils.sleep(2);
        WebElement page4 = Driver.getDriver().findElement(By.xpath("//a[@data-grid-pagination-direction='next']"));

        page4.click();

        BrowserUtils.sleep(2);
        WebElement resetButton = Driver.getDriver().findElement(By.xpath("(//i[@class='fa-refresh'])[2]"));

        resetButton.click();

        BrowserUtils.sleep(2);
        WebElement page1 = Driver.getDriver().findElement(By.xpath("//input[contains(@value,'1')]"));

        if(page1.getAttribute("value").equals("1")){

            System.out.println("Page successfully refresh");
        }
        else {
            System.out.println("Page is not successfully refresh");
        }

    }

    @Test
    public void tc5(){


        BrowserUtils.sleep(2);
        WebElement gritSettingButton = Driver.getDriver().findElement(By.xpath("//div/a[@ title = 'Grid Settings']/i"));
        gritSettingButton.click();

        BrowserUtils.sleep(2);
        WebElement setting = Driver.getDriver().findElement(By.xpath("//div[.='Grid Settings']"));

        String expected = "Grid Settings";
        String actual = setting.getText();

        Assert.assertEquals(actual, expected);



    }


}
