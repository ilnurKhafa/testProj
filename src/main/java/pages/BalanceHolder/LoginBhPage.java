package pages.BalanceHolder;


import base.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Getter
@BasePage.PageName("Страница входа в кабинет балансодержателя")
public class LoginBhPage extends BasePage {

    private WebDriver driver;

    @Required
    @ElementDescription("Заголовок страницы")
    @FindBy(xpath = "//*[@id=\"app-login-title\"]/h2")
    private WebElement title;

    @Required
    @FindBy(xpath = "//*[@id=\"username\"]")
    @ElementDescription("Поле ввода ЛОГИН")
    private WebElement loginInput;

    @FindBy(xpath = "//*[@id=\"password\"]")
    @ElementDescription("Поле ввода ПАРОЛЬ")
    private WebElement password;

    @FindBy(xpath = "/html/body/div[1]/app-root/app-login/div/form[2]/div/button")
    @ElementDescription("Кнопка Вход")
    private WebElement authButton;

    @FindBy(xpath = "/html/body/div[1]/app-root/app-login/div/form[2]/div/label")
    @ElementDescription("Чек-бокс Запомни меня")
    private WebElement rememberButton;

    @FindBy(xpath = "/html/body/div[1]/app-root/app-login/div/button")
    @ElementDescription("Авторизация через ЕСИА")
    private WebElement esiaAuthButton;

    @FindBy(xpath = "/html/body/div[1]/app-root/app-login/div/form[1]/div[1]/div/div")
    @ElementDescription("Введите имя пользователя")
    private WebElement failMassageLogin;

    @FindBy(xpath = "/html/body/div[1]/app-root/app-login/div/form[1]/div[2]/div/div")
    @ElementDescription("Введите пароль")
    private WebElement failMassagePassword;

    @FindBy(xpath = "/html/body/div[1]/app-root/app-login/div/div[2]")
    @ElementDescription("Пользователь не найден")
    private WebElement failMassagePerson;

    @ElementDescription("Заголовок страницы")
    @FindBy(xpath = "//*[@id=\"navbarSupportedContent\"]/ul/li[1]/a")
    private WebElement balanceHolder;

    public LoginBhPage(WebDriver driver) {
        this.driver = driver;
        // Явное ожидание с таймаутом 10 секунд
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

}
