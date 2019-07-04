package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends BaseHelper {

  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void returnHomePage() {
    click(By.linkText("home page"));
  }

  public void fillContactForm(ContactData contactData) {
    type("firstname", contactData.getFirstname());
    type("lastname", contactData.getLastname());
    type("mobile", contactData.getMobile());
    type("email", contactData.getEmail());
    click(By.xpath("//*[@id=\"content\"]/form/input[21]"));
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }
}
