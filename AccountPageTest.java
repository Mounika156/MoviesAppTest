
    import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.openqa.selenium.support.ui.WebDriverWait;
    import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MovieDetails;
import pages.HomePage;
import pages.HeaderSection;

    import java.time.Duration;

    public class AccountPageTest {

        WebDriver driver;
        LoginPage lp;
        MovieDetails md;
        HeaderSection hd;
        WebDriverWait wait;

        @BeforeMethod
        public void setUp() {
            System.setProperty("webdriver.chrome.driver", "C:\\Automation Testing\\chromedriver-win32\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("https://qamoviesapp.ccbp.tech/login");
            lp = new LoginPage(driver);
            lp.loginToApp("rahul", "rahul@2021");
        }


        @Test
        public void testMovieDetailsUIElements() {
            // Navigate to the movie details page
            md.getMovieName();

            // Verify UI elements
            Assert.assertTrue(md.isMovieTitleDisplayed(), "Movie Name not displayed");
            Assert.assertTrue(md.isMovieTitleDisplayed(),"Title not displayed");
            Assert.assertTrue(md.isMovieDurationDisplayed(), "Time not displayed");
            Assert.assertTrue(md.isMovieAudioDisplayed(), "Audio not displayed");
            Assert.assertTrue(md.isMovieBudgetDisplayed(), "Budget not displayed");
            Assert.assertTrue(md.setGenre(), "Genre not displayed");
            Assert.assertTrue(md.setRatingcount(), "Rating not displayed");
        }

        @Test
        public void testLogoutFunctionality() {
            lp.setAccPage();
            lp.clickLogout();
           // Assert.assertTrue(lp.isLoginDisplayed(), "Logout failed, login button not displayed");
        }

        @AfterMethod
        public void tearDown() {
            driver.quit();
        }


}
