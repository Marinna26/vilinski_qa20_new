import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BoardCreation extends TestBase
{
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException{
        if (!isUserLoggedIn()) {
            login("marinna2011@ukr.net", "12345Com");
        }
    }
    @Test
    public void createBoardTest() throws InterruptedException {
        int before = getPrivateBoardsCount();
        clickOnPlusButton();
        selectCreateBoardFromDropDown();
        pause(7000);
        fillBoardCreationForm("qa20" + System.currentTimeMillis());
        confirmBoardCreation();
        pause(10000);
        returnToHomePage();
        pause(7000);
        int after = getPrivateBoardsCount();
        Assert.assertEquals(after,before+1);

    }


}
