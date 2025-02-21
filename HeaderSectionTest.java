import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.HomePage;
import pages.HeaderSection;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HeaderSectionTest {
    WebDriver driver;
    LoginPage loginpage;
    HomePage homepage;
    HeaderSection headsec;
    WebDriverWait wait;
    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Automation Testing\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/login");
        loginpage = new LoginPage(driver);
        homepage = new HomePage(driver);
        headsec = new HeaderSection(driver);
        loginpage.loginToApp("rahul", "rahul@2021");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    /*@AfterMethod
    public void tearDown(){
        driver.quit();
    }*/
    @Test(priority = 1)
    public void logoimg(){
        Assert.assertTrue(headsec.findWebSiteLogo().isDisplayed(), "Logo is not disp");

    }


    @Test(priority = 3)
    public void popLnk(){
        headsec.findpopLnk();
       // Assert.assertTrue(driver.getCurrentUrl().contains("home"), "❌ Navigation to Home page failed!");

       // Assert.assertTrue(headsec.getCurrentURL().contains("popular"), "Navigation to Popular page failed");

    }
    @Test(priority= 4)
    public void acclink(){
        headsec.findaccLnk();

        String expurl="https://qamoviesapp.ccbp.tech/account";
        String acturl= driver.getCurrentUrl();
        Assert.assertEquals(expurl,acturl,"Not match");
    }
    @Test(priority =5)
    public  void testnavigationhm(){
        WebElement link = headsec.findhomeLnk();
        link.click();
        //Assert.assertTrue(driver.getCurrentUrl(), "Not navigated to Home page");

       String exturl= "https://qamoviesapp.ccbp.tech/";

        String acturl = driver.getCurrentUrl();

        System.out.println(acturl);

      Assert.assertEquals(exturl, (acturl), "Not displayed");
    }
    @Test(priority = 6)
    public void Navigationpop(){
        headsec.findpopLnk();
        String exp= "Popular";
        String act = headsec.ispopdisp();

        Assert.assertEquals(exp, act, "Not displayed");
    }
    @Test(priority =7)
    public void  testacclink() {
        headsec.findaccLnk();
        String exp = "Account";
         String act= headsec.isaccdisp();
        System.out.println(act);
        Assert.assertEquals(exp,act,"not matched");


    }
}
