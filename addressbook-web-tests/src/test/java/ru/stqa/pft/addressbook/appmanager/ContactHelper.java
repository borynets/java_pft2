package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends BaseHelper {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void returnHomePage() {
    click(By.linkText("home page"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type("firstname", contactData.getFirstname());
    type("lastname", contactData.getLastname());
    type("mobile", contactData.getMobile());
    type("email", contactData.getEmail());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent((By.name("new_group"))));
    }
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void selectContact() {
    click(By.xpath("//*[@id=\"maintable\"]/tbody/tr[2]/td[1]/input"));
  }

  public void submitContactModification() {
    click(By.xpath("//*[@id=\"content\"]/form[1]/input[1]"));
  }

  public void initContactModification() {
    click(By.xpath("//*[@id=\"maintable\"]/tbody/tr[2]/td[8]/a"));
  }

  public void deleteContact() {
    click(By.xpath("//*[@id=\"content\"]/form[2]/div[2]/input"));
  }

  public void createContact(ContactData contact) {
    initContactCreation();
    fillContactForm(contact, true);
    submitContactModification();
    returnHomePage();
  }

  public boolean isThereAContact() {
    return isElementPresent((By.xpath("//*[@id=\"maintable\"]/tbody/tr[2]/td[1]/input")));
  }
}


