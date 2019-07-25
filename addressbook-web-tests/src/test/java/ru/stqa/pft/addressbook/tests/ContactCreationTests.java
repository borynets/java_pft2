package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactCreationTests extends TestBase {


    @Test
    public void testContactCreationTests() throws Exception {

        Contacts before = app.contact().all();
        ContactData contact = new ContactData().withFirstname("Nina")
                .withLastname("Borynets")
                .withMobile("384874848")
                .withEmail("test@tect.com")
                .withGroup("this is test2");
        app.contact().create(contact);
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() + 1));
    }

}
