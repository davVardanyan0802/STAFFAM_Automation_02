package com.staff_am.testCases;

import com.staff_am.pageObjects.BaseClass;
import com.staff_am.pageObjects.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_SelectKeywordByCompany_17 extends BaseClass {
    @Test
    public void selectKeywordForCompany() throws InterruptedException {
        MainPage mainPage=new MainPage(driver);
        driver.get(baseURL);
        Thread.sleep(3000);
        mainPage.company();
        mainPage.writtingSendkeys("qa");
        Thread.sleep(3000);
        mainPage.clickOnSearch();
        Thread.sleep(3000);
        String ExpUrl = "https://staff.am/en/companies?CompaniesFilter%5BkeyWord%5D=qa&CompaniesFilter%5Bcategory%5D=&CompaniesFilter%5Bindustries%5D=";
        Assert.assertTrue(driver.getCurrentUrl().contains(ExpUrl));
    }
}
