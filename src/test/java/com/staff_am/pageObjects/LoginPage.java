package com.staff_am.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "sign-in-btn")
    @CacheLookup
    WebElement signIn;

    @FindBy(id = "loginform-email")
    @CacheLookup
    WebElement txtUserName;

    @FindBy(id = "loginform-password")
    @CacheLookup
    WebElement txtPassword;

    @FindBy(id = "btn_login")
    @CacheLookup
    WebElement btnLogin;


//    @FindBy(xpath = "//a[@href='/en/users/registration/logout']")
//    @CacheLookup
//    WebElement logOut;


    public void clickSignIn() {
        signIn.click();
    }

    public void setTxtUserName(String uName) {
        txtUserName.sendKeys(uName);
    }

    public void setTxtPassword(String pwd) {
        txtPassword.sendKeys(pwd);
    }

    public void clickSubmit() {
        btnLogin.click();
    }


}
