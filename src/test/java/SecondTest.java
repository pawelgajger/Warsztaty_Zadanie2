import Methods.TakeScreenshoot;
import Methods.UserAddToCart;
import Methods.UserLogin;
import Methods.UserOrder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SecondTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/");
    }

    @Test
    public void testLoginWithProperCredentials() throws IOException {
        UserLogin userLogin = new UserLogin(driver);
        userLogin.loginPage("jannowak@player.mailinator.com", "qwerty123!@#");
        UserAddToCart userAddToCart = new UserAddToCart(driver);
        userAddToCart.addToCart("XL", "5");
        UserOrder userOrder = new UserOrder(driver);
        userOrder.proceedOrder();
        TakeScreenshoot takeScreenshoot = new TakeScreenshoot(driver);
        takeScreenshoot.takeCaptureScreenshot();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

