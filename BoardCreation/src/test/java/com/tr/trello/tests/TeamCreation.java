package com.tr.trello.tests;

import org.testng.Assert;
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
        int before = app.getTeam().getTeamsCount();
        app.clickOnPlusButton();
        app.getTeam().selectCreateTeamFromDropDown();
        app.getTeam().fillTeamCreationForm("QA20 Team");
        app.getTeam().submitTeamCreation();
        app.returnToHomePage();
        int after = app.getTeam().getTeamsCount();
        Assert.assertEquals(after,before+1);
    }

}
