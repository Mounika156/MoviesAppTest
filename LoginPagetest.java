import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;


public class LoginPagetest {
        WebDriver driver;
        LoginPage loginpage;

        @BeforeMethod
        public void setUp() {
            System.setProperty("webdriver.chrome.driver", "C:\\Automation Testing\\chromedriver-win32\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("https://qamoviesapp.ccbp.tech/login");
            loginpage = new LoginPage(driver);
        }

        @AfterMethod
        public void tearDown() {
            driver.quit();
        }

        @Test(priority = 1)
        public void testLogopg() {

            Assert.assertTrue(loginpage.findLogo().isDisplayed(), "App img not Displayed");
        }

        @Test(priority = 2)
        public void testheadlogin() {
            String acttxt = loginpage.getHeadintxt();
            String exttxt = "Login";
            Assert.assertEquals(exttxt, acttxt, "not matchhed");
        }

        @Test(priority = 4)
        public void testunlogin() {
            String acttxt = loginpage.getuserNametxt();
            System.out.println(acttxt);
            String exttxt = "USERNAME";
            Assert.assertEquals(exttxt, acttxt, "not matched");
        }

        @Test(priority = 5)
        public void testpwlogin() {
            String acttxt = loginpage.getpasword();
            String exttxt = "PASSWORD";
            Assert.assertEquals(exttxt, acttxt, "not matchhed");
        }

        @Test(priority = 6)
        public void logIn() {
            loginpage.loginToApp("rahul", "rahul@2021");

            loginpage.clickLoginbtn();
        }

    }







