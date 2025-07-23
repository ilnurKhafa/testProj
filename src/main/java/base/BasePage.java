package base;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BasePage {

    protected WebDriverWait wait;

    // Аннотация для пометки обязательных элементов
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface Required {}

    // Аннотация для имени страницы (аналог @Name из твоего примера)
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public @interface PageName {
        String value();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface ElementDescription {
        String value();
    }

    // Получение имени страницы (из аннотации или класса)
    protected String getPageName() {
        if (this.getClass().isAnnotationPresent(PageName.class)) {
            return this.getClass().getAnnotation(PageName.class).value();
        }
        return this.getClass().getSimpleName();
    }

    // Проверка, что страница загружена (по обязательным элементам)
    public boolean isPageLoaded() {
        try {
            checkRequiredElements();
            return true;
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    // Проверка обязательных элементов (помеченных @Required)
    protected void checkRequiredElements() {
        List<WebElement> requiredElements = getRequiredElements();
        requiredElements.forEach(el -> wait.until(ExpectedConditions.visibilityOf(el)));
    }

    // Получение списка обязательных элементов через рефлексию
    private List<WebElement> getRequiredElements() {
        return Arrays.stream(this.getClass().getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(Required.class))
                .filter(f -> WebElement.class.isAssignableFrom(f.getType()))
                .map(f -> {
                    try {
                        f.setAccessible(true);
                        return (WebElement) f.get(this);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException("Failed to access field: " + f.getName(), e);
                    }
                })
                .collect(Collectors.toList());
    }

}