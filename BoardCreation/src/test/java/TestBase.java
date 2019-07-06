import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;

    @BeforeClass
    public void setUp(){
        wd = new ChromeDriver();
        wd.get("https://trello.com/");
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        wd.findElement(By.cssSelector(".btn.btn-link")).click();

        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys("marinna2011@ukr.net");


        wd.findElement(By.id("password")).click();
        wd.findElement(By.id("password")).clear();
        wd.findElement(By.name("password")).sendKeys("12345Com");

        wd.findElement(By.id("login")).click();
    }

    @AfterClass
    public void tearDown(){

        wd.quit();
    }
}
