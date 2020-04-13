package com.staff_am.testCases;

import com.staff_am.pageObjects.BaseClass;
import com.staff_am.pageObjects.JobPage;
import com.staff_am.steps.Step_Login;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_SighOut_05 extends BaseClass {

    @Test
    public void signOut() throws InterruptedException, IOException {
        Step_Login step_login = new Step_Login();
        step_login.stepLogin();


        JobPage jobPage = new JobPage(driver);
        jobPage.clickLogOut();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("sign-in-btn")));
        if (driver.getCurrentUrl().equals("https://staff.am/")) {
            logger.info("Log out success");
            Assert.assertTrue(true);
        } else {
            captureScreen(driver, "Log Out");
            logger.warn("Log out failed");
            Assert.assertTrue(false);
        }
    }
}
