package сom.tr.trello.fw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    SessionHelper session;
    BoardHelper board;
    TeamHelper team;
    String browser;

    public ApplicationManager(String browser){
        this.browser = browser;
    }

    public void init() throws InterruptedException {

        if(browser.equals(BrowserType.FIREFOX)){
            wd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.EDGE)) {
            wd = new EdgeDriver();
        } else
            System.out.println("Unknown browser format");



        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        openSite("https://trello.com/");

        session = new SessionHelper(wd);
        session.login("marinna2011@ukr.net", "12345Com");
        board = new BoardHelper(wd);
        team = new TeamHelper(wd);
    }

    public void stop() {
        wd.quit();
    }

    public void openSite(String url) {
        wd.get(url);
    }


    public void clickOnPlusButton() {
        click(By.cssSelector("._2p2TP4mBgXTJP3 "));
    }

    public void returnToHomePage() {
        click(By.cssSelector("[href='/']"));
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public SessionHelper getSession() {
        return session;
    }

    public BoardHelper getBoard() {
        return board;
    }

    public TeamHelper getTeam() {
        return team;
    }

}
