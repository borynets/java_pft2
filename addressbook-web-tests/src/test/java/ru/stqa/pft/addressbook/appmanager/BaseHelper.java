package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class BaseHelper {
  protected WebDriver wd;


  public BaseHelper(WebDriver wd) {
    this.wd = wd;
  }

    public void click(By locator) {
        wd.findElement(locator).click();
  }

  public void type(String locator, String text) {
      wd.findElement(By.name(locator)).clear();
      wd.findElement(By.name(locator)).sendKeys(text);
  }

  public void acceptAlert(){
    wd.switchTo().alert().accept();
  }
}
