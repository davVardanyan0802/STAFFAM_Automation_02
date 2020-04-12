package com.staff_am.testCases.companiesPageTests;

import com.staff_am.pageObjects.BaseClass;
import com.staff_am.steps.testHelper.CompaniesTestsSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EmployeeNumberTests extends BaseClass {
    CompaniesTestsSteps step;
    String n_0="up to 50";
    String n_1="50-200";
    String n_2="200-500";
    String n_3="500-1500";
    String n_4="more than 1500";

    @BeforeMethod
    public void setTest()throws InterruptedException {
        Thread.sleep(5000);
        driver.get("https://staff.am/en/companies");
        step=new CompaniesTestsSteps(driver);
    }

    @Test
    public void test_0()throws InterruptedException{
        step.verifyEmployeesNumberFilter(n_0,0);
    }
    @Test
    public void test_1()throws InterruptedException{
        step.verifyEmployeesNumberFilter(n_0,1);
    }
    @Test
    public void test_2()throws InterruptedException{
        step.verifyEmployeesNumberFilter(n_1,1);
    }
    @Test
    public void test_3()throws InterruptedException{
        step.verifyEmployeesNumberFilter(n_2,2);
    }
    @Test
    public void test_4()throws InterruptedException{
        step.verifyEmployeesNumberFilter(n_3,3);
    }
    @Test
    public void test_5()throws InterruptedException{
        step.verifyEmployeesNumberFilter(n_4,4);
    }
    @Test
    public void test_6()throws InterruptedException{
        step.verifyEmployeesNumberFilter(n_4,0);
    }
}
