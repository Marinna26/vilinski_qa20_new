import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamDeletionTests extends TestBase {
    @BeforeMethod
    public void preconditions() {
        if (!isUserLoggedIn()) {
            login("marinna2011@ukr.net", "12345Com");
        }
    }

    @Test
    public void testTeamDeletion(){
        int before = getTeamsCount();
        openFirstTeam();
        openSettingsMenu();
        clickDeleteTeamButton();
        confirmAndFinishTeamDeletion();
        returnToHomePage();
        int after = getTeamsCount();

        Assert.assertEquals(after,before-1);
    }

    public int getTeamsCount() {
        return wd.findElements(By.xpath("//div[@class='_1SpVsrdOAb3rKW']/../..//li")).size()-1;
    }

    public void openFirstTeam() {
        click(By.xpath("//div[@class='_1SpVsrdOAb3rKW']/../..//li"));
    }

    public void openSettingsMenu() {
        click(By.xpath("//span[@class='icon-gear icon-sm jlnEovPXgyz1K5']"));
    }

    public void clickDeleteTeamButton() {
        click(By.xpath("//a[@class='quiet-button']"));
    }

    public void confirmAndFinishTeamDeletion() {
        click(By.xpath("//input[@class='js-confirm full negate']"));
    }
}