package ru.stqa.pft.addressbook;



import org.testng.annotations.*;


public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        gotoGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("this is test1", "this is test2", "this is test3"));
        submitGroupCreation();
        returnToGroupPage();
    }
}
