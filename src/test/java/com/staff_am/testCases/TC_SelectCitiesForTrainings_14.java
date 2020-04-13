package com.staff_am.testCases;

import com.staff_am.pageObjects.BaseClass;
import com.staff_am.pageObjects.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.prefs.BackingStoreException;

public class TC_SelectCitiesForTrainings_14 extends BaseClass {
    @Test
    public void SelectCiiesForTrainings() throws InterruptedException {
        MainPage mainPage=new MainPage(driver);
        driver.get(baseURL);
        Thread.sleep(3000);
        mainPage.trainin();
        mainPage.selectAllcitiesDropDown();
        Thread.sleep(3000);
        mainPage.clickOnSearch();
        Thread.sleep(3000);
        String ExpUrl = "https://staff.am/en/trainings?search_option=&search_option=trainings&TrainingsFilter%5Bkey_word%5D=&TrainingsFilter%5Bjob_city%5D%5B%5D=";
        Assert.assertTrue(driver.getCurrentUrl().contains(ExpUrl));
    }

}
