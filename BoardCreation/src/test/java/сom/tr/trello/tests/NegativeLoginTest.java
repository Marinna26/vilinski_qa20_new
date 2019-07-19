package сom.tr.trello.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import сom.tr.trello.model.User;

public class NegativeLoginTest extends TestBase{
    @BeforeClass
    public void logout() throws InterruptedException {
        if(app.getSession().isUserLoggedIn()){
            app.getSession().logout();
        }
    }
    @AfterMethod
    public void returnBack(){
        app.getSession().initLogin();
    }
    @Test

    public void negativeLoginTestWithoutPassword(){
        app.getSession().initLogin();
        app.getSession().fillLoginForm(new User()
                .withEmail("hhhhrqr@hh.com"));    //app.getSession().fillLoginForm(new User("", "null"));
        app.getSession().confirmLogin();

        app.getSession().getElementColor();

        Assert.assertTrue(app.getSession().isElementPresent(By.cssSelector("p.error-message")));
        Assert.assertTrue(app.getSession().isElementPresent(By.cssSelector("#user.error")));
    }

    @Test
    public void negativeLoginTestWithoutEmail(){
        app.getSession().initLogin();
        app.getSession().fillLoginForm(new User().setPassword("rrrrrwr"));
        app.getSession().confirmLogin();

        Assert.assertTrue(app.getSession().isElementPresent(By.cssSelector("p.error-message")));
    }
}
