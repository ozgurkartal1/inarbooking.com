package pages.hotels;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HotelsConfirmationPage extends HotelsCheckoutPage{

    @FindBy(css = "h1.fs-3:nth-child(1)")
    private WebElement confirmationMessage;

    @FindBy(css = ".btn-danger")
    private WebElement closeButton;

    public String getConfirmationMessage(){
        return confirmationMessage.getText();
    }

    public void clicksOnCloseButton(){
        closeButton.click();
    }
}
