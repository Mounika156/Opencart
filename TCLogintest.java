package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TCLogintest extends BaseClass {
    @Test
    public void verify_login()
    {

        try
        {
            //Home page
            HomePage hp=new HomePage(driver);
            hp.clickMyAccount();
           // hp.clickLogin(); //Login link under MyAccount

            //Login page
            LoginPage lp=new LoginPage(driver);
            lp.setEmail(p.getProperty("email"));
            lp.setPassword(p.getProperty("password"));
            lp.clickLogin(); //Login button

            //My Account Pag
            MyAccountPage macc=new MyAccountPage(driver);

            boolean targetPage=macc.isMyAccountPageExists();

            Assert.assertEquals(targetPage, true,"Login failed");
        }
        catch(Exception e)
        {
            Assert.fail();
        }

    }

}
