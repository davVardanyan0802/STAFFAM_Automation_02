package com.staff_am.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainPage extends BaseClass {
    // WebDriver driver;
//
//    public MainPage(WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//    }

    @FindBy(xpath = "//*[@id=\\\"home_page_search_section\\\"]/div[5]/button/i")
    @CacheLookup
    WebElement searchButtonOnMainPage;


    @FindBy(id = "jobsfilter-category")
    @CacheLookup
    WebElement dropDownAllCategory;

    @FindBy(id = "jobsfilter-job_city")
    @CacheLookup
    WebElement dropDownAllCities;
    @FindBy(id = "jobsfilter-key_word")
    @CacheLookup
    WebElement wkeyword;
    @FindBy(xpath = "//*[@id=\\\"jobsfilter-type\\\"]/label[2]/div/ins")
    @CacheLookup
    WebElement trainingCheckbox;
    @FindBy(xpath = "//*[@id=\\\"jobsfilter-type\\\"]/label[3]/div/ins")
    @CacheLookup
    WebElement companyCheckbox;

    public void setSearchButtonOnMainPageClick() {
        searchButtonOnMainPage.click();
    }

    public void selectCategoryDropDown() {
        Select select = new Select(dropDownAllCategory);
        List<WebElement> k = select.getOptions();
        List<String> strings = new ArrayList<String>();
        for (WebElement e : k) {
            strings.add(e.getText());
        }
        System.out.println(strings);
        String text = strings.get(new Random().nextInt(strings.size()));
        System.out.println(text);
        select.selectByVisibleText(text);
    }

    public void selectAllcitiesDropDown() {
        Select select = new Select(dropDownAllCities);
        List<WebElement> k = select.getOptions();
        List<String> strings = new ArrayList<String>();
        for (WebElement e : k) {
            strings.add(e.getText());
        }
        System.out.println(strings);
        String text = strings.get(new Random().nextInt(strings.size()));
        System.out.println(text);
        select.selectByVisibleText(text);
    }

    public void selectCateroryAndCities() throws InterruptedException {
        selectCategoryDropDown();
        Thread.sleep(3000);
        selectAllcitiesDropDown();
    }

    public void writtingSendkeys(String keyword) {

        wkeyword.sendKeys();

    }


    public void trainin() throws InterruptedException {
        trainingCheckbox.click();
        Thread.sleep(3000);

    }
    public void company() throws InterruptedException {
        companyCheckbox.click();
        Thread.sleep(3000);

    }


    public String disableField() {
        String s;
        if (dropDownAllCities.isDisplayed()) {
            s = "This field is displayed";
        } else {
            s = "This field is enabled";
        }
        System.out.println(s);
        return s;
    }
}