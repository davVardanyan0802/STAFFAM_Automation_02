package com.staff_am.testCases;

import com.staff_am.pageObjects.BaseClass;
import com.staff_am.pageObjects.JobPage;
import com.staff_am.pageObjects.LoginPage;
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

public class TC_FilterLevel_06 extends BaseClass {

    @Test
    public void filterLevel() throws InterruptedException, IOException {
        Step_MyProfile_To_Job stepMyProfileToJob = new Step_MyProfile_To_Job();
        stepMyProfileToJob.profileToJob();
        logger.info("Went to main job page");
        Thread.sleep(4000);

        JobPage jobPage = new JobPage(driver);
        jobPage.clickSeniorBtn();
        logger.info("Senior filter clicked");
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("font_bold")));

        SoftAssert softAssert = new SoftAssert();

        List<WebElement> allSeniorTitles = jobPage.getTitles();

        for (WebElement seniorTitle : allSeniorTitles) {
            if (seniorTitle.getText().contains("Senior")) {
                logger.info("Senior positions");
                softAssert.assertTrue(true);
            } else {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0,500)");
                captureScreen(driver, "Senior filter fail");
                logger.warn("Filter is not matching");
                softAssert.assertTrue(false);
            }
        }

    }

}
