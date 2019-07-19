package сom.tr.trello.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import сom.tr.trello.model.User;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if(app.getSession().isUserLoggedIn()){
            app.getSession().logout();
        }

    }

    @Test

    public void positiveLoginTest(){
        app.getSession().initLogin();
        app.getSession().fillLoginForm(new User()
                .withEmail("marinna2011@ukr.net")
                .setPassword("12345Com"));
        app.getSession().confirmLogin();

        Assert.assertTrue(app.getSession().isUserLoggedIn());
    }


}
