package com.staff_am.testCases.companiesPageTests;

import com.staff_am.pageObjects.BaseClass;
import com.staff_am.steps.testHelper.CompaniesTestsSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultipleFilterTest extends BaseClass {
    CompaniesTestsSteps step;
    @BeforeMethod
    public void setTest()throws InterruptedException {
        Thread.sleep(5000);
        driver.get("https://staff.am/en/companies");
        step=new CompaniesTestsSteps(driver);
    }

    @Test
    public void test_0() throws InterruptedException {
        step.verifyMultipleFilter();
    }
}
