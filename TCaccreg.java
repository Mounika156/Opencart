
package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.RegPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TCaccreg extends BaseClass{

    @Test
    public void verify_account_registration()
    {
        HomePage hp=new HomePage(driver);
        hp.clickMyAccount();
        hp.clickRegister();

        RegPage regpage=new RegPage(driver);

        regpage.setFirstName(randomeString().toUpperCase());
        regpage.setLastName(randomeString().toUpperCase());
        regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
        regpage.setTelephone(randomeNumber());

        String password=randomAlphaNumeric();

        regpage.setPassword(password);
        regpage.setConfirmPassword(password);

        regpage.setPrivacyPolicy();
        regpage.clickContinue();

        String confmsg=regpage.getConfirmationMsg();
        Assert.assertEquals(confmsg, "Your Account Has Been Created!");

    }




}


