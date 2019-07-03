package ru.stqa.pft.addressbook.tests;



import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;


public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("this is test1", "this is test2", "this is test3"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();
    }
}
