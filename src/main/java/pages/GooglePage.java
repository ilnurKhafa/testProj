package pages;

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
@BasePage.PageName("GooglePage")
public class GooglePage extends BasePage {

    private WebDriver driver;

    @Required
    @FindBy(xpath = "//*[@id=\"APjFqb\"]")
    @ElementDescription("Поле ввода запрос на поиск")
    private WebElement searchInput;

    @FindBy(xpath = "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]")
    @ElementDescription("Кнопка поиск")
    private WebElement searchButton;

    @Required
    @FindBy(xpath = "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[2]")
    @ElementDescription("Кнопка мне повезет")
    private WebElement luckyButton;

    @FindBy(xpath = "//*[@id=\"rso\"]/div[3]/div/div/div[1]/div/div/span/a/h3")
    @ElementDescription("Результаты поиска ")
    private List<WebElement> searchResult;

    // Конструктор и инициализация элементов
    public GooglePage(WebDriver driver) {
        this.driver = driver;
        // Явное ожидание с таймаутом 10 секунд
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

}