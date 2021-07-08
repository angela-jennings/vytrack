package vytrack_assignment5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import vytrack_utils.*;

public class AC_1_2_3 {

    @Test
        /*
Verify That User should be able to click Export Grid dropdown

Scenario 1: Driver can click Export Grid dropdown
Given truck driver log into Vytrack
When truck driver click on fleet module tab
And click on vehicle button
And truck driver is able to click the export grid dropdown button
Then the export grid dropdown is displayed
     */
    public void Ac1Scenario1(){
        //Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        //VytrackUserMethods.truckDriverLogin();
        //VytrackUserMethods.clickFleetClickVehicles();
        Ac2Scenario1();  //create a before class to not have to rewrite each log in
        WebElement gridButtonDropdown = Driver.getDriver().findElement(By.xpath("(//a[@href='#'])[12]"));
        gridButtonDropdown.click();
        BrowserUtils.sleep(2);

        WebElement csvLink = Driver.getDriver().findElement(By.xpath("//a[@title='CSV']"));
        Assert.assertTrue(csvLink.isDisplayed());

        WebElement xlsxLink = Driver.getDriver().findElement(By.xpath("//a[@title='XLSX']"));
        Assert.assertTrue(xlsxLink.isDisplayed());

        Driver.getDriver().close();
    }

    @Test
    /*
Verify That Export Grid dropdown is on the left of the page

Scenario 1: Driver verifies Export Grid dropdown is on the left of the page
Given truck driver is logged into Vytrack
When driver clicks on fleet module tab
And clicks on vehicle button
Then driver should be able to see Export Grid dropdown on the left of the page
 */
    public void Ac2Scenario1(){
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        VytrackUserMethods.truckDriverLogin();
        VytrackUserMethods.clickFleetClickVehicles();

    }

    @Test
    /*
Verify That User should be able to click refresh button

Scenario 1: Driver can click refresh button and page refreshes
Given truck driver is on vehicle fleet page
When driver clicks reset button
Then the page should refresh
 */
    public void Ac3Scenario1(){
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        VytrackUserMethods.truckDriverLogin();
        VytrackUserMethods.clickFleetClickVehicles();

        WebElement refreshButton = Driver.getDriver().findElement(By.xpath("//a[@title='Refresh']"));
        refreshButton.click();
    }

}