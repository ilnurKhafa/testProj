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
@BasePage.PageName("Вкладка Документы")
public class DocumentsPage extends BasePage {

    private WebDriver driver;

    @Required
    @ElementDescription("Документы")
    @FindBy(xpath = "//*[@id=\"navbarSupportedContent\"]/ul/li[3]/a")
    private WebElement documents;

    @Required
    @ElementDescription("Постановление")
    @FindBy(xpath = "/html/body/div[1]/app-root/app-documents/div/type-list/div/mat-tree/mat-tree-node[1]/li")
    private WebElement boardResolution;

    @Required
    @ElementDescription("Приказ")
    @FindBy(xpath = "/html/body/div[1]/app-root/app-documents/div/type-list/div/mat-tree/mat-tree-node[2]/li")
    private WebElement order;

    @Required
    @ElementDescription("Решение")
    @FindBy(xpath = "/html/body/div[1]/app-root/app-documents/div/type-list/div/mat-tree/mat-tree-node[3]/li")
    private WebElement decision;

    @ElementDescription("Кнопка добавить")
    @FindBy(xpath = "/html/body/div[1]/app-root/app-documents/div/div/div/button[2]")
    private WebElement addButton;

    @ElementDescription("Кнопка редактировать")
    @FindBy(xpath = "/html/body/div[1]/app-root/app-documents/div/div/div/button[3]")
    private WebElement updateButton;

    @ElementDescription("Кнопка списать в архив")
    @FindBy(xpath = "/html/body/div[1]/app-root/app-documents/div/div/div/button[4]")
    private WebElement archiveButton;

    @ElementDescription("Кнопка просмотр")
    @FindBy(xpath = "/html/body/div[1]/app-root/app-documents/div/div/div/button[1]")
    private WebElement viewButton;

    @ElementDescription("Кнопка копия")
    @FindBy(xpath = "/html/body/div[1]/app-root/app-documents/div/div/div/button[5]")
    private WebElement copyButton;

    @ElementDescription("Кнопка сумма")
    @FindBy(xpath = "/html/body/div[1]/app-root/app-documents/div/div/div/button[6]")
    private WebElement sumButton;

    @ElementDescription("Кнопка экспорт")
    @FindBy(xpath = "/html/body/div[1]/app-root/app-documents/div/div/div/button[7]")
    private WebElement exportButton;

    @ElementDescription("Кнопка импорт")
    @FindBy(xpath = "/html/body/div[1]/app-root/app-documents/div/div/div/a/button")
    private WebElement importButton;

    @ElementDescription("Кнопка отчеты")
    @FindBy(xpath = "/html/body/div[1]/app-root/app-documents/div/div/div/button[8]")
    private WebElement reportButton;

    @ElementDescription("Действующие - Архивные")
    @FindBy(xpath = "//*[@id=\"mat-select-3\"]")
    private WebElement currentArchiveButton;

    @ElementDescription("Выбор Действующие")
    @FindBy(xpath = "//*[@id=\"mat-option-32\"]")
    private WebElement selectionCurrentButton;

    @ElementDescription("Выбор Архивные")
    @FindBy(xpath = "//*[@id=\"mat-option-33\"]")
    private WebElement selectionArchiveButton;

    @ElementDescription("Кнопка изменить состояние")
    @FindBy(xpath = "/html/body/div[1]/app-root/app-documents/div/div/div/button[9]")
    private WebElement changeOfStateButton;

    @ElementDescription("Фильтр")
    @FindBy(xpath = "/html/body/div[1]/app-root/app-documents/div/div/div/button[10]")
    private WebElement theFilterButton;

    @ElementDescription("Очистить")
    @FindBy(xpath = "/html/body/div[1]/app-root/app-documents/div/div/div/button[11]")
    private WebElement clearButton;

    @ElementDescription("Окно фильтра")
    @FindBy(xpath = "//*[@id=\"mat-dialog-15\"]/app-filter/div[1]/div[1]/h3")
    private WebElement filter;

    @ElementDescription("Окно фильтра - удалить")
    @FindBy(xpath = "//*[@id=\"mat-dialog-15\"]/app-filter/div[1]/div[2]/div[1]/button/span/i")
    private WebElement deleteButton;

    @ElementDescription("Окно фильтра - сохранить")
    @FindBy(xpath = "//*[@id=\"mat-dialog-15\"]/app-filter/div[1]/div[2]/div[3]/button[1]")
    private WebElement saveButton;

    @ElementDescription("Окно фильтра - ок")
    @FindBy(xpath = "//*[@id=\"mat-dialog-15\"]/app-filter/div[1]/div[2]/div[3]/button[2]")
    private WebElement okButton;

    @ElementDescription("Окно фильтра - отмена")
    @FindBy(xpath = "//*[@id=\"mat-dialog-15\"]/app-filter/div[1]/div[2]/div[3]/button[3]")
    private WebElement cancelButton;

    @ElementDescription("Окно фильтра - выбор для фильтра")
    @FindBy(xpath = "//*[@id=\"mat-dialog-15\"]/app-filter/div[1]/div[2]/div[2]/dx-filter-builder/div/div[1]/div[1]")
    private WebElement orAndButton;

    @ElementDescription("Окно фильтра - выбор для фильтра: и")
    @FindBy(xpath = "//*[@id=\"dx-59d749a7-a98b-8de7-d3f4-caae5b47bcfe\"]/div")
    private WebElement andButton;

    @ElementDescription("Окно фильтра - выбор для фильтра: или")
    @FindBy(xpath = "/html/body/div[6]/div/div/div/div/div/div/div[1]/ul/li[2]/div")
    private WebElement orButton;

    @ElementDescription("Окно фильтра - выбор для фильтра: не и")
    @FindBy(xpath = "/html/body/div[6]/div/div/div/div/div/div/div[1]/ul/li[3]/div")
    private WebElement notAndButton;

    @ElementDescription("Окно фильтра - выбор для фильтра: не или")
    @FindBy(xpath = "/html/body/div[6]/div/div/div/div/div/div/div[1]/ul/li[4]/div")
    private WebElement notOrButton;

    @ElementDescription("Окно фильтра - плюс")
    @FindBy(xpath = "//*[@id=\"mat-dialog-15\"]/app-filter/div[1]/div[2]/div[2]/dx-filter-builder/div[1]/div[1]/div[2]")
    private WebElement plusButton;

    @ElementDescription("Окно фильтра - добавить условие")
    @FindBy(xpath = "//*[@id=\"dx-ac3eb65d-b213-b52a-3114-a0adbe64117f\"]/div")
    private WebElement addConditionButton;

    @ElementDescription("Окно фильтра - добавить группу")
    @FindBy(xpath = "/html/body/div[6]/div/div/div/div/div/div/div[1]/ul/li[2]/div")
    private WebElement addGroupButton;

    public DocumentsPage(WebDriver driver) {
        this.driver = driver;
        // Явное ожидание с таймаутом 10 секунд
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

}
