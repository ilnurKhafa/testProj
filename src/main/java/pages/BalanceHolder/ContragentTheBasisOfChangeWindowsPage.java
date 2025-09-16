package pages.BalanceHolder;

import base.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

@Getter
@BasePage.PageName("Окно Основание изменений - Контрагент")
public class ContragentTheBasisOfChangeWindowsPage extends BasePage{

    private WebDriver driver;

    @Required
    @ElementDescription("Наименование Основание изменений")
    @FindBy(xpath = "//*[@id=\"mat-dialog-10\"]/app-enter-history/div/div[1]/h3")
    private WebElement nameReasonForChanges;

    @Required
    @ElementDescription("Поле Дата изменения")
    @FindBy(xpath = "//*[@id=\"mat-dialog-10\"]/app-enter-history/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/input[2]")
    private WebElement fieldDateReasonForChanges;

    @ElementDescription("Поле причина основание изменений")
    @FindBy(xpath = "//select")
    private WebElement fieldReasonForChanges;

    @ElementDescription("Список причин основания изменения контрагента")
    @FindBy(xpath = "//option")
    private List<WebElement> listReasonChange;

    @ElementDescription("Поле Документ")
    @FindBy(xpath = "//input[@type=\"text\" and contains(@class, \"form-control ng-pristine ng-valid\")]")
    private WebElement fieldDocument;

    @ElementDescription("Поле АКТ")
    @FindBy(xpath = "//*[@id=\"mat-dialog-10\"]/app-enter-history/div/div[2]/div[1]/div[2]/div[7]/div[2]/input")
    private WebElement fieldAct;

    @ElementDescription("Кнопка Сохранить")
    @FindBy(xpath = "//*[@id=\"mat-dialog-10\"]/app-enter-history/div/div[2]/div[2]/button[2]")
    private WebElement saveButton;

    public ContragentTheBasisOfChangeWindowsPage(WebDriver driver) {
        this.driver = driver;
        // Явное ожидание с таймаутом 10 секунд
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

}
