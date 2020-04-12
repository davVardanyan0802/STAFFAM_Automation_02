package com.staff_am.testCases;

import com.staff_am.pageObjects.BaseClass;
import com.staff_am.pageObjects.JobPage;
import com.staff_am.steps.Step_MyProfile_To_Job;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;

public class TC_FilterCity_08 extends BaseClass {
    @Test
    public void filterByCity() throws InterruptedException, IOException {
        Step_MyProfile_To_Job stepMyProfileToJob = new Step_MyProfile_To_Job();
        stepMyProfileToJob.profileToJob();
        SoftAssert softAssert = new SoftAssert();
        logger.info("Went to main job page");
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("a[class*='load-more']")));

        JobPage jobPage = new JobPage(driver);
        jobPage.clickFilterYerevan();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("a[class*='load-more']")));

        List<WebElement> locations = jobPage.getJoLocationTitles();

        for (WebElement location : locations) {
            if (location.getText().equals("Yerevan")) {

                softAssert.assertTrue(true);
            } else {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0,500)");
                captureScreen(driver, "Job Location");
                logger.warn("Job location is not matching");
                softAssert.assertTrue(false);
            }
        }
    }
}
