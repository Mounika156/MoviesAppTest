package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {

    By websitelogo = By.cssSelector("div[class$='login-website-logo-container']>img");
    By headintxt = By.xpath("//h1[normalize-space()='Login']");
    By usernametxt = By.xpath("//label[normalize-space()='USERNAME']");
    By passwordtxt = By.xpath("//label[normalize-space()='PASSWORD']");
    By userName = By.xpath("//input[@id='usernameInput']");
    By passWord = By.xpath("//input[@id='passwordInput']");
    By loginbtn = By.className("login-button");
    By logoutButton = By.xpath("//button[contains(text(),'Logout')]");
    By errorMessageLocator = By.className("error-message");
    By home = By.linkText("Home");
    By accpage= By.xpath("//img[@alt='profile']");

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement findLogo() {
        return driver.findElement(websitelogo);
    }

    public String getHeadintxt() {
        return driver.findElement(headintxt).getText();
    }

    public String getuserNametxt() {
        return driver.findElement(usernametxt).getText();
    }

    public String getpasword() {
        return driver.findElement(passwordtxt).getText();
    }


    public void setUserName(String username) {
        driver.findElement(userName).sendKeys(username);
    }

    public void setpassword(String password) {
        driver.findElement(passWord).sendKeys(password);
    }

    public void clickLoginbtn() {
        driver.findElement(loginbtn).click();
    }

    public void loginToApp(String username, String password) {
        setUserName(username);
        setpassword(password);
        clickLoginbtn();
    }
    public boolean isLoginDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loginbtn )).isDisplayed();
    }

    public void clkHmPg(){
        driver.findElement(home).click();
    }

        public void clickLogout(){
             driver.findElement(logoutButton).click();

            }

    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator)).getText();
    }

    public void setAccPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(accpage)).click();
    }


}






