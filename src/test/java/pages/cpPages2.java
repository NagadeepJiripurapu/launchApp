package pages;

import commons.GenericMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static commons.BaseTest.getDriver;

public class cpPages2 {
    GenericMethods gm = new GenericMethods();
    public static final By cross= By.xpath("//div[contains(text(),'x')]");
    public static final By IAcceptBtn= By.xpath("//button[contains(text(),'I Accept')]");
    public static final By Shop= By.xpath("//nav[starts-with(@class,'_headerPrimaryMenu')]//li//a//span[contains(text(),'Shop')]");
    public static final By Mens= By.xpath("(//a[starts-with(@title,'Men')])[1]");
    public static final By allDepartmentItems= By.cssSelector("div[class='side-nav-facet-items allDepartmentsBoxes'] ul li a span");
    public static final By allDepartmentScrollView= By.cssSelector("div[class='side-nav-facet-items allDepartmentsBoxes']");
    public static final By verifyJacketIsSelected= By.xpath("//a[@aria-label='Remove Jackets filter']");
    public static final By jacketsRadioButton= By.xpath("//*[starts-with(@data-trk-id,'side-nav-jackets')]");
    public static final By jacketPrice= By.xpath("//span[@class='sr-only']");
    public static final By jacketTitle= By.cssSelector(".product-card-title a");
    public static final By popularJackets= By.xpath("//div[@class='product-grid-top-area']/following-sibling::div//span[@class='top-seller-vibrancy-message']/span");
    public static final By nextPageBtn= By.xpath("(//div[@class='pagination-container']/ul/li[starts-with(@class,'next-page')]//a)[1]");
    public static final By nextBtnDisabled= By.xpath("//div[@class='product-grid-top-area']//a[@aria-disabled='true']");



    public void hoverOnShop() {
        try {
            if (gm.isDisplayed(getDriver(),IAcceptBtn)) {
                gm.click(getDriver(), IAcceptBtn);
                gm.click(getDriver(), cross);
                gm.moveToElement(getDriver(), Shop);
            }
        } catch (Exception e) {
            gm.click(getDriver(), cross);
            gm.moveToElement(getDriver(), Shop);
        }
    }
    public void clickOnMens()
    {
        String parentTab=getDriver().getWindowHandle();
        gm.click(getDriver(),Mens);
        gm.switchToWindow(getDriver(),parentTab);

    }
    public void clickOnJackets()
    {
        try
        {
            gm.scrollToViewJS(getDriver(),allDepartmentScrollView);
            gm.click(getDriver(),jacketsRadioButton);
        }
        catch (Exception e)
        {
            gm.scrollToViewJS(getDriver(),allDepartmentScrollView);
            gm.click(getDriver(),jacketsRadioButton);
        }
    }
    public void collectingJacketsPrice()
    {
        String filePath="/Users/nagadeepjiripurapu/IdeaProjects/AutomationVeeva/src/test/TestOutput/testResult.txt";
        List<WebElement> JacketPrice=getDriver().findElements((By) jacketPrice);
        for(int i=0;i<JacketPrice.size();i++)
        {
            String priceOfJacket=JacketPrice.get(i).getText();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true))) {
                writer.write(priceOfJacket);
                writer.newLine();
            } catch (IOException e) {
                System.err.println("Error writing to file: " + e.getMessage());
            }

        }
        List<WebElement> jacketDisc=getDriver().findElements((By) jacketTitle);
        for(int i=0;i<jacketDisc.size();i++)
        {
            String DiscOfJacket=jacketDisc.get(i).getText();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true))) {
                writer.write(DiscOfJacket);
                writer.newLine();
            } catch (IOException e) {
                System.err.println("Error writing to file: " + e.getMessage());
            }

        }
        List<WebElement> jacketPopular=getDriver().findElements((By) popularJackets);
        for(int i=0;i<jacketPopular.size();i++)
        {
            String PopularJacket=jacketPopular.get(i).getText();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true))) {
                writer.write(PopularJacket);
                writer.newLine();
            } catch (IOException e) {
                System.err.println("Error writing to file: " + e.getMessage());
            }
        }
        if (getDriver().findElement(By.xpath("(//div[@class='pagination-container']/ul/li[starts-with(@class,'next-page')]//a)[1]")).isEnabled())
            System.out.println("Next button is disabled");
        try {
            gm.click(getDriver(), nextPageBtn);
            collectingJacketsPrice();
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
}
