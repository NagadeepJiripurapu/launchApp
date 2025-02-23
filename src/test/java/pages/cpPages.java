package pages;

import commons.GenericMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static commons.BaseTest.getDriver;

public class cpPages {

    public static final By threedots=By.xpath("//a[@rel='noreferrer']//span[contains(text(),'...')]");
    public static final By newFeaturesPage=By.xpath("(//a[contains(text(),'News & Features')])[1]");
    public static final By videos=By.cssSelector("css_selector_for_videos");
    public static final By cross=By.xpath("//div[contains(text(),'x')]");
    public static final By IAcceptBtn=By.xpath("//button[contains(text(),'I Accept')]");
    public static final By threedaysOlder=By.xpath("//h3[contains(text(),'VIDEOS')]/parent::div/following-sibling::div//li//time//span[contains(text(),'3d')]");
    public static final By lastuploadedtime=By.xpath("(//h3[contains(text(),'VIDEOS')]/parent::div/following-sibling::div//li//time//span)[22]");
    GenericMethods gm = new GenericMethods();
    public  void hoverOnThreeDots() {
        try {
            if (gm.isDisplayed(getDriver(),IAcceptBtn)) {
                gm.click(getDriver(), IAcceptBtn);
                gm.click(getDriver(), cross);
                gm.moveToElement(getDriver(), threedots);
            }
        } catch (Exception e) {
            gm.click(getDriver(), cross);
            gm.moveToElement(getDriver(), threedots);
        }
    }
    public void navigateToNewFeaturesPage() {
        gm.scrollToViewJS(getDriver(), newFeaturesPage);
        gm.click(getDriver(), newFeaturesPage);
    }
    public void countVideosUploadedMoreThan() {
        int n=0,count=0;
        try{
            List<WebElement> olderList= getDriver().findElements(threedaysOlder);
            int i=olderList.size();
            String lastuploaded=getDriver().findElement(lastuploadedtime).getText();
            int lastUploadedDay=Integer.parseInt(lastuploaded.substring(0,1));
            System.out.println("The last uploaded video is "+lastUploadedDay+" days old");
            if (i>=1)
            {
                for (int day = 3; day <= lastUploadedDay; day++) {
                    String dynamicExpression = "//h3[contains(text(),'VIDEOS')]/parent::div/following-sibling::div//li//time[contains(@aria-label,'" + day + " days ago')]";
                    List<WebElement> duration = getDriver().findElements(By.xpath(dynamicExpression));
                    n = duration.size();
                    count+=n;
                }

            }
        }
        catch (Exception e)
        {
           e.printStackTrace();
        }
        System.out.println("The count of videos who's uploaded time >=3days are :" + count);

    }

}
