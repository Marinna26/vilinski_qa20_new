
import org.testng.annotations.Test;

public class BoardCreation extends TestBase {
    @Test
    public void createBoardTest(){
        clickOnPlusButton();
        selectCreateBoardFromDropDown();
        fillBoardCreationForm("qa20");
        submitBoardCreation();
    }

}
