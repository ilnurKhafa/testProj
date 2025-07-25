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
@BasePage.PageName("Окно Основание изменений - Объекты")
public class ObjectsTheBasisOfChangeWindowPage extends BasePage {

    private WebDriver driver;

    @Required
    @ElementDescription("Заголовок Основание изменений")
    @FindBy(xpath = "/html/body/div[3]/div[4]/div/mat-dialog-container/app-enter-history/div/div[1]/h3")
    private WebElement nameTheBasisOfChangeWindow;

    @ElementDescription("Кнопка Крестик")
    @FindBy(xpath = "//*[@id=\"mat-dialog-6\"]/app-enter-history/div/div[1]/button")
    private WebElement buttonCross;

    @ElementDescription("Поле Дата изменения")
    @FindBy(xpath = "//*[@id=\"mat-dialog-6\"]/app-enter-history/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/input[2]")
    private WebElement fieldDateOfChange;

    @ElementDescription("Календарь")
    @FindBy(xpath = "//*[@id=\"mat-dialog-3\"]/app-enter-history/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div/button[2]")
    private WebElement calendarButton;

    @ElementDescription("Календарь - кнопка очистить")
    @FindBy(xpath = "/html/body/div[3]/div[4]/div/mat-dialog-container/app-enter-history/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div/button[1]")
    private WebElement calendarClearButton;

    @ElementDescription("Поле Причина")
    @FindBy(xpath = "//select[contains(@class, 'form-control')]")
    private WebElement fieldReason;

    @ElementDescription("Причина - изменение по объекту")
    @FindBy(xpath = "//*[contains(text(), 'Изменения по объекту')]")
    private WebElement reasonChangeObject;

    @ElementDescription("Причина - добавление объекта")
    @FindBy(xpath = "//*[contains(text(), 'Добавление объекта')]")
    private WebElement reasonAppObject;

    @ElementDescription("Документ - поле для того, чтобы написать документ")
    @FindBy(xpath = "//*[@id=\"mat-dialog-3\"]/app-enter-history/div/div[2]/div[1]/div[2]/div[5]/div[2]/input")
    private WebElement documentField;

    @ElementDescription("Документ - кнопка очистить поле документа")
    @FindBy(xpath = "//*[@id=\"mat-dialog-8\"]/app-enter-history/div/div[2]/div[1]/div[2]/div[4]/div[2]/div/button[1]")
    private WebElement documentFieldClear;

    @ElementDescription("Сохранить")
    @FindBy(xpath = "/html/body/div[3]/div[4]/div/mat-dialog-container/app-enter-history/div/div[2]/div[2]/button[2]")
    private WebElement saveButton;

    @ElementDescription("Отмена")
    @FindBy(xpath = "//*[@id=\"mat-dialog-11\"]/app-enter-history/div/div[2]/div[2]/button[3]")
    private WebElement cancelButton;

    public ObjectsTheBasisOfChangeWindowPage(WebDriver driver) {
        this.driver = driver;
        // Явное ожидание с таймаутом 10 секунд
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

}
