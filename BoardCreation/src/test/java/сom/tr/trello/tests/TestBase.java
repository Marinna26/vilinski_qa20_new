package сom.tr.trello.tests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import сom.tr.trello.fw.ApplicationManager;

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
