package ru.stqa.pft.addressbook.tests;



import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;



public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.goTo().groupPage();
        Groups before = (Groups) app.group().all();
        GroupData group = new GroupData().withName("this is test2");
        app.group().create(group);
        assertThat(app.group().count(), equalTo(before.size() + 1));
        Groups after = (Groups) app.group().all();
        assertThat(after.size(), equalTo(before.size() + 1));



        assertThat(after, equalTo(before.
                withAdded(group.withId(after.stream().mapToInt((g)-> g.getId()).max().getAsInt()))));
    }



    @Test
    public void testBadGroupCreation() throws Exception {
        app.goTo().groupPage();
        Groups before = (Groups) app.group().all();
        GroupData group = new GroupData().withName("this is test2 ' ");
        app.group().create(group);
        assertThat(app.group().count(), equalTo(before.size()));
        Groups after = (Groups) app.group().all();
        assertThat(after, equalTo(before));
    }
}