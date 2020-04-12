package com.staff_am.testCases;

import com.staff_am.pageObjects.BaseClass;
import com.staff_am.pageObjects.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_SelectCategoryForTranings_13 extends BaseClass {
    @Test
    public void SelectCategoryForTranings() throws InterruptedException {
        MainPage mainPage=new MainPage();
        driver.get(baseURL);
        Thread.sleep(3000);
        mainPage.trainin();
        mainPage.selectCategoryDropDown();
        String ExpURL = "https://staff.am/en/trainings?search_option=&search_option=trainings&TrainingsFilter%5Bkey_word%5D=&TrainingsFilter%5Bcategory%5D%5B%5D=";
        Assert.assertTrue(driver.getCurrentUrl().contains(ExpURL));
    }

}
