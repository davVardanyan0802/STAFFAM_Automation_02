package com.staff_am.testCases;

import com.staff_am.pageObjects.BaseClass;
import com.staff_am.pageObjects.JobPage;
import com.staff_am.steps.Step_Login;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_JobsPage_02 extends BaseClass {

    @Test
    public void verifyJobsPage() throws InterruptedException, IOException {
        Step_Login step_login = new Step_Login();
        step_login.stepLogin();
        logger.info("Signed in");

        JobPage jobPage = new JobPage(driver);
        jobPage.jobBtnClick();
        logger.info("Clicked on job");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.urlToBe("https://staff.am/en/jobs"));

        if (driver.getCurrentUrl().equals("https://staff.am/en/jobs")) {
            logger.info("Job Page Successfully");
            Assert.assertTrue(true);
        } else {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,400)");
            captureScreen(driver, "Job Board fail");
            logger.info("Job board page Failed");
            Assert.assertTrue(false);


        }


    }
}
