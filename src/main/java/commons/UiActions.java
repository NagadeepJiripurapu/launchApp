package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface UiActions {
    void click(WebDriver driver, By locator);
    void submit(WebDriver driver, By locator);
    void clickByJS(WebDriver driver, By locator);
    void switchToFrame(WebDriver driver, String frameNameId);
    void switchToDefaultContent(WebDriver driver);
    void switchToFrame(WebDriver driver, By locator);
    String getVisibleText(WebDriver driver, By locator);
    String getAttributeValue(WebDriver driver, By locator, String AttributName);
    void sendKeys(WebDriver driver, By locator, String Data);
    boolean isDisplayed(WebDriver driver, By locator);
    boolean isSelected(WebDriver driver, By locator);
    boolean isEnabled(WebDriver driver, By locator);
    List<String> getListOfVisibleText(WebDriver driver, By locator);
    List<String> getListOfErrorMessages(WebDriver driver, By locator);
    void highLight(WebDriver driver, By locator);
    void staticWait(WebDriver driver);
    void waitForElementPrescence(WebDriver driver, By locator, long timeInSeconds);
    void fluentWait(WebDriver driver, By locator, long totalWaitTime, long poolingTime);
    void moveToElement(WebDriver driver, By locator);
    void mouseRightClick(WebDriver driver, By locator);
    void doubleClick(WebDriver driver, By locator);
    void dragAndDrop(WebDriver driver, By Sourcelocator, By DestLocator);
    void selectDropDownByIndex(WebDriver driver, By locator, int index);
    List<String> getDropDownOptions(WebDriver driver, By locator);
    List<WebElement> getDropDownOptionsElement(WebDriver driver, By locator);
    void selectDropDownByVisibleText(WebDriver driver, By locator, String text);
    void selectDropDownByValue(WebDriver driver, By locator, String value);
    List<WebElement> getListOfWebElements(WebDriver driver, By locator);
    void selectDropDownOptionsByClick(WebDriver driver, By DropDownLocator, By dropDownOptionLocator);
    void clearText(WebDriver driver, By locator);
    void sendKeyboardKeys(int[] Keys);
    void forward(WebDriver driver);
    void refresh(WebDriver driver);
    void backward(WebDriver driver);
    void acceptAlert(WebDriver driver);
    void dismissAlert(WebDriver driver);
    void scrollToViewJS(WebDriver driver, By locator);
    void switchToWindow(WebDriver driver, String windowId);

}
