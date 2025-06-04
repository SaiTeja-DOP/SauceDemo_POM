package TestCases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.Test;

import Base.BaseTest;
import PageObjects.HomePage;
import Utilities.ExtentReportManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class LoginTest extends BaseTest {

    HomePage hp;
    ExtentReports extent = ExtentReportManager.getReportInstance();
    ExtentTest test;

    @BeforeMethod
    public void setUpPages() {
        hp = new HomePage(d);
    }

    @Test(priority = 1)
    public void loginWithValidCredentials() {
        test = extent.createTest("Login with Valid Credentials");

        hp.clearText();
        hp.enterCreds("standard_user", "secret_sauce");
        test.log(Status.INFO, "Entered valid username and password");

        hp.clickLogin();
        test.log(Status.INFO, "Clicked login button");

        String head = hp.getProductsTitle();
        assertEquals(head, "Product");
        test.log(Status.PASS, "Login successful, 'Products' title verified");
    }

    @Test(priority = 2)
    public void loginWithInvalidUsername() {
        test = extent.createTest("Login with Invalid Username");

        hp.clearText();
        hp.enterCreds("standard_user", "wrong_pass");
        test.log(Status.INFO, "Entered valid username with invalid password");

        hp.clickLogin();
        test.log(Status.INFO, "Clicked login button");

        String err = hp.getError();
        assertEquals(err, "Epic sadface: Username and password do not match any user in this service");
        test.log(Status.PASS, "Proper error message verified for invalid login");
    }

    @AfterMethod
    public void flushReport() {
        extent.flush();
    }

}
