import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreation extends TestBase {
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if(!app.getSession().isUserLoggedIn()){
            app.getSession().login("marinna2011@ukr.net", "12345Com");
        }
    }

    @Test
    public void createBoardTest() throws InterruptedException {
        int before = app.getBoard().getPrivateBoardsCount();
        app.clickOnPlusButton();
        app.getBoard().selectCreateBoardFromDropDown();
        app.getSession().pause(7000);
        app.getBoard().fillBoardCreationForm("qa20");
        app.getBoard().confirmBoardCreation();
        app.getSession().pause(10000);
        app.returnToHomePage();
        app.getSession().pause(7000);
        int after = app.getBoard().getPrivateBoardsCount();
        Assert.assertEquals(after,before+1);

    }
    @Test
    public void testBoardCreationLongName(){
        app.clickOnPlusButton();
        app.getBoard().selectCreateBoardFromDropDown();
        app.getBoard().fillBoardCreationForm("qa20 with veryyyy Long Nameeeeee");
        app.getBoard().confirmBoardCreation();
    }


}
