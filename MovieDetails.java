package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MovieDetails {
    By movieName = By.xpath("//div[@class = 'react-slick-item']//img");
    By title= By.className("movie-title");
    By time  = By.xpath("//p[@class='watch-time']");
    By rating= By.xpath("//p[@class='sensor-rating']");
    By year= By.xpath("//p[@class='release-year']");
    By playbtn = By.xpath("//button[@class='play-button']");
    By genre = By.cssSelector(".genres-heading");
    By audio = By.cssSelector(".audio-heading");
    By ratingcount = By.cssSelector(".rating-heading");
    By budget = By.cssSelector(".budget-heading");

    WebDriver driver;
    WebDriverWait wait;
    public MovieDetails(WebDriver Driver){
        this.driver = driver;
        this.wait= new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    public void  getMovieName(){
        WebElement movieele=wait.until(ExpectedConditions.visibilityOfElementLocated(movieName));
        movieele.click();
    }

    public void getTitle(){
        driver.findElement(title).getText();
    }

    public boolean isTimeDisp() {
        return driver.findElement(time).isDisplayed();
    }
    public boolean isratingdisp() {
        return driver.findElement(rating).isDisplayed();
    }
    public boolean setYear() {
        return driver.findElement(year).isDisplayed();
    }
    public boolean setPlaybtn() {
        return driver.findElement(playbtn).isDisplayed();
    }
    public boolean setGenre() {
        return driver.findElement(genre).isDisplayed();
    }
    public boolean setAudio() {
        return driver.findElement(audio).isDisplayed();
    }
    public boolean setRatingcount() {
        return driver.findElement(ratingcount).isDisplayed();
    }
    public boolean setBudget() {
        return driver.findElement(budget).isDisplayed();
    }


        public void navigateToMovieDetails() {
            wait.until(ExpectedConditions.elementToBeClickable(movieName)).click();
        }

        public boolean isMovieTitleDisplayed() {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(title)).isDisplayed();
        }

        public boolean isMovieDurationDisplayed() {
            return driver.findElement(time).isDisplayed();
        }

        public boolean isMovieGenreDisplayed () {
            return driver.findElement(genre).isDisplayed();
        }


        public boolean isMovieAudioDisplayed () {
            return driver.findElement(audio).isDisplayed();
        }

        public boolean isMovieBudgetDisplayed () {
            return driver.findElement(budget).isDisplayed();
        }

    }



