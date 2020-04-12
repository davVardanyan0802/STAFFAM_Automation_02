package com.staff_am.testCases;

import com.staff_am.pageObjects.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_SelectCategoryAndCities_11 extends MainPage {
    @Test
    public void selectCategoryCities() throws InterruptedException {
        MainPage mainPage=new MainPage();
        driver.get(baseURL);
        Thread.sleep(3000);
        mainPage.selectCateroryAndCities();
        Thread.sleep(3000);
        mainPage.setSearchButtonOnMainPageClick();
        String ExpURl="https://staff.am/en/jobs/categories/index?JobsFilter%5Bkey_word%5D=&JobsFilter%5Bcategory%5D%5B0%5D=4&JobsFilter%5Bjob_city%5D%5B0%5D=2";
        Assert.assertTrue(driver.getCurrentUrl().contains(ExpURl));
    }
}
