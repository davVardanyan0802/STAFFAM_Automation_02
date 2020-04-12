package com.staff_am.testCases;

import com.staff_am.pageObjects.BaseClass;
import com.staff_am.pageObjects.JobPage;
import com.staff_am.steps.Step_MyProfile_To_Job;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;


public class TC_ViewMore_07 extends BaseClass {
    @Test
    public void viewMore() throws InterruptedException {
        Step_MyProfile_To_Job stepMyProfileToJob = new Step_MyProfile_To_Job();
        stepMyProfileToJob.profileToJob();
        logger.info("Went to main job page");
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("a[class*='load-more']")));

        JobPage jobPage = new JobPage(driver);
        jobPage.clickViewMore();
        logger.info("Clicked on View More button");


    }
}
