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
@BasePage.PageName("Окно добавление объекта")
public class AddObjectsPage extends BasePage {

    private WebDriver driver;

    @Required
    @ElementDescription("Заголовок Добавление объекта")
    @FindBy(xpath = "//*[@id=\"mat-dialog-title-10\"]/h3")
    private WebElement nameAddObjects;

    @ElementDescription("Поле Наименование")
    @FindBy(xpath = "//*[@id=\"ROBJECT_ADD_NAME\"]")
    private WebElement nameField;

    @ElementDescription("Сохранить")
    @FindBy(xpath = "/html/body/div[3]/div[2]/div/mat-dialog-container/app-add-edit-reestr-element/mat-dialog-actions/button[1]")
    private WebElement saveButton;

    @ElementDescription("Закрыть")
    @FindBy(xpath = "//*[@id=\"mat-dialog-13\"]/app-add-edit-reestr-element/mat-dialog-actions/button[2]")
    private WebElement closeButton;

    public AddObjectsPage(WebDriver driver) {
        this.driver = driver;
        // Явное ожидание с таймаутом 10 секунд
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

}

