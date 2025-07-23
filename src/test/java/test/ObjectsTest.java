package test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.BalanceHolder.*;

import static org.junit.jupiter.api.Assertions.*;

public class ObjectsTest extends TestBase {

    private LoginBhPage loginBhPage;
    private HolderPage holderPage;
    private ObjectsPage objectsPage;
    private ObjectsTheBasisOfChangeWindowPage objectsTheBasisOfChangeWindowPage;
    private AddObjectsPage addObjectsPage;

    @BeforeAll
    public void initPages() {
        loginBhPage = new LoginBhPage(driver);
        holderPage = new HolderPage(driver);
        objectsPage = new ObjectsPage(driver);
        objectsTheBasisOfChangeWindowPage = new ObjectsTheBasisOfChangeWindowPage(driver);
        addObjectsPage = new AddObjectsPage(driver);
    }

    @Test
    @DisplayName("Добавление объекта на вкладке Объекты - Движемое имущество")
    public void addObjectMovableProperty() {
        driver.get("http://localhost:8080/bh/");
        assertTrue(loginBhPage.getTitle().getText().equals("БАРС-Балансодержатель"));
        loginBhPage.isPageLoaded();

        loginBhPage.getPassword().click();
        loginBhPage.getPassword().sendKeys("111");
        loginBhPage.getLoginInput().click();
        loginBhPage.getLoginInput().sendKeys("admin");

        loginBhPage.getAuthButton().click();
        holderPage.isPageLoaded();
        assertTrue(loginBhPage.getBalanceHolder().getText().equals("Правообладатель"));

        holderPage.getObjects().click();
        objectsPage.getMovableProperty().click();

        objectsPage.getAddButton().click();
        assertTrue(addObjectsPage.getNameAddObjects().getText().equals("Добавление объекта"));

        addObjectsPage.getNameField().click();
        addObjectsPage.getNameField().sendKeys("testAuto");

        addObjectsPage.getSaveButton().click();
        assertTrue(objectsTheBasisOfChangeWindowPage.getNameTheBasisOfChangeWindow().getText().equals("Основание изменений"));

        objectsTheBasisOfChangeWindowPage.getCalendarClearButton().click();
        objectsTheBasisOfChangeWindowPage.getFieldDateOfChange().click();
        objectsTheBasisOfChangeWindowPage.getFieldDateOfChange().sendKeys("01.01.2025");

        objectsTheBasisOfChangeWindowPage.getFieldReason().click();
        objectsTheBasisOfChangeWindowPage.getReasonAppObject().click();

        objectsTheBasisOfChangeWindowPage.getDocumentField().click();
        objectsTheBasisOfChangeWindowPage.getDocumentField().sendKeys("-");

        objectsTheBasisOfChangeWindowPage.getSaveButton().click();

    }
    }