package com.staff_am.testCases;

import com.staff_am.pageObjects.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_SelectCities_10 extends MainPage {
    @Test
    public void selectCategory() throws InterruptedException {

        MainPage mainPage=new MainPage();
        driver.get(baseURL);
        Thread.sleep(3000);
        mainPage.selectAllcitiesDropDown();
        Thread.sleep(3000);
        mainPage.setSearchButtonOnMainPageClick();
        Thread.sleep(3000);
        String ExpectedURL = "https://staff.am/en/jobs/categories/index?JobsFilter%5Bkey_word%5D=&JobsFilter%5Bjob_city%5D%5B0%5D=";
        Assert.assertTrue(driver.getCurrentUrl().contains(ExpectedURL));
    }

}
