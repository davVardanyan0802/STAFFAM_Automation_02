package com.staff_am.testCases.trainingsPageTests;

import com.staff_am.pageObjects.BaseClass;
import com.staff_am.steps.testHelper.TrainingsTestsSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PriceFilterTest extends BaseClass {
    TrainingsTestsSteps step;
    @BeforeMethod
    public void setTest()throws InterruptedException {
        Thread.sleep(5000);
        driver.get("https://staff.am/en/trainings");
        step=new TrainingsTestsSteps(driver);
    }

    /*@Test
    public void test_0() throws InterruptedException {
        step.verifyPriceFilter(2,"Paid");
    }*/
    @Test
    public void test_1()throws InterruptedException{
        step.verifyPriceFilter(0,"Free");
    }
}
