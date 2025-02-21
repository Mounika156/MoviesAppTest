package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class PopularPage {
    By lm= By.xpath("        //div[@class='react-slick-item']//img");
    //By searchbtn= By.xpath("//button[contains(@class,'search')]//*[name()='svg']");
    WebDriver driver;
    WebDriverWait wait;
    By btn= By.xpath("//button[@class='search-button']");

    public PopularPage(WebDriver driver){
        this.driver = driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public List<String> listmov(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(lm));
        List<WebElement> list =  driver.findElements(lm);
        List<String> movtit = new ArrayList<>();
        for(WebElement li: list){
            movtit.add(li.getAttribute("alt"));
        }
        return movtit;
    }
    public void setSearchBtn(String name){
        //WebElement search= wait.until(ExpectedConditions.visibilityOfElementLocated(searchbtn));
       WebElement search= driver.findElement(btn);
        search.click();
        search.sendKeys(name);


    }

}