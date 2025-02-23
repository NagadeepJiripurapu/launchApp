package pages;

import commons.GenericMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static commons.BaseTest.getDriver;

public class dp2Pages {
    GenericMethods gm = new GenericMethods();

    public static final By footerLocator= By.xpath("//h2[contains(text(),'Team')]/parent::nav/parent::div/parent::div/parent::footer");
    public static final By footerSection=By.xpath("//h2[contains(text(),'Team')]");


    public void scrollDownToFooter() {
      gm.scrollToViewJS(getDriver(),footerSection);
    }
    public void storingAllFooterLinks() {
        WebElement footer = getDriver().findElement(footerLocator);
        List<WebElement> footerLinks = footer.findElements(By.tagName("a"));
        Set<String> uniqueLinks = new HashSet<>();
        Set<String> duplicateLinks = new HashSet<>();
        File file =new File("footerLinks.csv");
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file)))
        {
            writer.write("Link Text, URL");
            writer.newLine();
            for(WebElement link : footerLinks)
            {
                String linkText = link.getText().trim();
                String url = link.getAttribute("href");
                if(uniqueLinks.contains(url))
                {
                    duplicateLinks.add(url);
                }
                else
                {
                    uniqueLinks.add(url);
                    writer.write(linkText + "," + url);
                    writer.newLine();
                }
            }
            if(!duplicateLinks.isEmpty())
            {
                System.out.println("Duplicate Links Found: ");
                for(String duplicateLink : duplicateLinks)
                {
                    System.out.println(duplicateLink);
                }
            }else {
                System.out.println("No Duplicate Links Found");
            }
            System.out.println("All Footer Links are stored in footerLinks.csv file");
        }catch (Exception e)
        {
            e.printStackTrace();
    }

    }
}
