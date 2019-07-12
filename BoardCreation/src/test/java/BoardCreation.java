import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BoardCreation extends TestBase
{
    @Test
    public void createBoardTest(){
        wd.findElement(By.cssSelector("._2p2TP4mBgXTJP3 ")).click();
        wd.findElement(By.className("_2b-xS2onqCL250")).click();

        wd.findElement(By.className("_2S-286TC5jzXKk")).click();
        wd.findElement(By.className("_2S-286TC5jzXKk")).clear();
        wd.findElement(By.className("_2S-286TC5jzXKk")).sendKeys("new");

        wd.findElement(By.cssSelector("[type=button]")).click();

    }
}
