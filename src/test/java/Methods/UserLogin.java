package Methods;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLogin {
    private WebDriver driver;

    @FindBy(id = "_desktop_user_info")
    private WebElement signInButton;

    @FindBy(name = "email")
    private WebElement loginField;

    @FindBy(name = "password")
    private WebElement passField;

    @FindBy(id = "submit-login")
    private WebElement loginBtn;

    @FindBy(className = "page-header")
    private WebElement header;

    public UserLogin(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginPage(String login, String password) {
        signInButton.click();
        loginField.clear();
        loginField.sendKeys(login);
        passField.clear();
        passField.sendKeys(password);
        loginBtn.click();
        Assert.assertEquals("Your account", header.getText());
    }
}
