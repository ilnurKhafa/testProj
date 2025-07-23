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
@BasePage.PageName("Страница правообладателя балансодержателя")
public class HolderPage extends BasePage {

    private WebDriver driver;

    @Required
    @ElementDescription("Заголовок страницы")
    @FindBy(xpath = "//*[@id=\"navbarSupportedContent\"]/ul/li[1]/a")
    private WebElement balanceHolder;

    @ElementDescription("Кнопка редактировать")
    @FindBy(xpath = "/html/body/div[1]/app-root/app-view-balanceholder/div/div/button[1]")
    private WebElement editButton;

    @ElementDescription("Кнопка история")
    @FindBy(xpath = "/html/body/div[1]/app-root/app-view-balanceholder/div/div/a/button")
    private WebElement historyButton;

    @ElementDescription("Кнопка отчеты")
    @FindBy(xpath = "/html/body/div[1]/app-root/app-view-balanceholder/div/div/button[2]")
    private WebElement reportsButton;

    @ElementDescription("Объекты")
    @FindBy(xpath = "//*[@id=\"navbarSupportedContent\"]/ul/li[2]/a")
    private WebElement objects;

    @ElementDescription("Документы")
    @FindBy(xpath = "//*[@id=\"navbarSupportedContent\"]/ul/li[3]/a")
    private WebElement documents;

    @ElementDescription("Уведомления")
    @FindBy(xpath = "//*[@id=\"navbarSupportedContent\"]/ul/li[4]/a")
    private WebElement notifications;

    @Required
    @ElementDescription("Кнопка Окончание внесения изменений")
    @FindBy(xpath = "/html/body/div[1]/app-root/app-view-balanceholder/div/div/button[3]/span")
    private WebElement buttonCompletionOfChange;

    @ElementDescription("Справка")
    @FindBy(xpath = "/html/body/div[1]/app-root/nav/button[1]")
    private WebElement buttonHelp;

    @ElementDescription("Выход")
    @FindBy(xpath = "/html/body/div[1]/app-root/nav/button[2]")
    private WebElement buttonExit;

    public HolderPage(WebDriver driver) {
        this.driver = driver;
        // Явное ожидание с таймаутом 10 секунд
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
}
