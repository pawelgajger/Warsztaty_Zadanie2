package Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UserAddAddress {

    private WebDriver driver;

    @FindBy(name = "address1")
    private WebElement addAddress;

    @FindBy(name = "postcode")
    private WebElement addZip;

    @FindBy(css = "input[name='city']")
    private WebElement addCity;

    @FindBy(name = "phone")
    private WebElement addPhone;

    public void selectCountry() {
        Select dropdown = new Select(driver.findElement(By.name("id_country")));
        dropdown.selectByVisibleText("United Kingdom");
    }

    public UserAddAddress(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void addAddress(String address, String zip, String city, String phone) {
        addAddress.click();
        addAddress.clear();
        addAddress.sendKeys(address);
        addZip.click();
        addZip.clear();
        addZip.sendKeys(zip);
        addCity.click();
        addCity.clear();
        addCity.sendKeys(city);
        addPhone.click();
        addPhone.clear();
        addPhone.sendKeys(phone);
    }
}
