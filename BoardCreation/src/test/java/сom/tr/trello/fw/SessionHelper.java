package сom.tr.trello.fw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import сom.tr.trello.model.User;

public class SessionHelper extends HelperBase {
    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void login(String email, String pwd) throws InterruptedException {
        initLogin();
        fillLoginForm(new User().withEmail(email).setPassword(pwd));
        pause(3000);
        confirmLogin();
        pause(10000);
    }

    public void confirmLogin() {
        click(By.id("login"));
    }

    public void fillLoginForm(User user) {
        type(By.name("user"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }

    public void initLogin() {
        click(By.xpath("//a[@href='/login']"));
    }

    public boolean isUserLoggedIn() {
        return isElementPresent(By.cssSelector(".js-open-header-member-menu"));
    }
    public void pause(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    public void logout() throws InterruptedException {
        click(By.cssSelector("[data-test-id='header-member-menu-button']"));
        click(By.cssSelector("[data-test-id='header-member-menu-logout']"));
        Thread.sleep(5000);


    }
}
