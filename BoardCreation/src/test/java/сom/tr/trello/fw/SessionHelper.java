import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {
    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void login(String email, String pwd) throws InterruptedException {
        initLogin();
        fillLoginForm(email, pwd);
        pause(3000);
        confirmLogin();
        pause(10000);
    }

    public void confirmLogin() {
        click(By.id("login"));
    }

    public void fillLoginForm(String email, String password) {
        type(By.name("user"), email);
        type(By.id("password"),password);
    }

    public void initLogin() {
        click(By.cssSelector(".btn.btn-link"));
    }

    public boolean isUserLoggedIn() {
        return isElementPresent(By.cssSelector(".js-open-header-member-menu"));
    }
    public void pause(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }
}
