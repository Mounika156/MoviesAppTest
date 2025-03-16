
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.AccountPage;
import pages.HeaderSection;
import pages.HomePage;


public class AccountPageTest {

        WebDriver driver;
        LoginPage lp;
        HeaderSection hd;
        WebDriverWait wait;
        AccountPage ap;
        HomePage hp;

        @BeforeMethod
        public void setUp() {
            System.setProperty("webdriver.chrome.driver", "C:\\Automation Testing\\chromedriver-win32\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("https://qamoviesapp.ccbp.tech/login");
            lp = new LoginPage(driver);
            lp.loginToApp("rahul", "rahul@2021");
            ap = new AccountPage(driver);
            hp = new HomePage(driver);

        }
        @Test
        public void testMovieDetailsUIElements() {

            // Navigate to the movie details page
            hp.setClkMov();
            System.out.println(ap.getTitle());

            // Verify UI elements
           Assert.assertTrue(ap.isTimeDisplayed(), "Time not displayed");
            Assert.assertTrue(ap.isAudioDisplayed(), "Audio not displayed");
            Assert.assertTrue(ap.isBudgetDisplayed(),"Budget not displayed");
            Assert.assertTrue(ap.isGenreDisplayed(), "Genre not displayed");
            Assert.assertTrue(ap.isRatingDisplayed(), "Rating not displayed");
        }

        @Test
        public void testLogoutFunctionality() {
            lp.setAccPage();
            lp.clickLogout();
            Assert.assertTrue(lp.isLoginDisplayed(), "Logout failed, login button not displayed");
        }

        @AfterMethod
        public void tearDown() {
            driver.quit();
        }


}
