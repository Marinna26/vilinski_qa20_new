import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase {
    @BeforeMethod
    public void preconditions() {
        if (!isUserLoggedIn()) {
            login("marinna2011@ukr.net", "12345Com");
        }
    }

    @Test
    public void testPrivateBoardDeletion(){
        openFirstPrivateBoard();
        initBoardDeletion();
        //

        confirmBoardDeletion();//.js-delete
        confirmFinishBoardDeletion();//.js-confirm.full
        returnToHomePage();//[href='/']
    }

    public void initBoardDeletion() {
        openMenu();
        clickMoreButtonInTheMenu();
        clickCloseBoardButton();
        confirmCloseButton();
    }

    public void confirmCloseButton() {
        click(By.cssSelector(".js-confirm.full.negate"));
    }

    public void clickCloseBoardButton() {
        click(By.cssSelector(".board-menu-navigation-item-link.js-close-board"));
    }

    public void clickMoreButtonInTheMenu() {
        click(By.cssSelector(".board-menu-navigation-item-link.js-open-more"));
    }

    public void openMenu() {
        if(!isBoardMenuOpened()){
            click(By.cssSelector(".board-header-btn-text.u-text-underline"));
        }
    }

    public boolean isBoardMenuOpened() {
        return isElementPresent(By.cssSelector(".board-header-btn-text.u-text-underline"));
    }


    public void openFirstPrivateBoard() {
        WebElement privateBoardsList = wd.findElement(By.xpath("//span[@class='icon-lg icon-member']/../../..//ul"));
        String boardNameForDelete = privateBoardsList.findElement(By.xpath(".//li")).getText();
        System.out.println(boardNameForDelete);
        privateBoardsList.findElement(By.xpath(".//li")).click();
    }

    public void confirmBoardDeletion() {
        click(By.cssSelector(".js-delete"));
    }

    public void confirmFinishBoardDeletion() {
        click(By.cssSelector(".js-confirm.full"));
    }

    public void returnToHomePage() {
        click(By.cssSelector("[href='/']"));
    }

    public boolean isUserLoggedIn() {
        return isElementPresent(By.cssSelector(".js-open-header-member-menu"));
    }
}