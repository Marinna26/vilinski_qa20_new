package com.tr.trello.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamDeletionTests extends TestBase{
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if(!app.getSession().isUserLoggedIn()){
            app.getSession().login("marinna2011@ukr.net", "12345Com");
        }
    }

    @Test
    public void testTeamDeletion(){
        int before = app.getTeam().getTeamsCount();
        app.getTeam().openFirstTeam();
        app.getTeam().openSettingsMenu();
        app.getTeam().clickDeleteTeamButton();
        app.getTeam().confirmAndFinishTeamDeletion();
        app.returnToHomePage();
        int after = app.getTeam().getTeamsCount();

        Assert.assertEquals(after,before-1);
    }


}