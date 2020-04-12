package com.staff_am.testCases;

import com.staff_am.pageObjects.BaseClass;
import com.staff_am.pageObjects.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_SelectKeywordForTranings_15 extends BaseClass {
    @Test
    public void selectKeywordForTraining() throws InterruptedException {
        MainPage mainPage=new MainPage();
        driver.get(baseURL);
        Thread.sleep(3000);
        mainPage.trainin();
        mainPage.writtingSendkeys("qa");
        String ExpUrl = "https://staff.am/en/trainings?search_option=&search_option=trainings&TrainingsFilter%5Bkey_word%5D=";
        Assert.assertTrue(driver.getCurrentUrl().contains(ExpUrl));
    }
}
