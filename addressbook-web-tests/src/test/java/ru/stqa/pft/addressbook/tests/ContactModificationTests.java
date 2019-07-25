package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {
  @BeforeMethod

  public void ensurePreconditions(){
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstname("Nina")
              .withLastname("Borynets")
              .withMobile("384874848")
              .withEmail("test@tect.com")
              .withGroup("this is test2"));
    }
  }

  @Test
  public void testGroupModification() {
    Contacts before = app.contact().all();
    ContactData modifiedConcact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedConcact.getId()).withFirstname(modifiedConcact.getFirstname())
            .withLastname(modifiedConcact.getLastname())
            .withMobile(modifiedConcact.getMobile())
            .withEmail(modifiedConcact.getEmail());
    app.contact().modify(contact);

    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.without(modifiedConcact).withAdded(contact)));
  }
}