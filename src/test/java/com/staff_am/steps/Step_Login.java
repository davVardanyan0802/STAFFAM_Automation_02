package com.staff_am.steps;

import com.staff_am.pageObjects.BaseClass;
import com.staff_am.pageObjects.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public  class Step_Login extends BaseClass {

    public  void stepLogin() throws InterruptedException {
        driver.get(baseURL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSignIn();
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("loginform-email")));
        loginPage.setTxtUserName(username);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("loginform-password")));
        loginPage.setTxtPassword(password);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btn_login")));
        loginPage.clickSubmit();
        wait.until(ExpectedConditions.urlToBe("https://staff.am/en/users/resume/profile"));
    }
}
