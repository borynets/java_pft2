package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.List;

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

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
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

  public void create(ContactData contact) {
    initContactCreation();
    fillContactForm(contact, true);
    submitContactModification();
    contactCache = null;
    returnHomePage();
  }

  public void modify(ContactData contact) {
    initContactModification();
    fillContactForm(contact, false);
    submitContactModification();
    contactCache = null;
    returnHomePage();
  }


  public void delete() {
    selectContact(0);
    deleteContact();
    super.acceptAlert();
    contactCache = null;
  }

  public boolean isThereAContact() {
    return isElementPresent((By.xpath("//*[@id=\"maintable\"]/tbody/tr[2]/td[1]/input")));
  }

  private Contacts contactCache = null;


  public int count() {
    return wd.findElements(By.name("entry")).size();
  }

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for(WebElement element : elements){
      List<WebElement> concatInfo = element.findElements(By.tagName("td"));
      Integer id = Integer.parseInt(concatInfo.get(0).findElement(By.tagName("input")).getAttribute("id"));
      contactCache.add(new ContactData().withId(id).withFirstname(concatInfo.get(2).getText()).withLastname(concatInfo.get(1).getText()));
    }
    return new Contacts(contactCache);
  }
}


