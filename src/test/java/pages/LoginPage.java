package pages;
import org.openqa.selenium.support.PageFactory;
import vytrack_utils.Driver;

import org.openqa.selenium.support.PageFactory;
import vytrack_utils.Driver;

public class LoginPage {
   public LoginPage(){
       PageFactory.initElements(Driver.getDriver(), this);
       //some changes
   }
}
