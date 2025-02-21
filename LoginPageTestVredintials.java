import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;


public class LoginPageTestVredintials{
    LoginPage loginPage;

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Automation Testing\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/login");
        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    @Test(priority = 1)
    public void testLoginWithEmptyInputs() {
        loginPage.clickLoginbtn();

        String actualErrorMessage = loginPage.getErrorMessage();


        Assert.assertEquals(actualErrorMessage, "*Username or password is invalid",
                "Error text with empty input fields does not match");
    }

    @Test(priority = 2)
    public void testLoginWithEmptyUsername() {
        loginPage.loginToApp("", "rahul@2021");

        String actualErrorMessage = loginPage.getErrorMessage();

        Assert.assertEquals(actualErrorMessage, "*Username or password is invalid",
                "Error text with empty username do not match");
    }

    @Test(priority = 3)
    public void testLoginWithEmptyPassword() {
        loginPage.loginToApp("rahul", "");

        String actualErrorMessage = loginPage.getErrorMessage();

        Assert.assertEquals(actualErrorMessage, "*Username or password is invalid",
                "Error text with empty password do not match");
    }

    @Test(priority = 4)
    public void testLoginWithInvalidCreds() {
        loginPage.loginToApp("rahul", "rahul");

        String actualErrorMessage = loginPage.getErrorMessage();

        Assert.assertEquals(actualErrorMessage, "*username and password didn't match",
                "Error text with invalid password do not match");
    }

    @Test(priority = 5)
    public void testLoginWithValidCreds() {
        loginPage.loginToApp("rahul", "rahul@2021");

        String expectedUrl = "https://qamoviesapp.ccbp.tech/";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        String actualURL = driver.getCurrentUrl();
        if(expectedUrl.equals(actualURL)){
            System.out.println("Matched");
        }
        else{
            System.out.println("URLs not Matched");

        }
        Assert.assertEquals(actualURL, expectedUrl, "URLs do not match");
    }

}
