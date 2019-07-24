package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Nina", "Borynets", "384874848", "test@tect.com", "this is test1"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    int index = before.size() - 1;
    ContactData contact = new ContactData("Nina", "Borynets", "384874848", "test@tect.com", null);
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(contact, false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size()- 1);
    before.add(contact);
    Comparator<? super ContactData> byFirstName =(c1, c2) -> c1.getFirstname().compareTo(c2.getFirstname());
    before.sort(byFirstName);
    after.sort(byFirstName);
    Assert.assertEquals(before, after);
  }
}