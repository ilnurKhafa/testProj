package test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.BalanceHolder.HolderPage;
import pages.BalanceHolder.LoginBhPage;

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
        loginBhPage.getPassword().sendKeys("111");

        loginBhPage.getAuthButton().click();
        assertEquals("Введите имя пользователя", loginBhPage.getFailMassageLogin().getText());

        loginBhPage.getLoginInput().click();
        loginBhPage.getLoginInput().sendKeys("admin");

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
        loginBhPage.getLoginInput().sendKeys("123");

        loginBhPage.getAuthButton().click();
        assertEquals("Введите пароль", loginBhPage.getFailMassagePassword().getText());

        loginBhPage.getPassword().click();
        loginBhPage.getPassword().sendKeys("111");

        loginBhPage.getAuthButton().click();
        assertEquals("Пользователь не найден.", loginBhPage.getFailMassagePerson().getText());
    }

}