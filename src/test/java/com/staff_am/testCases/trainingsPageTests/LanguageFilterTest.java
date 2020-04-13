package com.staff_am.testCases.trainingsPageTests;

import com.staff_am.pageObjects.BaseClass;
import com.staff_am.steps.testHelper.TrainingsTestsSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LanguageFilterTest  extends BaseClass {
    TrainingsTestsSteps step;
    String language_0="English";
    String language_1="Armenian";
    String language_2="German";
    @BeforeMethod
    public void setTest()throws InterruptedException {
        Thread.sleep(5000);
        driver.get("https://staff.am/en/trainings");
        step=new TrainingsTestsSteps(driver);
    }

    @Test
    public void test_0()throws InterruptedException{
        step.verifyLanguageFilter("English",1);
    }
    @Test
    public void test_1()throws InterruptedException{
        step.verifyLanguageFilter("English",0);
    }
    @Test
    public void test_2()throws  InterruptedException{
        step.verifyLanguageFilter("Armenian",1);
    }
    @Test
    public void test_3()throws InterruptedException{
        step.verifyLanguageFilter("German",2);
    }
    @Test
    public void test_4()throws InterruptedException{
        step.verifyLanguageFilter("German",0);
    }
}
