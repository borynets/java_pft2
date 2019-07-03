package ru.stqa.pft.addressbook;


import org.testng.annotations.*;


public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreationTests() throws Exception {
    initContactCreation();
    fillContactForm(new ContactData("Nina", "Borynets", "384874848", "test@tect.com"));
    returnHomePage();
  }

}
