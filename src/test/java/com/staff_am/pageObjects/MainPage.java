package com.staff_am.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
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
import java.util.concurrent.TimeUnit;

public class MainPage {
    WebDriver driver;

 public MainPage(WebDriver driver) {
       this.driver = driver;
       PageFactory.initElements(driver, this);
   }

    @FindBy(xpath = "//*[@id=\"home_page_search_section\"]/div[5]/button/i")
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
    @FindBy(xpath = "//*[@id=\"jobsfilter-type\"]/label[2]/div")
    @CacheLookup
    WebElement trainingCheckbox;
    @FindBy(xpath = "//*[@id=\"jobsfilter-type\"]/label[3]/div")
    @CacheLookup
    WebElement companyCheckbox;


    public MainPage clickOnSearch(){
        try {
            System.out.println("Click on search :"+searchButtonOnMainPage);
            searchButtonOnMainPage.click();
        }catch (StaleElementReferenceException e){
            System.out.println("StaleElementReferenceException at clickOnSearch");
        }
        return this;
    }

 //   public void SearchButtonOnMainPageClick() {
   //     searchButtonOnMainPage.click();
    //}

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

    public MainPage writtingSendkeys(String keyword) {

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        try {
            wkeyword.sendKeys(keyword);
            System.out.println("Keywords <<"+keyword+">> are inserted");
        }catch (StaleElementReferenceException e){
            System.out.println("StaleElementReferenceException at insertKeywords");
        }
        return this;
    }

      //  wkeyword.sendKeys();

   // }


    public MainPage trainin()  {
        trainingCheckbox.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;

    }
    public MainPage company()  {
        companyCheckbox.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
return this;
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