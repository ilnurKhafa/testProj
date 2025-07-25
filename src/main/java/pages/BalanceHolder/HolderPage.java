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

    @ElementDescription("Элемент для сравнения - Наименование")
    @FindBy(xpath = "//*[@id=\"RCONTRAGENT_NAME\"]")
    private WebElement rContragentName;

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

    //окно_редактирования_балансодержателя

    @ElementDescription("Наименование окно Редактирования контрагента")
    @FindBy(xpath = "//*[@id=\"mat-dialog-title-3\"]/h3")
    private WebElement nameAddHolder;

    @ElementDescription("Поле Наименование")
    @FindBy(xpath = "//*[@id=\"RCONTRAGENT_EDIT_NAME\"]")
    private WebElement fieldName;

    @ElementDescription("Кнопка Сохранить")
    @FindBy(xpath = "//*[contains(text(), 'Сохранить')]")
    private WebElement saveButton;

    @ElementDescription("Кнопка Закрыть")
    @FindBy(xpath = "//*[@id=\"mat-dialog-0\"]/app-add-edit-reestr-element/mat-dialog-actions/button[2]")
    private WebElement closeButton;

    //окно_внесение_изменений_окончено

    @ElementDescription("Наименование внесение изменений окнончено")
    @FindBy(xpath = "/html/body/div[4]/div[2]/div/mat-dialog-container/app-alert-window/div/mat-dialog-content/div/div[2]/span")
    private WebElement nameMakingChange;

    @ElementDescription("Наименование внесение изменений окнончено - кнопка Закрыть")
    @FindBy(xpath = "//*[@id=\"mat-dialog-5\"]/app-alert-window/div/div/button")
    private WebElement nameMakingChangeCloseButton;

    public HolderPage(WebDriver driver) {
        this.driver = driver;
        // Явное ожидание с таймаутом 10 секунд
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
}
