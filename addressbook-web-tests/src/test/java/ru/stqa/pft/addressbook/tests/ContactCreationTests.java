package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;


public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreationTests() throws Exception {
    app.initContactCreation();
    app.fillContactForm(new ContactData("Nina", "Borynets", "384874848", "test@tect.com"));
    app.returnHomePage();
  }

}
