package com.staff_am.testCases;

import com.staff_am.pageObjects.BaseClass;
import com.staff_am.pageObjects.JobPage;
import com.staff_am.steps.Step_MyProfile_To_Job;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;

public class TC_Search_03 extends BaseClass {

    @Test
    public void verifySearch() throws InterruptedException, IOException {
        Step_MyProfile_To_Job stepMyProfileToJob = new Step_MyProfile_To_Job();
        stepMyProfileToJob.profileToJob();
        logger.info("Sign in and went to job board page");

        JobPage jobPage = new JobPage(driver);
        jobPage.searchField("QA");
        logger.info("Search term entered");
        jobPage.clickSearchBtn();
        logger.info("Search button clicked");
        Thread.sleep(7000);



        SoftAssert softAssert = new SoftAssert();


        List<WebElement> allTitles = jobPage.getTitles();

        for (WebElement title : allTitles) {
            if (title.getText().contains(searchTerm)) {
                logger.info("Search matches");
                softAssert.assertTrue(true);
            } else {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0,500)");
                captureScreen(driver, "search");
                logger.warn("Search is not matching");
                softAssert.assertTrue(false);
            }
        }


    }

}
