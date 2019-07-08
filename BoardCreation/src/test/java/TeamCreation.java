
import org.testng.annotations.Test;

public class TeamCreation extends TestBase{
    @Test
    public void testTeamCreation(){
        clickOnPlusButton();
        selectCreateTeamFromDropDown();
        fillTeamCreationForm("QA20 Team");
        submitTeamCreation();
    }

}
