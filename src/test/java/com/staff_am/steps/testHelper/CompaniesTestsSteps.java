package com.staff_am.steps.testHelper;

import com.staff_am.pageObjects.CompaniesPage;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class CompaniesTestsSteps {
    CompaniesPage page;

    public CompaniesTestsSteps(WebDriver driver){

        page=new CompaniesPage(driver);
    }

    public void verifyMultipleFilter() throws InterruptedException {
        SoftAssert s=new SoftAssert();
        String a=page.getFilterText("Industry",2);
        page.setIndustryFilter(2);
        Thread.sleep(1500);
        String b=page.getFilterText("Employee",1);
        page.setEmployeeNumberFilter("50-200");
        Thread.sleep(2000);
        page.getFollowersCount(0);
        Thread.sleep(15000);
        page.clickOnCompaniesList(0);
        Thread.sleep(1000);
        if(b.contains("(0)")){
            System.out.println("There are no any company with selected filters");
        }else {
            s.assertTrue(a.contains(page.getIndustry()));
            s.assertTrue(b.contains(page.getEmployeeNumber()));
            s.assertAll();
        }
    }

    public void verifyDropDownSort(int index1,int index2) throws InterruptedException{
        SoftAssert s=new SoftAssert();
        if(index1<index2) {
            s.assertTrue(page.getTotalViewsCount(index1) > page.getTotalViewsCount(index2));
        }else if (index1>index2){
            s.assertTrue(page.getTotalViewsCount(index1) < page.getTotalViewsCount(index2));
        }else {
            s.assertTrue(page.getTotalViewsCount(index1) == page.getTotalViewsCount(index2));
        }
        page.dropDownSort("followers");
        Thread.sleep(10000);
        if(index1<index2) {
            s.assertTrue(page.getFollowersCount(index1) > page.getFollowersCount(index2));
        }else if(index1>index2){
            s.assertTrue(page.getFollowersCount(index1) < page.getFollowersCount(index2));
        }else{
            s.assertTrue(page.getFollowersCount(index1) == page.getFollowersCount(index2));
        }
        s.assertAll();
    }
}
