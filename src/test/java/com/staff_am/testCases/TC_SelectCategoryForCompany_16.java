package com.staff_am.testCases;

import com.staff_am.pageObjects.BaseClass;
import com.staff_am.pageObjects.MainPage;
import org.testng.Assert;

public class TC_SelectCategoryForCompany_16 extends BaseClass {
    public void SelectCategoryForCompany() throws InterruptedException {
        MainPage mainPage=new MainPage();
        driver.get(baseURL);
        Thread.sleep(3000);
        mainPage.company();
        mainPage.selectCategoryDropDown();
        String ExpURL = "https://staff.am/en/companies?CompaniesFilter%5BkeyWord%5D=&CompaniesFilter%5Bcategory%5D=";
        Assert.assertTrue(driver.getCurrentUrl().contains(ExpURL));
    }
}
