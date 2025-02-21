import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MovieDetails;
import pages.HomePage;
import pages.HeaderSection;

public class MovieDetailsTest {
    WebDriver driver;
    LoginPage lp;
    MovieDetails md;
    HomePage hm;
    HeaderSection hd;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Automation Testing\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/login");
        lp = new LoginPage(driver);
        md = new MovieDetails(driver);
        hm= new HomePage(driver);
        hd= new HeaderSection(driver);
        lp.loginToApp("rahul", "rahul@2021");
    }
    @Test
    public void testMovieDetails(){
        md.getMovieName();
        md.getTitle();
        Assert.assertTrue(md.isMovieTitleDisplayed(),"Not displayed");
        Assert.assertTrue(md.setAudio(),"Not displayed");
        Assert.assertTrue(md.setBudget(),"Not displayed");
        Assert.assertTrue(md.setGenre(),"Not displayed");
        Assert.assertTrue(md.setPlaybtn(),"Not displayed");




    }

}
