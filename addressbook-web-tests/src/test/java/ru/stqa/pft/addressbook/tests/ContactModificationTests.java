package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Nina", "Borynets", "384874848", "test@tect.com", "this is test1"));
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Nina", "Borynets", "384874848", "test@tect.com", null), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnHomePage();
  }

}
