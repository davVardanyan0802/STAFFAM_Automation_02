package com.staff_am.testCases;

import com.staff_am.pageObjects.BaseClass;
import com.staff_am.pageObjects.LoginPage;
import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class TC_LoginTest_01 extends BaseClass {
    @Test
    public void loginTest() throws InterruptedException, IOException {
        driver.get(baseURL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSignIn();
        Thread.sleep(3000);
        logger.info(" Clicked Sign in");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("loginform-email")));
        loginPage.setTxtUserName(username);
        logger.info("Username entered");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("loginform-password")));
        loginPage.setTxtPassword(password);

        logger.info("Password entered");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btn_login")));
        loginPage.clickSubmit();
        logger.info("Submit clicked");
        wait.until(ExpectedConditions.urlToBe("https://staff.am/en/users/resume/profile"));

        if (driver.getCurrentUrl().equals("https://staff.am/en/users/resume/profile")) {
            logger.info("Log In Successfully");
            Assert.assertTrue(true);
        } else {
            captureScreen(driver, "loginTest");
            logger.info("Log In Failed");
            Assert.assertTrue(false);


        }


    }

}
