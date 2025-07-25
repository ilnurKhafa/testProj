package test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.BalanceHolder.HolderPage;
import pages.BalanceHolder.LoginBhPage;
import utils.WaitUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestBase {

    private LoginBhPage loginBhPage;
    private HolderPage holderPage;

    protected WebDriver driver;
    protected WaitUtils waitUtils;

    @BeforeAll
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");

        driver = new ChromeDriver(options);
        waitUtils = new WaitUtils(driver, 10);
        loginBhPage = new LoginBhPage(driver);
        holderPage = new HolderPage(driver);
    }

    @AfterAll
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void registration(String login, String password) {
        driver.get("http://localhost:8080/bh/");
        assertEquals("БАРС-Балансодержатель", loginBhPage.getTitle().getText());
        loginBhPage.isPageLoaded();

        loginBhPage.getPassword().click();
        loginBhPage.getPassword().sendKeys(password);
        loginBhPage.getLoginInput().click();
        loginBhPage.getLoginInput().sendKeys(login);

        loginBhPage.getAuthButton().click();
        holderPage.isPageLoaded();
        assertEquals("Правообладатель", loginBhPage.getBalanceHolder().getText());
    }
}