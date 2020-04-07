package com.staff_am.steps;

import com.staff_am.pageObjects.BaseClass;
import com.staff_am.pageObjects.JobPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Step_MyProfile_To_Job extends BaseClass {

    public void profileToJob() throws InterruptedException {
        Step_Login step_login = new Step_Login();
        step_login.stepLogin();

        JobPage jobPage = new JobPage(driver);
        jobPage.jobBtnClick();

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.urlToBe("https://staff.am/en/jobs"));

    }
}
