package test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import pages.BalanceHolder.AddObjectsPage;
import pages.BalanceHolder.HolderPage;
import pages.BalanceHolder.LoginBhPage;
import pages.BalanceHolder.ObjectsPage;
import pages.BalanceHolder.ObjectsTheBasisOfChangeWindowPage;

import static org.junit.jupiter.api.Assertions.*;

public class ObjectsTest extends TestBase {

    private HolderPage holderPage;
    private ObjectsPage objectsPage;
    private ObjectsTheBasisOfChangeWindowPage objectsTheBasisOfChangeWindowPage;
    private AddObjectsPage addObjectsPage;
    private WebDriverWait wait;

    @BeforeAll
    public void initPages() {
        holderPage = new HolderPage(driver);
        objectsPage = new ObjectsPage(driver);
        objectsTheBasisOfChangeWindowPage = new ObjectsTheBasisOfChangeWindowPage(driver);
        addObjectsPage = new AddObjectsPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @Test
    @DisplayName("Добавление объекта на вкладке Объекты - Движемое имущество")
    public void addObjectMovableProperty() {
        registration("admin", "111");

        holderPage.getObjects().click();
        objectsPage.getAddButton().click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});",
                addObjectsPage.getNameField());

        addObjectsPage.getNameField().click();
        addObjectsPage.getNameField().sendKeys("testAuto");

        addObjectsPage.getSaveButton().click();

        assertTrue(objectsTheBasisOfChangeWindowPage.getFieldReason().isDisplayed());
        objectsTheBasisOfChangeWindowPage.getFieldReason().click();
        objectsTheBasisOfChangeWindowPage.getReasonAppObject().click();

        objectsTheBasisOfChangeWindowPage.getSaveButton().click();


    }
}
