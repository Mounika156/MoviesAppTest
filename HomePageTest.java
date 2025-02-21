import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import org.testng.Assert;
public class HomePageTest {
    WebDriver driver;
    LoginPage loginpage;
    HomePage homepage;
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Automation Testing\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/login");
        loginpage = new LoginPage(driver);
        homepage = new HomePage(driver);
        loginpage.loginToApp("rahul", "rahul@2021");
    }
    @Test
    public void headingTexts(){
        homepage.findHeadingTexts();
    }
    @Test
    public void playBtn(){
        homepage.isplayBtndisp();
    }
    @Test
    public void moviesDisp(){
        homepage.isMoviesDisp();
    }
    @Test
    public void contactDisp() {
        String contactElement = (homepage.getContactText());
        System.out.println("Contact Us Element Found: " + contactElement);  // Debugging step
        Assert.assertEquals(contactElement, "Contact Us","Not Matched");

    }

}
