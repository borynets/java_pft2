package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseHelper {
  protected FirefoxDriver wd;


  public BaseHelper(FirefoxDriver wd) {
    this.wd = wd;
  }

  public void click(By locator) {
      wd.findElement(locator).click();
  }

  public void type(String locator, String text) {
      click(By.name(locator));
      wd.findElement(By.name(locator)).clear();
      wd.findElement(By.name(locator)).sendKeys(text);
  }
}
