package com.tr.trello.tests;

import com.tr.trello.fw.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setUp() throws InterruptedException {
        app.init();
    }

    @AfterMethod
    public void tearDown()
    {
        app.stop();
    }

}
