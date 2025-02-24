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
import java.util.ArrayList;
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
            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        } catch (Exception ex){
            throw new UiActionsException("Error occurred while waiting for given static time :: {}", ex);
        }

    }




    @Override
    public boolean isDisplayed(WebDriver driver, By locator) {
        try{
            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
            return  wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
        } catch (Exception ex){
            throw new UiActionsException("Error occurred while waiting for given static time :: {}", ex);
        }
        //return false;
    }

    @Override
    public boolean isEnabled(WebDriver driver, By locator) {
        try{
            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
            return  wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isEnabled();
        } catch (Exception ex){
            throw new UiActionsException("Error occurred while waiting for given static time :: {}", ex);
        }
    }

    @Override
    public List<String> getListOfVisibleText(WebDriver driver, By locator) {
        List<String> textList = new ArrayList<>();
        try{

            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
              wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isEnabled();
            List<WebElement> ele=driver.findElements(locator);
            for (int i = 0; i < ele.size(); i++) {
                String title = ele.get(i).getText();
                String actualTitle = title.trim();
                textList.add(actualTitle);
            }
        } catch (Exception ex){
            throw new UiActionsException("Error occurred while waiting for given static time :: {}", ex);
        }
        return textList;
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
    public void scrollToViewJS(WebDriver driver, By locator) {

        WebElement ele= getDriver().findElement(locator);
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", ele);
    }

}
