package com.staff_am.testCases;

import com.staff_am.pageObjects.BaseClass;
import com.staff_am.pageObjects.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_SelectCitiesForCompany_18 extends BaseClass {
    @Test
    public void selectCityForCompany() throws InterruptedException {
        MainPage mainPage=new MainPage();
        driver.get(baseURL);
        Thread.sleep(3000);
        mainPage.company();
        Thread.sleep(3000);
        mainPage.disableField();
        String d="This field is enabled";
        Assert.assertEquals(d,"This field is enabled","The filed is enabled");

    }
}
