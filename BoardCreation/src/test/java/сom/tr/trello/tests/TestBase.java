package сom.tr.trello.tests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import sun.plugin2.util.BrowserType;
import сom.tr.trello.fw.ApplicationManager;

public class TestBase {

    static ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

    @BeforeSuite
    public void setUp() throws InterruptedException {
        app.init();
    }

    @AfterSuite
    public void tearDown()
    {
        app.stop();
    }

}
