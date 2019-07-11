package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupDeletionTests extends TestBase {

  @Test
  public void GroupDeletion(){
    app.getNavigationHelper().gotoGroupPage();
    if ( ! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("this is test1", null, null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteGroup();
    app.getGroupHelper().returnToGroupPage();
  }
}
