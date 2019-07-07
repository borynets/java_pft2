package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Nina", "Borynets", "384874848", "test@tect.com"));
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnHomePage();
  }

}
