package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPage {

    public class MovieDetailsPage {
        WebDriver driver;
        WebDriverWait wait;

        // Locators for Movie Details Page Elements
        By movieName = By.xpath("//h1[contains(@class, 'movie-name')]");
         By title = By.xpath("//p[contains(@class, 'title')]");
         By time = By.xpath("//span[contains(@class, 'time')]");
         By audio = By.xpath("//span[contains(@class, 'audio')]");
         By budget = By.xpath("//span[contains(@class, 'budget')]");
         By genre = By.xpath("//span[contains(@class, 'genre')]");
         By rating = By.xpath("//span[contains(@class, 'rating')]");

        public MovieDetailsPage(WebDriver driver) {
            this.driver = driver;
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        public void navigateToMovieDetails() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(movieName)).click();
        }

        public boolean isMovieNameDisplayed() {
            return driver.findElement(movieName).isDisplayed();
        }

        public boolean isTitleDisplayed() {
            return driver.findElement(title).isDisplayed();
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

}
