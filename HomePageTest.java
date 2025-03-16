import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import org.testng.Assert;

import java.util.List;

public class HomePageTest {
    WebDriver driver;
    LoginPage loginpage;
    HomePage homepage;
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Automation Testing\\chromedriver-win32\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/login");
        driver.manage().window().maximize();
        loginpage = new LoginPage(driver);
        homepage = new HomePage(driver);
        loginpage.loginToApp("rahul", "rahul@2021");
    }
    @AfterMethod
    public void tearDown(){
            driver.quit();
    }
    @Test
    public void testheadingTexts(){

        List<String> acthead= homepage.getHeadingTexts();
        System.out.println("Heading Texts: "+ acthead);
    }

    @Test
    public void isPlayBtnDisp() {
        homepage.setClkMov();
       Assert.assertTrue(homepage.isplayBtndisp(),"Play Button not displayed");

    }

    @Test
    public void moviesDisp(){
        homepage.isMoviesDisp();
    }
    @Test
    public void contactDisp() {
        String contactElement = (homepage.getContactText());
        System.out.println("Contact Us Element Found: " + contactElement);  // Debugging step
        Assert.assertEquals(contactElement, "Contact Us","Contact Us Not Matched");

    }

}
