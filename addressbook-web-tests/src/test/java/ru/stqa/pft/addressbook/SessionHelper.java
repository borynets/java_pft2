package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.appmanager.BaseHelper;

public class SessionHelper extends BaseHelper {


    public SessionHelper(WebDriver wd) {
        super(wd);
    }
    public void login(String user, String password) {
        type("user", user);
        type("pass", password);
        click(By.xpath("//input[@value='Login']"));
    }
}
