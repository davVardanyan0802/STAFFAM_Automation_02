package com.staff_am.testCases;

import com.staff_am.pageObjects.BaseClass;
import com.staff_am.pageObjects.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_SelectByKeyword_12 extends BaseClass {
    @Test
    public void SelectByKeyword() throws InterruptedException {
        MainPage mainPage=new MainPage();
        driver.get(baseURL);
        Thread.sleep(3000);
        mainPage.writtingSendkeys("qa");
        Thread.sleep(3000);
        mainPage.setSearchButtonOnMainPageClick();
        String ExpUrl = "https://staff.am/en/jobs/categories/index?JobsFilter%5Bkey_word%5D=";
        Assert.assertTrue(driver.getCurrentUrl().contains(ExpUrl));

    }
}
