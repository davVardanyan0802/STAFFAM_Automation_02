package com.staff_am.testCases;

import com.staff_am.pageObjects.BaseClass;
import com.staff_am.pageObjects.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_SelectCategoryAndCities_11 extends BaseClass {
    @Test
    public void selectCategoryCities() throws InterruptedException {
        MainPage mainPage=new MainPage(driver);
        driver.get(baseURL);
        Thread.sleep(3000);
        mainPage.selectCateroryAndCities();
        Thread.sleep(3000);
        mainPage.clickOnSearch();
        Thread.sleep(3000);
        String ExpURl="https://staff.am/en/jobs/";
        Assert.assertTrue(driver.getCurrentUrl().contains(ExpURl));
    }
}
