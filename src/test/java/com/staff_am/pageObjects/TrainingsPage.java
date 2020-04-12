package com.staff_am.pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TrainingsPage {
    WebDriver driver;

    public TrainingsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css="[name='TrainingsFilter[key_word]']")
    @CacheLookup
    WebElement searchInput;
    @FindBy (id="btn_search_keyword")
    @CacheLookup
    WebElement searchButton;
    @FindBy (xpath = "//span[text()='Type:']//parent::p")
    @CacheLookup
    WebElement courseType;
    @FindBy (xpath = "//span[text()='Category:']//parent::p")
    @CacheLookup
    WebElement courseCategory;
    @FindBy (xpath = "//span[text()='Language:']//parent::p")
    @CacheLookup
    WebElement courseLanguage;
    @FindBy (xpath = "//span[text()='Location:']//parent::p")
    @CacheLookup
    WebElement courseLocation;
    @FindBy (css = ".price")
    @CacheLookup
    WebElement priceValue;
    @FindBy (css = ".col-lg-5.text-right.font-16 h6")
    @CacheLookup
    WebElement dateValue;
    String selectById="select_sort";
    String filterByPriceCss="#trainingsfilter-training_price label";
    String filterByCategoryCss="#trainingsfilter-category label";
    String filterByTypeCss="#trainingsfilter-training_type label";
    String filterByLanguageCss="#trainingsfilter-language label";
    String filterByCitiesCss="#trainingsfilter-job_city label";
    String companiesListCss=".job-list-item.training-list-item.clearfix.radius_changes";

    public TrainingsPage clickOnInput()  {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        try {
            System.out.println("Click on input :"+searchInput);
            searchInput.click();
        }catch (StaleElementReferenceException e){
            System.out.println("StaleElementReferenceException at clickOnInput");
        }
        return this;
    }

    public TrainingsPage clickOnSearch(){
        try {
            System.out.println("Click on search :"+searchButton);
            searchButton.click();
        }catch (StaleElementReferenceException e){
            System.out.println("StaleElementReferenceException at clickOnSearch");
        }
        return this;
    }

    public TrainingsPage insertKeywords(String keywords){
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        try {
            searchInput.sendKeys(keywords);
            System.out.println("Keywords <<"+keywords+">> are inserted");
        }catch (StaleElementReferenceException e){
            System.out.println("StaleElementReferenceException at insertKeywords");
        }
        return this;
    }

    public TrainingsPage clickOnCourseList(int index){
        try {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            List<WebElement> list=driver.findElements(By.cssSelector(companiesListCss));
            JavascriptExecutor jse=(JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView();",list.get(index));
            list.get(index).click();
            System.out.println("Click on "+index+" course in course list");
        }catch (IndexOutOfBoundsException e){
            System.out.println("There is no course or company by such index");
        }catch (StaleElementReferenceException e){
            System.out.println("StaleElementReferenceException at clickOnCourseList");
        }catch (NoSuchElementException e){
            System.out.println("There is no such course type in list at this moment");
        }catch (ElementClickInterceptedException e){
            System.out.println("ElementClickInterceptedException at clickOnCourseList");
        }
        return this;
    }

    public TrainingsPage setCategoryFilter(int index){
        try {
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            List<WebElement> list = driver.findElements(By.cssSelector(filterByCategoryCss));
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView();", list.get(index));
            list.get(index).click();
            System.out.println("Click on <<" + list.get(index).getText() + ">> filter in category filter list");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("There is no category filter type by such index");
        } catch (StaleElementReferenceException e) {
            System.out.println("StaleElementReferenceException at setCategoryFilter");
        }
        return this;
    }

    public TrainingsPage setPriceFilter(String s){
        if(s.contains("Paid")){
            filterSetUp(filterByPriceCss,0,"setPriceFilter");
        }else if(s.contains("Free")){
            filterSetUp(filterByPriceCss,1,"setPriceFilter");
        }else {
            System.out.println("Unidentified input at setPriceFilter");
        }
        return this;
    }

    public TrainingsPage setTypeFilter(String s){
        if(s.contains("Training")){
            filterSetUp(filterByTypeCss,0,"setTypeFilter");
        }else if(s.contains("e-learning")){
            filterSetUp(filterByTypeCss,1,"setTypeFilter");
        }else{
            System.out.println("Unidentified input at setTypeFilter");
        }
        return this;
    }

    public TrainingsPage setLanguageFilter(String s){
        if(s.contains("English")){
            filterSetUp(filterByLanguageCss,0,"setLanguageFilter");
        }else if(s.contains("Armenian")){
            filterSetUp(filterByLanguageCss,1,"setLanguageFilter");
        }else if(s.contains("German")){
            filterSetUp(filterByLanguageCss,2,"setLanguageFilter");
        }else{
            System.out.println("Unidentified input ar setLanguageFilter");
        }
        return this;
    }

    public TrainingsPage setCityFilter(String s){
        if(s.contains("Yerevan")){
            filterSetUp(filterByCitiesCss,0,"setCityFilter");
        }else if(s.contains("Online")){
            filterSetUp(filterByCitiesCss,1,"setCityFilter");
        }else{
            System.out.println("Unidentified input at setCityFilter");
        }
        return this;
    }

    public TrainingsPage dropDownSort(String sortByType){
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Select sortBy=new Select(driver.findElement(By.id(selectById)));
        try {
            sortBy.selectByVisibleText(sortByType);
            System.out.println(sortByType+" is selected");
        }catch (NoSuchElementException e){
            System.out.println("Incorrect input");
        }catch (StaleElementReferenceException e){
            System.out.println("StaleElementReferenceException at dropDownSort");
        }
        return this;
    }

    public String getCategory(){
        String sub="";
        String st;
        try {
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            System.out.println(courseCategory.getText());
            st=courseCategory.getText();
            sub=st.substring(10);
        } catch (StaleElementReferenceException e) {
            System.out.println("StaleElementReferenceException at getCategory");
        }catch (NoSuchElementException e){
            System.out.println("NoSuchElementException at getCategory");
        }
        return sub;
    }

    public String getType(){
        String sub="";
        String st;
        try {
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            System.out.println(courseType.getText());
            st=courseType.getText();
            sub=st.substring(6);
        }catch (StaleElementReferenceException e){
            System.out.println("StaleElementReferenceException at getType");
        }
        return sub;
    }

    public String getLanguage(){
        String sub="";
        String st;
        try {
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            System.out.println(courseLanguage.getText());
            st=courseLanguage.getText();
            sub=st.substring(11);
        }catch (StaleElementReferenceException e){
            System.out.println("StaleElementReferenceException at getLanguage");
        }
        return sub;
    }

    public String getLocation(){
        String sub="";
        String st;
        try {
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            System.out.println(courseLocation.getText());
            st=courseLocation.getText();
            sub=st.substring(11);
        }catch (StaleElementReferenceException e){
            System.out.println("StaleElementReferenceException at getLocation");
        }
        return sub;
    }

    public String getPriceValue(){
        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        System.out.println(priceValue.getText());
        return priceValue.getText();
    }

    public String getDateValue(){
        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        System.out.println(dateValue.getText());
        return dateValue.getText();
    }

    private TrainingsPage filterSetUp(String css,int index,String methodName){
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        List<WebElement> list=driver.findElements(By.cssSelector(css));
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

    public String getFilterText(String s,int index){
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        String st="";
        if(s.contains("Category")) {
            List<WebElement> list = driver.findElements(By.cssSelector(filterByCategoryCss));
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView();", list.get(index));
            System.out.println(list.get(index).getText());
            st= list.get(index).getText();
        }else if(s.contains("Type")){
            List<WebElement> list = driver.findElements(By.cssSelector(filterByTypeCss));
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView();", list.get(index));
            System.out.println(list.get(index).getText());
            st=list.get(index).getText();
        }else if(s.contains("Language")){
            List<WebElement> list = driver.findElements(By.cssSelector(filterByLanguageCss));
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView();", list.get(index));
            System.out.println(list.get(index).getText());
            st=list.get(index).getText();
        }else if(s.contains("City")){
            List<WebElement> list = driver.findElements(By.cssSelector(filterByCitiesCss));
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView();", list.get(index));
            System.out.println(list.get(index).getText());
            st=list.get(index).getText();
        }else{
            System.out.println("Unidentified input at getFilterText");
        }
        return st;
    }
}
