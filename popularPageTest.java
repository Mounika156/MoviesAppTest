import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;


import java.util.ArrayList;
import java.util.List;

import pages.HomePage;
import pages.LoginPage;
import pages.PopularPage;
public class popularPageTest {
    WebDriver driver;
    WebDriverWait wait;
    PopularPage pp;
    LoginPage lp;
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Automation Testing\\chromedriver-win32\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/login");
        lp = new LoginPage(driver);
        pp= new PopularPage(driver);
        lp.loginToApp("rahul","rahul@2021");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void listOfMovies() {
            List<String> movietitles = pp.listmov();
            System.out.println(movietitles.size());
            if(movietitles.isEmpty()){
                System.out.println("Empty");
            }
            else{
                System.out.println("Not Empty");

            }
            for(String titles: movietitles) {
                System.out.println(titles);
            }

    }


}
