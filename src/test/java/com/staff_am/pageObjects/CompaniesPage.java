package com.staff_am.pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CompaniesPage {
    WebDriver driver;

    public CompaniesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//span[text()='Industry:']//parent::td//parent::tr")
    @CacheLookup
    WebElement companyIndustry;//After click on some company from list
    @FindBy (xpath = "//span[text()='Number of Employees:']//parent::p")
    @CacheLookup
    WebElement employeeNumber;//After click on some company from list
    @FindBy (css = "[id$='views&isGoverment=0']")
    @CacheLookup
    WebElement viewNumberElement;
    @FindBy(css = "[id$='followers&isGoverment=0']")
    @CacheLookup
    WebElement followersNumberElement;
    @FindBy(className = "select2-selection__arrow")
    @CacheLookup
    WebElement dropDownArrow;
    String companiesListCss=".load-more.btn.width100.radius_changes";//Before click on some company from list
    String filterByIndustryCss="#companiesstruct-industry label";//Before click on some company from list
    String filterByNumberOfEmployeesCss="#companiesstruct-employees_number label";//Before click on some company from list
    String totalViewXpath="//p[contains(text(), 'Total views')]";//Before click on some company from list
    String followersCountCss=".followers_count";//Before click on some company from list

    public CompaniesPage clickOnCompaniesList(int index){
        try {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            List<WebElement> list=driver.findElements(By.cssSelector(companiesListCss));
            JavascriptExecutor jse=(JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView();",list.get(index));
            list.get(index).click();
            System.out.println("Click on "+index+" company in company list");
        }catch (IndexOutOfBoundsException e){
            System.out.println("There is no course or company by such index");
        }catch (StaleElementReferenceException e){
            System.out.println("StaleElementReferenceException at clickOnCompaniesList");
        }catch (NoSuchElementException e){
            System.out.println("There is no such company type in list at this moment");
        }catch (ElementClickInterceptedException e){
            System.out.println("ElementClickInterceptedException at clickOnCompaniesList");
        }
        return this;
    }

    private CompaniesPage filterSetUp(int index){
        String methodName="setEmployeeNumberFilter";
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        List<WebElement> list=driver.findElements(By.cssSelector(filterByNumberOfEmployeesCss));
        JavascriptExecutor jse=(JavascriptExecutor) driver;
        try {
            jse.executeScript("arguments[0].scrollIntoView();",list.get(index));
            list.get(index).click();
            System.out.println("Click on <<"+list.get(index).getText()+">> at "+methodName);
        }catch (IndexOutOfBoundsException e){
            System.out.println("There is no such filter type by such index at "+methodName);
        }catch (StaleElementReferenceException e){
            System.out.println("StaleElementReferenceException at "+methodName);
        }
        return this;
    }

    public CompaniesPage setIndustryFilter(int index){
        try {
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            List<WebElement> list = driver.findElements(By.cssSelector(filterByIndustryCss));
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView();", list.get(index));
            list.get(index).click();
            System.out.println("Click on <<" + list.get(index).getText() + ">> filter in Industry filter list");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("There is no Industry filter type by such index");
        } catch (StaleElementReferenceException e) {
            System.out.println("StaleElementReferenceException at setIndustryFilter");
        }
        return this;
    }

    public CompaniesPage setEmployeeNumberFilter(String s){
        if(s.contains("up to 50")){
            filterSetUp(0);
        }else if(s.contains("50-200")){
            filterSetUp(1);
        }else if (s.contains("200-500")){
            filterSetUp(2);
        }else if (s.contains("500-1500")){
            filterSetUp(3);
        }else if(s.contains("more than 1500")){
            filterSetUp(4);
        }else {
            System.out.println("Unidentified filter type at <<setEmployeeNumber>>");
        }
        return this;
    }

    public String getIndustry(){
        String sub="";
        String st;
        try {
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            JavascriptExecutor jse=(JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView();",companyIndustry);
            System.out.println(companyIndustry.getText());
            st=companyIndustry.getText();
            sub=st.substring(10);
        } catch (StaleElementReferenceException e) {
            System.out.println("StaleElementReferenceException at getIndustry");
        }catch (NoSuchElementException e){
            System.out.println("NoSuchElementException at getIndustry");
        }
        return sub;
    }

    public String getEmployeeNumber(){
        String sub="";
        String st;
        try {
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            JavascriptExecutor jse=(JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView();",employeeNumber);
            System.out.println(employeeNumber.getText());
            st=employeeNumber.getText();
            sub=st.substring(21);
        } catch (StaleElementReferenceException e) {
            System.out.println("StaleElementReferenceException at getEmployeeNumber");
        }catch (NoSuchElementException e){
            System.out.println("NoSuchElementException at getEmployeeNumber");
        }
        return sub;
    }

    public String getFilterText(String s,int index) {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        String st = "";
        if (s.contains("Industry")) {
            List<WebElement> list = driver.findElements(By.cssSelector(filterByIndustryCss));
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView();", list.get(index));
            System.out.println(list.get(index).getText());
            st = list.get(index).getText();
        } else if (s.contains("Employee")) {
            List<WebElement> list = driver.findElements(By.cssSelector(filterByNumberOfEmployeesCss));
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView();", list.get(index));
            System.out.println(list.get(index).getText());
            st = list.get(index).getText();
        }else{
            System.out.println("Unidentified input at <<getFilterText>>");
        }
        return  st;
    }

    public int getFollowersCount(int index){
        List<WebElement> list=driver.findElements(By.cssSelector(followersCountCss));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", list.get(index));
        int i = Integer.parseInt(list.get(index).getText());
        System.out.println("Followers count of "+index+" company is :"+i);
        return i;
    }

    public int getTotalViewsCount(int index){
        List<WebElement> list=driver.findElements(By.xpath(totalViewXpath));
        JavascriptExecutor jse=(JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();",list.get(index));
        System.out.println("Total views of "+index+" company is :"+getInt(list.get(index).getText()));
        return getInt(list.get(index).getText());
    }

    public CompaniesPage dropDownSort(String s){
        dropDownArrow.click();
        System.out.println("Click on dropdown arrow");
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        if(s.contains("followers")){
            followersNumberElement.click();
            System.out.println("Click on <<Sort by followers>>");
            return this;
        }else if(s.contains("views")){
            viewNumberElement.click();
            System.out.println("Click on <<Sort by number of viewers>>");
            return this;
        }
        return this;
    }

    private int getInt(String s){
        int end=0;
        if(s.length()==19){
            end=7;
        }else if(s.length()==18){
            end=6;
        }else if(s.length()==17){
            end=5;
        }else if(s.length()==16){
            end=4;
        }else if(s.length()==15){
            end=3;
        }
        String st=s.substring(0,end);
        int i=Integer.parseInt(st);
        return i;
    }

}



