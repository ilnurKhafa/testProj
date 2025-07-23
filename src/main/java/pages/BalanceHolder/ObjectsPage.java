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
@BasePage.PageName("Страница объектов")
public class ObjectsPage extends BasePage {

    private WebDriver driver;

    @Required
    @ElementDescription("Вкладка Объекты")
    @FindBy(xpath = "//*[@id=\"navbarSupportedContent\"]/ul/li[2]/a")
    private WebElement objectTab;

    @Required
    @ElementDescription("Движимое имущество")
    @FindBy(xpath = "/html/body/div[1]/app-root/app-objects/div/type-list/div/mat-tree/mat-nested-tree-node[1]/li/div")
    private WebElement movableProperty;

    @Required
    @ElementDescription("Движемое имущество: Автотранспорт")
    @FindBy(xpath = "/html/body/div[1]/app-root/app-objects/div/type-list/div/mat-tree/mat-nested-tree-node[2]/li/div")
    private WebElement autoTransport;

    @ElementDescription("Земельный участок")
    @FindBy(xpath = "/html/body/div[1]/app-root/app-objects/div/type-list/div/mat-tree/mat-nested-tree-node[1]/li/div")
    private WebElement parcelOfLand;

    @Required
    @ElementDescription("Недвижимое имущество")
    @FindBy(xpath = "/html/body/div[1]/app-root/app-objects/div/type-list/div/mat-tree/mat-nested-tree-node[2]/li/div")
    private WebElement immovableProperty;

    @ElementDescription("Недвижимое имущество: Здание")
    @FindBy(xpath = "/html/body/div[1]/app-root/app-objects/div/type-list/div/mat-tree/mat-nested-tree-node[2]/li/ul/mat-tree-node[1]/li")
    private WebElement buildingProperty;

    @ElementDescription("Недвижимое имущество: Помещение")
    @FindBy(xpath = "/html/body/div[1]/app-root/app-objects/div/type-list/div/mat-tree/mat-nested-tree-node[2]/li/ul/mat-tree-node[2]/li")
    private WebElement roomProperty;

    @ElementDescription("Недвижимое имущество: Сооружение")
    @FindBy(xpath = "/html/body/div[1]/app-root/app-objects/div/type-list/div/mat-tree/mat-nested-tree-node[2]/li/ul/mat-tree-node[3]/li")
    private WebElement constructionProperty;

    @ElementDescription("Кнопка добавить")
    @FindBy(xpath = "/html/body/div[1]/app-root/app-objects/div/div/div[1]/button[2]")
    private WebElement addButton;

    @ElementDescription("Кнопка редактировать")
    @FindBy(xpath = "/html/body/div[1]/app-root/app-objects/div/div/div[1]/button[3]")
    private WebElement updateButton;

    @ElementDescription("Кнопка списать в архив")
    @FindBy(xpath = "/html/body/div[1]/app-root/app-objects/div/div/div[1]/button[4]")
    private WebElement archiveButton;

    @ElementDescription("Кнопка восстановить из архива")
    @FindBy(xpath = "/html/body/div[1]/app-root/app-objects/div/div/div[1]/button[5]")
    private WebElement restoreFromArchiveButton;

    @ElementDescription("Кнопка просмотр")
    @FindBy(xpath = "/html/body/div[1]/app-root/app-objects/div/div/div[1]/button[1]")
    private WebElement viewButton;

    @ElementDescription("Кнопка подсчет итогов")
    @FindBy(xpath = "/html/body/div[1]/app-root/app-objects/div/div/div[1]/button[7]")
    private WebElement finalTallyButton;

    @ElementDescription("Кнопка просмотр на карте")
    @FindBy(xpath = "/html/body/div[1]/app-root/app-objects/div/div/div[1]/button[8]")
    private WebElement mapViewButton;

    @ElementDescription("Кнопка экспорт'")
    @FindBy(xpath = "/html/body/div[1]/app-root/app-objects/div/div/div[1]/button[10]")
    private WebElement exportButton;

    @ElementDescription("Кнопка импорт'")
    @FindBy(xpath = "/html/body/div[1]/app-root/app-objects/div/div/div[1]/a/button")
    private WebElement importButton;

    @ElementDescription("Кнопка отчеты")
    @FindBy(xpath = "/html/body/div[1]/app-root/app-objects/div/div/div[1]/button[11]")
    private WebElement reportsButton;

    @ElementDescription("Действующие - Архивные")
    @FindBy(xpath = "//*[@id=\"mat-select-0\"]")
    private WebElement currentArchiveButton;

    @ElementDescription("Выбор Архивные")
    @FindBy(xpath = "//*[@id=\"mat-option-1\"]")
    private WebElement selectionArchiveButton;

    @ElementDescription("Выбор Действующие")
    @FindBy(xpath = "//*[@id=\"mat-option-0\"]")
    private WebElement selectionCurrentButton;

    @ElementDescription("Кнопка Все")
    @FindBy(xpath = "//*[@id=\"mat-select-1\"]")
    private WebElement theAllButton;

    @ElementDescription("Выбор Все")
    @FindBy(xpath = "//*[@id=\"mat-option-2\"]")
    private WebElement selectionTheAllButton;

    @ElementDescription("Выбор Добавленные")
    @FindBy(xpath = "//*[@id=\"mat-option-3\"]")
    private WebElement selectionTheAddedButton;

    @ElementDescription("Выбор Измененные")
    @FindBy(xpath = "//*[@id=\"mat-option-4\"]")
    private WebElement selectionTheModifiedButton;

    @ElementDescription("Выбор Списанные")
    @FindBy(xpath = "//*[@id=\"mat-option-5\"]")
    private WebElement selectionTheDebitedButton;

    @ElementDescription("Фильтр")
    @FindBy(xpath = "/html/body/div[1]/app-root/app-objects/div/div/div[1]/button[12]")
    private WebElement theFilterButton;

    @ElementDescription("Очистить")
    @FindBy(xpath = "/html/body/div[1]/app-root/app-objects/div/div/div[1]/button[13]")
    private WebElement clearButton;

    @ElementDescription("Режим меток")
    @FindBy(xpath = "/html/body/div[1]/app-root/app-objects/div/div/div[2]/button[1]")
    private WebElement labelMode;

    @ElementDescription("Быстрый фильтр: Выбор атрибута")
    @FindBy(xpath = "//*[@id=\"mat-select-5\"]")
    private WebElement attributeSelectionButton;

    @ElementDescription("Быстрый фильтр: Поле ввода")
    @FindBy(xpath = "/html/body/div[1]/app-root/app-objects/div/div/div[2]/input")
    private WebElement theInputField;

    @ElementDescription("Применить")
    @FindBy(xpath = "/html/body/div[1]/app-root/app-objects/div/div/div[2]/button[2]")
    private WebElement theApplyButton;

    public ObjectsPage(WebDriver driver) {
        this.driver = driver;
        // Явное ожидание с таймаутом 10 секунд
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

}