package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPage {

        WebDriver driver;
        WebDriverWait wait;

        // Locators for Movie Details Page Elements
         By title = By.cssSelector(".movie-title");
         By time = By.cssSelector(".watch-time");
         By audio = By.cssSelector(".audio-heading");
         By budget = By.cssSelector(".budget-heading");
         By genre = By.cssSelector(".genres-heading");
         By rating = By.cssSelector(".rating-heading");
        By clickMovie = By.xpath("//img[@alt='No Time to Die']");


        public AccountPage(WebDriver driver) {
            this.driver = driver;
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        public void clkMovie(){
            wait.until(ExpectedConditions.elementToBeClickable(clickMovie)).click();
        }
        public String getTitle(){
            return wait.until(ExpectedConditions.visibilityOfElementLocated(title)).getText();
        }


        public boolean isTimeDisplayed() {
            return driver.findElement(time).isDisplayed();
        }

        public boolean isAudioDisplayed() {
            return driver.findElement(audio).isDisplayed();
        }

        public boolean isBudgetDisplayed() {
            return driver.findElement(budget).isDisplayed();
        }

        public boolean isGenreDisplayed() {
            return driver.findElement(genre).isDisplayed();
        }

        public boolean isRatingDisplayed() {
            return driver.findElement(rating).isDisplayed();
        }
}
