package test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import pages.BalanceHolder.ContragentTheBasisOfChangeWindowsPage;
import pages.BalanceHolder.HolderPage;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class HolderTest extends TestBase {

    private HolderPage holderPage;
    private ContragentTheBasisOfChangeWindowsPage contragentTheBasisOfChangeWindowsPage;
    private WebDriverWait wait;

    @BeforeAll
    public void initPages() {
        holderPage = new HolderPage(driver);
        contragentTheBasisOfChangeWindowsPage = new ContragentTheBasisOfChangeWindowsPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    @DisplayName("Редактирование балансодержателя")
    public void addHolder() {
        registration("antropova", "1mQYVeeeeQ");

        holderPage.getEditButton().click();


        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

        WebElement fieldToClick = wait.until(ExpectedConditions.elementToBeClickable(holderPage.getFieldName()));
        fieldToClick.click();
        holderPage.getFieldName().clear();
        holderPage.getFieldName().sendKeys("Антропова");

        holderPage.getSaveButton().click();

        waitUtils.waitForElementVisible(contragentTheBasisOfChangeWindowsPage.getFieldReasonForChanges());
        contragentTheBasisOfChangeWindowsPage.getFieldReasonForChanges().click();

        assertEquals(6, contragentTheBasisOfChangeWindowsPage.getListReasonChange().size());

        step("Что то здесь делаю", () -> contragentTheBasisOfChangeWindowsPage.getListReasonChange().get(0).click());
        contragentTheBasisOfChangeWindowsPage.getListReasonChange().get(0).click();

        wait.withTimeout(Duration.ofSeconds(10));

        waitUtils.waitForElementVisible(contragentTheBasisOfChangeWindowsPage.getFieldDocument());
        contragentTheBasisOfChangeWindowsPage.getFieldDocument().sendKeys("-");
        contragentTheBasisOfChangeWindowsPage.getSaveButton().click();
    }
}