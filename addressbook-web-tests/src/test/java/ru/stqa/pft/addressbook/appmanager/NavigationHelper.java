package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class NavigationHelper extends BaseHelper {
  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void gotoGroupPage() {
    boolean isH1ElementPresent = isElementPresent(By.tagName("h1"));
    boolean isElementGroup = wd.findElement(By.tagName("h1")).getText().equals("Groups");
    boolean isElementNewPresent = isElementPresent(By.name("new"));
    if (isH1ElementPresent && isElementGroup && isElementNewPresent) {
      return;

    }
    click(By.linkText("groups"));
  }
}
