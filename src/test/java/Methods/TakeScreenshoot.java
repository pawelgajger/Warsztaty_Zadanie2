package Methods;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class TakeScreenshoot {
    private WebDriver driver;

    public TakeScreenshoot(WebDriver driver){
        this.driver = driver;
    }

    public void takeCaptureScreenshot() throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(src, new File("C:\\Kurs\\Warsztaty_Zadanie2\\screenshot.png"));
    }
}
