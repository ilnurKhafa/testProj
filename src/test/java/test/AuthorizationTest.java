package test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BalanceHolder.HolderPage;
import pages.BalanceHolder.LoginBhPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class AuthorizationTest extends TestBase {

    private LoginBhPage loginBhPage;
    private HolderPage holderPage;

    @BeforeAll
    public void initPages() {
        loginBhPage = new LoginBhPage(driver);
        holderPage = new HolderPage(driver);
    }

    @Test
    @DisplayName("Пустые поля, пустой логин и положительная авторизация")
    public void authBalanceHolderPositiveTest() {
        driver.get("http://localhost:8080/bh/");
        assertEquals("БАРС-Балансодержатель", loginBhPage.getTitle().getText());
        loginBhPage.isPageLoaded();

        loginBhPage.getAuthButton().click();
        assertEquals("Введите пароль", loginBhPage.getFailMassagePassword().getText());
        assertEquals("Введите имя пользователя", loginBhPage.getFailMassageLogin().getText());

        loginBhPage.getPassword().click();
        loginBhPage.getPassword().sendKeys("1mQYVeeeeQ");

        loginBhPage.getAuthButton().click();
        assertEquals("Введите имя пользователя", loginBhPage.getFailMassageLogin().getText());

        loginBhPage.getLoginInput().click();
        loginBhPage.getLoginInput().sendKeys("antropova");

        loginBhPage.getAuthButton().click();
        holderPage.isPageLoaded();

        assertAll(
                () -> assertTrue(holderPage.isPageLoaded(), "Страница не загрузилась"),
                () -> assertEquals("Правообладатель", holderPage.getBalanceHolder().getText(), "Текст заголовка не совпал с ожидаемым"));
    }

    @Test
    @DisplayName("Авторизация: пустое поле пароля и несуществующий пользователь")
    public void authBalanceHolderNegativePasswordAndLogin() {
        driver.get("http://localhost:8080/bh/");
        assertEquals("БАРС-Балансодержатель", loginBhPage.getTitle().getText());
        loginBhPage.isPageLoaded();

        loginBhPage.getLoginInput().click();
        loginBhPage.getLoginInput().sendKeys("1256");

        loginBhPage.getAuthButton().click();
        assertEquals("Введите пароль", loginBhPage.getFailMassagePassword().getText());

        loginBhPage.getPassword().click();
        loginBhPage.getPassword().sendKeys("111");

        loginBhPage.getAuthButton().click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement failMsgElement = loginBhPage.getFailMassagePerson();
        String expectedText = "Пользователь не найден.";
        wait.until(ExpectedConditions.textToBePresentInElement(failMsgElement, expectedText));

        assertEquals("Пользователь не найден.", loginBhPage.getFailMassagePerson().getText());
    }

}