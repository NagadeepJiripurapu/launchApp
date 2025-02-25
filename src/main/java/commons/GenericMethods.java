package commons;

import Exception.UiActionsException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class GenericMethods extends BaseTest implements UiActions {

    public void staticWait(long time) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (Exception ex) {
            throw new UiActionsException("Error occurred while waiting for the given static time :: {}", ex);
        }
    }

    @Override
    public void click(WebDriver driver, By locator) {
        try {
            // Using FluentWait for element to be clickable
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(60))
                    .pollingEvery(Duration.ofSeconds(5))
                    .ignoring(Exception.class);

            wait.until(driver1 -> {
                WebElement element = driver1.findElement(locator);
                if (element != null && element.isDisplayed() && element.isEnabled()) {
                    element.click();  // Click the element once it's enabled and displayed
                    return element;
                }
                return null;
            });
        } catch (Exception ex) {
            throw new UiActionsException("Error occurred while waiting for the element to be clickable :: {}", ex);
        }
    }

    @Override
    public boolean isDisplayed(WebDriver driver, By locator) {
        try {
            // Using FluentWait to wait for visibility of the element
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(60))
                    .pollingEvery(Duration.ofSeconds(5))
                    .ignoring(Exception.class);

            return wait.until(driver1 -> {
                WebElement element = driver1.findElement(locator);
                return element != null && element.isDisplayed();
            });
        } catch (Exception ex) {
            throw new UiActionsException("Error occurred while waiting for element to be displayed :: {}", ex);
        }
    }

    @Override
    public boolean isEnabled(WebDriver driver, By locator) {
        try {
            // Using FluentWait to wait for the element to be enabled
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(60))
                    .pollingEvery(Duration.ofSeconds(5))
                    .ignoring(Exception.class);

            return wait.until(driver1 -> {
                WebElement element = driver1.findElement(locator);
                return element != null && element.isEnabled();
            });
        } catch (Exception ex) {
            throw new UiActionsException("Error occurred while waiting for the element to be enabled :: {}", ex);
        }
    }

    @Override
    public List<String> getListOfVisibleText(WebDriver driver, By locator) {
        List<String> textList = new ArrayList<>();
        try {
            // Using FluentWait to wait for visibility of the first element in the list
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(60))
                    .pollingEvery(Duration.ofSeconds(5))
                    .ignoring(Exception.class);

            wait.until(driver1 -> {
                WebElement element = driver1.findElement(locator);
                return element != null && element.isDisplayed();
            });

            // Fetch all elements and get their visible text
            List<WebElement> ele = driver.findElements(locator);
            for (WebElement element : ele) {
                String title = element.getText().trim();
                textList.add(title);
            }
        } catch (Exception ex) {
            throw new UiActionsException("Error occurred while fetching list of visible text :: {}", ex);
        }
        return textList;
    }

    @Override
    public void moveToElement(WebDriver driver, By locator) {
        try {
            // Using FluentWait to wait for the element to be present and visible
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(60))
                    .pollingEvery(Duration.ofSeconds(5))
                    .ignoring(Exception.class);

            wait.until(driver1 -> {
                WebElement element = driver1.findElement(locator);
                return (element != null && element.isDisplayed()) ? element : null;
            });

            // Move to the element after it becomes visible
            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(locator)).perform();

        } catch (Exception ex) {
            throw new UiActionsException("Error occurred while waiting for element to move to :: {}", ex);
        }
    }

    @Override
    public void switchToWindow(WebDriver driver, String parentHandle) {
        try {
            // Using FluentWait to ensure window handles are available
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(60))
                    .pollingEvery(Duration.ofSeconds(5))
                    .ignoring(Exception.class);

            wait.until(driver1 -> driver1.getWindowHandles());

            Set<String> tabs = driver.getWindowHandles();
            for (String tab : tabs) {
                if (!tab.equals(parentHandle)) {
                    driver.switchTo().window(tab);  // Switch to the new window
                    break;
                }
            }
        } catch (Exception ex) {
            throw new UiActionsException("Error occurred while switching to window :: {}", ex);
        }
    }

    @Override
    public void scrollToViewJS(WebDriver driver, By locator) {
        try {
            // Using FluentWait to wait for the element to be visible
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(60))
                    .pollingEvery(Duration.ofSeconds(5))
                    .ignoring(Exception.class);

            wait.until(driver1 -> {
                WebElement element = driver1.findElement(locator);
                return (element != null && element.isDisplayed()) ? element : null;
            });

            // Scroll to the element once it becomes visible
            WebElement ele = driver.findElement(locator);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", ele);

        } catch (Exception ex) {
            throw new UiActionsException("Error occurred while waiting to scroll to the element :: {}", ex);
        }
    }

}
