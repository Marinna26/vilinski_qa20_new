package com.tr.trello.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.NoSuchElementException;

public class HelperBase {

    WebDriver wd;

    public HelperBase(WebDriver wd ) {
        this.wd = wd;
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public boolean isElementPresent(By by){
        try {
            wd.findElement(by);
            return true;
        }catch (NoSuchElementException e) {
            return false;
        }
    }


}
