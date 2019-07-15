package сom.tr.trello.tests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase {
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if(!app.getSession().isUserLoggedIn()){
            app.getSession().login("marinna2011@ukr.net", "12345Com");
        }
    }

    @Test
    public void testPrivateBoardDeletion() throws InterruptedException {

        int before = app.getBoard().getPrivateBoardsCount();
        app.getBoard().openFirstPrivateBoard();
        app.getBoard().initBoardDeletion();
        app.getBoard().confirmBoardDeletion();
        app.getBoard().confirmFinishBoardDeletion();
        app.getSession().pause(10000);
        app.returnToHomePage();
        app.getSession().pause(7000);
        int after = app.getBoard().getPrivateBoardsCount();

        Assert.assertEquals(after,before-1);
    }


}