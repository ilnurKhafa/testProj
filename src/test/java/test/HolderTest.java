package test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import pages.BalanceHolder.HolderPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HolderTest extends TestBase {

    private HolderPage holderPage;
    private WebDriverWait wait;

    @BeforeAll
    public void initPages() {
        holderPage = new HolderPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    @Order(1)
    @DisplayName("Редактирование балансодержателя")
    public void addHolder() {
        registration("admin", "111");

        holderPage.getEditButton().click();

        WebElement fieldToClick = wait.until(ExpectedConditions.elementToBeClickable(holderPage.getFieldName()));
        fieldToClick.click();
        holderPage.getFieldName().clear();
        holderPage.getFieldName().sendKeys("1234567789080");

        holderPage.getSaveButton().click();
        assertEquals("1234567789080", holderPage.getRContragentName().getAttribute("value"));

    }
//не_работает
    @Test
    @Order(2)
    @DisplayName("Внесение изменений окончено")
    public void makingChange() {
        registration("admin", "111");

        holderPage.getButtonCompletionOfChange().click();
        holderPage.getNameMakingChangeCloseButton().click();

    }
}