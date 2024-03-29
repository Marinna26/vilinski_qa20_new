package сom.tr.trello.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamCreation extends TestBase{

    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if(!app.getSession().isUserLoggedIn()){
            app.getSession().login("marinna2011@ukr.net", "12345Com");
        }
    }

    @Test
    public void testTeamCreation(){
        app.clickOnPlusButton();
        app.getTeam().selectCreateTeamFromDropDown();
        app.getTeam().fillTeamCreationForm("QA20 Team");
        app.getTeam().submitTeamCreation();
    }

}
