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

public class TC_ClearFilters_04 extends BaseClass {

    @Test
    public void clrFilters() throws InterruptedException, IOException {
        Step_MyProfile_To_Job stepMyProfileToJob = new Step_MyProfile_To_Job();
        stepMyProfileToJob.profileToJob();
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//input[@type='checkbox']")));
        logger.info("Sign in and went to job board page");
        SoftAssert softAssert = new SoftAssert();

        JobPage jobPage = new JobPage(driver);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//input[@type='checkbox']")));


        jobPage.clickClearAllFilters();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//input[@type='checkbox']")));

        List<WebElement> allChecks = jobPage.getAllCheckboxes();
        for (WebElement check : allChecks) {
            if (!check.isSelected()) {
                logger.info("All checkboxes cleared");
                softAssert.assertTrue(true);
            } else {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0,500)");
                captureScreen(driver, "clear checkboxes");
                softAssert.assertTrue(false);
            }
        }

    }
}
