package com.staff_am.steps;

import com.staff_am.pageObjects.MainPage;
import org.openqa.selenium.WebDriver;

public class Step_MainPage {
    MainPage page;
    public Step_MainPage(WebDriver driver){
        page=new MainPage(driver);
    }
    public void selectCategoryDropDown() throws InterruptedException {
        page.selectCategoryDropDown();
        Thread.sleep(3000);

        page.clickOnSearch();
    }
}
