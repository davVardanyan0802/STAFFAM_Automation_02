package com.staff_am.testCases.trainingsPageTests;

import com.staff_am.pageObjects.BaseClass;
import com.staff_am.steps.testHelper.TrainingsTestsSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTest  extends BaseClass {
    TrainingsTestsSteps step;
    @BeforeMethod
    public void setTest(){
        driver.get("https://staff.am/en/trainings");
        step=new TrainingsTestsSteps(driver);
    }

    @Test
    public void test_0() throws InterruptedException{
        Thread.sleep(5000);
        step.verifySearch("Marketing",0);
        Thread.sleep(5000);
    }
    @Test
    public void test_1() throws InterruptedException {
        Thread.sleep(5000);
        step.verifySearch("Development",0);
    }
    @Test
    public void test_2() throws InterruptedException {
        Thread.sleep(5000);
        step.verifySearch("Banking",1);
    }
    @Test
    public void test_3()throws InterruptedException{
        Thread.sleep(5000);
        step.verifySearch("Human Resources",2);
    }
}
