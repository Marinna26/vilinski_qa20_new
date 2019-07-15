package сom.tr.trello.fw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TeamHelper extends HelperBase {

    public TeamHelper(WebDriver wd) {
        super(wd);
    }

    public void selectCreateTeamFromDropDown() {
        click(By.xpath("//*[@role='dialog']//li[2]//button[1]"));
    }

    public void fillTeamCreationForm(String teamName) {
        type(By.xpath("//input[@data-test-id='header-create-team-name-input']"), teamName);
    }

    public void submitTeamCreation() {
        click(By.cssSelector("[type=submit]"));
    }

    public int getTeamsCount() {
        return wd.findElements(By.xpath("//div[@class='_1SpVsrdOAb3rKW']/../..//li")).size()-1;
    }

    public void openFirstTeam() {

        click(By.xpath("//div[@class='_1SpVsrdOAb3rKW']/../..//li"));
    }

    public void openSettingsMenu()
    {
        click(By.xpath("//span[@class='icon-gear icon-sm jlnEovPXgyz1K5']"));
    }

    public void clickDeleteTeamButton() {
        click(By.xpath("//a[@class='quiet-button']"));
    }

    public void confirmAndFinishTeamDeletion() {
        click(By.xpath("//input[@class='js-confirm full negate']"));
    }

}
