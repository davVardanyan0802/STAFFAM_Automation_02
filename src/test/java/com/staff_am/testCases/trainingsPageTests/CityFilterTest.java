package com.staff_am.testCases.trainingsPageTests;

import com.staff_am.pageObjects.BaseClass;
import com.staff_am.steps.testHelper.TrainingsTestsSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CityFilterTest  extends BaseClass {
    TrainingsTestsSteps step;
    String city_0="Yerevan";
    String city_1="Online";
    @BeforeMethod
    public void setTest()throws InterruptedException {
        Thread.sleep(5000);
        driver.get("https://staff.am/en/trainings");
        step=new TrainingsTestsSteps(driver);
    }

    @Test
    public void test_0()throws InterruptedException{
        step.verifyCityFilter(city_0,0);
    }
    @Test
    public void test_1()throws InterruptedException{
        step.verifyCityFilter(city_0,1);
    }
    @Test
    public void test_2()throws InterruptedException{
        step.verifyCityFilter(city_1,1);
    }
    @Test
    public void test_3()throws InterruptedException{
        step.verifyCityFilter(city_1,0);
    }
}
