package pages;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    /*Test the heading texts of each section
Test whether the play button is displayed or not
Test whether the Movies are displayed, in the corresponding movies sections
Test the Contact Us Section*/
    By headinTexts= By.tagName("h1");
    By playbtn = By.xpath("//button[normalize-space()='Play']");
    By listOfMovies= By.xpath("//div[@class='react-slick-item']//img");
    By contactUs = By.xpath("//p[@class='contact-us-paragraph']");
    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver =driver;
    }
    public List<WebElement> findHeadingTexts(){
        return driver.findElements(headinTexts);
    }
    public boolean isplayBtndisp(){
        return driver.findElement(playbtn).isDisplayed();
    }

    public boolean isMoviesDisp(){
        List<WebElement> movies = driver.findElements(listOfMovies);
        return !movies.isEmpty();
    }
    public boolean isContactDisp(){
        return driver.findElement(contactUs).isDisplayed();
    }
    public  String getContactText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement contactElement = wait.until(ExpectedConditions.visibilityOfElementLocated(contactUs));

        return driver.findElement(contactUs).getText();

    }
}
