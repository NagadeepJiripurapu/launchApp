package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;

public interface UiActions {
    void click(WebDriver driver, By locator);
    boolean isDisplayed(WebDriver driver, By locator);
    boolean isEnabled(WebDriver driver, By locator);
    List<String> getListOfVisibleText(WebDriver driver, By locator);
    void moveToElement(WebDriver driver, By locator);
    void scrollToViewJS(WebDriver driver, By locator);
    void switchToWindow(WebDriver driver, String windowId);
    String getVisibleText(WebDriver driver, By locator);

}
