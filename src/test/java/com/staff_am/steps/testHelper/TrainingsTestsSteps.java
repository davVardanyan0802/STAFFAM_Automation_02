package com.staff_am.steps.testHelper;

import com.staff_am.pageObjects.TrainingsPage;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class TrainingsTestsSteps {
    TrainingsPage page;

    public TrainingsTestsSteps(WebDriver driver){
        page=new TrainingsPage(driver);
    }

    public void verifySearch(String keywords, int index) throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        page.clickOnInput();
        page.insertKeywords(keywords);
        page.clickOnSearch();
        page.clickOnCourseList(index);
        softAssert.assertTrue(page.getCategory().contains(keywords));
    }

    public void verifyPriceFilter(int index,String price) throws InterruptedException{
        SoftAssert s=new SoftAssert();
        page.setPriceFilter(price);
        Thread.sleep(3000);
        page.clickOnCourseList(index);
        Thread.sleep(3000);
        if(price.contains("Free")) {
            s.assertTrue(page.getPriceValue().contains(price));
        }else if(price.contains("Paid")) {
            s.assertFalse(page.getPriceValue().contains(price));
        }else {
            System.out.println("You must insert <<Free>> or <<Paid>>");
            return;
        }

    }

    public void verifyCategoryFilter(int index) throws InterruptedException{
        SoftAssert soft=new SoftAssert();
        String s=page.getFilterText("Category",index);
        page.setCategoryFilter(index);
        Thread.sleep(3000);
        page.clickOnCourseList(0);
        soft.assertTrue(s.contains(page.getCategory()));
    }

    public void verifyMultipleFilter(int index) throws InterruptedException{
        SoftAssert s=new SoftAssert();
        page.dropDownSort("Sort by deadline");
        String a=page.getFilterText("Category",index);
        page.setCategoryFilter(index);
        if(a.contains("(0)")){
            System.out.println("No course by such <<Category>>");
        }
        Thread.sleep(1500);
        String b=page.getFilterText("Type",1);
        page.setTypeFilter("e-learning");
        if(b.contains("(0)")){
            System.out.println("No course by such <<Type>>");
        }
        Thread.sleep(1500);
        String c=page.getFilterText("Language",0);
        page.setLanguageFilter("English");
        if(c.contains("(0)")){
            System.out.println("No course by such <<Language>>");
        }
        Thread.sleep(1500);
        String d=page.getFilterText("City",1);
        page.setCityFilter("Online");
        if(d.contains("(0)")){
            System.out.println("No course by such <<City>>");
        }
        Thread.sleep(1500);
        page.clickOnCourseList(index);
        if(d.contains("(0)")){
            System.out.println("There are no courses with such filters");
            return;
        }else {
            s.assertTrue(a.contains(page.getCategory()));
            s.assertTrue(b.contains(page.getType()));
            s.assertTrue(c.contains(page.getLanguage()));
            s.assertTrue(d.contains(page.getLocation()));
            s.assertAll();
        }
    }

    public void verifyLanguageFilter() throws InterruptedException{
        SoftAssert s=new SoftAssert();
        String a=page.getFilterText("Language",2);
        page.setLanguageFilter("German");
        Thread.sleep(2000);
        page.clickOnCourseList(0);
        if(a.contains("(0)")){
            System.out.println("No training by such language");
        }else {
            s.assertTrue(a.contains(page.getLanguage()));
        }
    }
}
