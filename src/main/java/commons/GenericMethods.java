package commons;
import Exception.UiActionsException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class GenericMethods extends BaseTest implements UiActions{
    public void staticWait(long time)
    {
        try{
            TimeUnit.SECONDS.sleep(time);
        }
        catch (Exception ex)
        {
            throw new UiActionsException("Error occurred while waiting for given static time :: {}", ex);
        }
    }
    @Override
    public void click(WebDriver driver, By locator) {
        try{
            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        } catch (Exception ex){
            throw new UiActionsException("Error occurred while waiting for given static time :: {}", ex);
        }

    }

    @Override
    public void submit(WebDriver driver, By locator) {
        try{
            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(locator)).submit();
        } catch (Exception ex){
            throw new UiActionsException("Error occurred while waiting for given static time :: {}", ex);
        }
    }

    @Override
    public void clickByJS(WebDriver driver, By locator) {
        try{
            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            WebElement element = driver.findElement(locator);
            JavascriptExecutor js= (JavascriptExecutor) driver;
            js.executeScript("argument[0].click();", element);
        } catch (Exception ex){
            throw new UiActionsException("Error occurred while waiting for given static time :: {}", ex);
        }
    }

    @Override
    public void switchToFrame(WebDriver driver, String frameNameId) {
        try {
            staticWait(3);
            driver.switchTo().frame(frameNameId);
        }catch (Exception ex){
            throw new UiActionsException("Error occurred while waiting for given static time :: {}" + frameNameId, ex);
        }
    }

    @Override
    public void switchToDefaultContent(WebDriver driver) {
        try {
            staticWait(3);
            driver.switchTo().defaultContent();
        }catch (Exception ex){
            throw new UiActionsException("Error occurred while waiting for given static time :: {}", ex);
        }
    }

    @Override
    public void switchToFrame(WebDriver driver, By locator) {
        try {
            staticWait(3);
            WebElement frameElement = driver.findElement(locator);
            driver.switchTo().frame(frameElement);
        }catch (Exception ex){
            throw new UiActionsException("Error occurred while waiting for given static time :: {}" + locator, ex);
        }
    }

    @Override
    public String getVisibleText(WebDriver driver, By locator) {
        try{
            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
           return wait.until(ExpectedConditions.elementToBeClickable(locator)).getText();
        } catch (Exception ex){
            throw new UiActionsException("Error occurred while waiting for given static time :: {}", ex);
        }
    }

    @Override
    public String getAttributeValue(WebDriver driver, By locator, String AttributName) {
        try{
            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(locator)).getAttribute(AttributName);
        } catch (Exception ex){
            throw new UiActionsException("Error occurred while waiting for given static time :: {}" + locator, ex);
        }

        return AttributName;
    }

    @Override
    public void sendKeys(WebDriver driver, By locator, String Data) {
        try{
            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(Data);
        } catch (Exception ex){
            throw new UiActionsException("Error occurred while waiting for given static time :: {}" + locator, ex);
        }
    }

    @Override
    public boolean isDisplayed(WebDriver driver, By locator) {
        try{
            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
            return  wait.until(ExpectedConditions.elementToBeClickable(locator)).isDisplayed();
        } catch (Exception ex){
            throw new UiActionsException("Error occurred while waiting for given static time :: {}", ex);
        }
        //return false;
    }

    @Override
    public boolean isSelected(WebDriver driver, By locator) {
        return false;
    }

    @Override
    public boolean isEnabled(WebDriver driver, By locator) {
        return false;
    }

    @Override
    public List<String> getListOfVisibleText(WebDriver driver, By locator) {
        return null;
    }

    @Override
    public List<String> getListOfErrorMessages(WebDriver driver, By locator) {
        return null;
    }

    @Override
    public void highLight(WebDriver driver, By locator) {

    }

    @Override
    public void staticWait(WebDriver driver) {

    }

    @Override
    public void waitForElementPrescence(WebDriver driver, By locator, long timeInSeconds) {

    }

    @Override
    public void fluentWait(WebDriver driver, By locator, long totalWaitTime, long poolingTime) {

    }

    @Override
    public void moveToElement(WebDriver driver, By locator) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(locator)).build().perform();

    }
    @Override
    public void switchToWindow(WebDriver driver, String parentHandle) {
        Set<String> tabs=getDriver().getWindowHandles();
        for(String tab:tabs)
        {
            if (!tab.equals(parentHandle))
            {
                getDriver().switchTo().window(tab);
            }
        }
    }

    @Override
    public void mouseRightClick(WebDriver driver, By locator) {

    }

    @Override
    public void doubleClick(WebDriver driver, By locator) {

    }

    @Override
    public void dragAndDrop(WebDriver driver, By Sourcelocator, By DestLocator) {

    }

    @Override
    public void selectDropDownByIndex(WebDriver driver, By locator, int index) {

    }

    @Override
    public List<String> getDropDownOptions(WebDriver driver, By locator) {
        return null;
    }

    @Override
    public List<WebElement> getDropDownOptionsElement(WebDriver driver, By locator) {
        return null;
    }

    @Override
    public void selectDropDownByVisibleText(WebDriver driver, By locator, String text) {

    }

    @Override
    public void selectDropDownByValue(WebDriver driver, By locator, String value) {

    }

    @Override
    public List<WebElement> getListOfWebElements(WebDriver driver, By locator) {
        return null;
    }

    @Override
    public void selectDropDownOptionsByClick(WebDriver driver, By DropDownLocator, By dropDownOptionLocator) {

    }

    @Override
    public void clearText(WebDriver driver, By locator) {

    }

    @Override
    public void sendKeyboardKeys(int[] Keys) {

    }

    @Override
    public void forward(WebDriver driver) {

    }

    @Override
    public void refresh(WebDriver driver) {

    }

    @Override
    public void backward(WebDriver driver) {

    }

    @Override
    public void acceptAlert(WebDriver driver) {

    }

    @Override
    public void dismissAlert(WebDriver driver) {

    }
    @Override
    public void scrollToViewJS(WebDriver driver, By locator) {

        WebElement ele= getDriver().findElement(locator);
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", ele);
    }

}
