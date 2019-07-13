import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;

    @BeforeMethod
    public void setUp(){
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        openSite("https://trello.com/");
        login("marinna2011@ukr.net", "12345Com");
    }

    @AfterMethod
    public void tearDown(){
        wd.quit();
    }

    //_________________________________________

    public void openSite(String url) {
        wd.get(url);
    }

    public void login(String email, String pwd) {
        initLogin();
        fillLoginForm(email, pwd);
        confirmLogin();
    }

    public void confirmLogin() {
        click(By.id("login"));
    }

    public void fillLoginForm(String email, String password) {
        type(By.name("user"), email);
        type(By.id("password"),password);
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void initLogin() {
        click(By.cssSelector(".btn.btn-link"));
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public boolean isElementPresent(By by){
        try {
            wd.findElement(by);
            return true;
        }catch (NoSuchElementException e) {
            return false;
        }
    }

    //Board____________________________________

    public void submitBoardCreation() {
        click(By.cssSelector("[type=button]"));
    }

    public void fillBoardCreationForm(String boardName) {
        type(By.className("_2S-286TC5jzXKk"), boardName);
    }

    public void selectCreateBoardFromDropDown() {
        click(By.className("_2b-xS2onqCL250"));
    }

    public void clickOnPlusButton() {
        click(By.cssSelector("._2p2TP4mBgXTJP3 "));
    }

    //Team_______________________________________

    public void selectCreateTeamFromDropDown() {
        click(By.xpath("//*[@role='dialog']//li[2]//button[1]"));
    }

    public void fillTeamCreationForm(String teamName) {
        type(By.xpath("//input[@data-test-id='header-create-team-name-input']"), teamName);
    }

    public void submitTeamCreation() {
        click(By.cssSelector("[type=submit]"));
    }
}
