package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeaderSection {

    By websiteLogo = By.cssSelector("img[alt*='logo']");
    By navbarEle= By.cssSelector("nav");
    By home = By.xpath("//a[text()='Home']");

    By popular= By.xpath("//a[normalize-space()='Popular']");
    By accLink= By.xpath("//button[@class='avatar-button']//img");
    By tit = By.xpath("//h1[@class='account-heading']");

    WebDriver driver;
    WebDriverWait  wait;
    public HeaderSection(WebDriver driver){
        this.driver= driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public WebElement findWebSiteLogo(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(websiteLogo));

    }
    public  WebElement findNavbar(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(navbarEle));
    }
    public WebElement findhomeLnk(){
       return wait.until(ExpectedConditions.elementToBeClickable(home));


    }
    public void findpopLnk(){
        WebElement popLink = wait.until(ExpectedConditions.visibilityOfElementLocated(popular));
        popLink.click();
    }
    public void findaccLnk(){
        WebElement accBut = wait.until(ExpectedConditions.visibilityOfElementLocated(accLink));
        accBut.click();
    }
   /* public String pagedsp(){
        WebElement cururl= wait.until(ExpectedConditions.urlToBe(driver.getCurrentUrl()));
        return cururl.getText();
       // return driver.getCurrentUrl().contains("Home");
    }*/
    public String ispopdisp(){


        WebElement popp= driver.findElement(popular);
        return popp.getText();

    }
    public String isaccdisp(){

        WebElement acct= wait.until(ExpectedConditions.visibilityOfElementLocated(tit));
        return acct.getText();

    }


}
