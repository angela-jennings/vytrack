package vytrack_assignment5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import vytrack_utils.*;

public class ExportGridDropdown {
    @Test
    public void driverClickExportDropdown(){
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        VytrackUserMethods.truckDriverLogin();
        VytrackUserMethods.clickFleetClickVehicles();

        WebElement gridButtonDropdown = Driver.getDriver().findElement(By.xpath("(//a[@href='#'])[12]"));
        gridButtonDropdown.click();
        BrowserUtils.sleep(2);

        WebElement csvLink = Driver.getDriver().findElement(By.xpath("//a[@title='CSV']"));
        Assert.assertTrue(csvLink.isDisplayed());

        WebElement xlsxLink = Driver.getDriver().findElement(By.xpath("//a[@title='XLSX']"));
        Assert.assertTrue(xlsxLink.isDisplayed());

        Driver.getDriver().close();
    }

}