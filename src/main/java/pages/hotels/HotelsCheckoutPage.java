package pages.hotels;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.List;

public class HotelsCheckoutPage extends BasePage {
    @FindBy(css = "h2.fw-bold.mb-5")
    private WebElement header;

    @FindBy(css = "input.form-control.fs-4")
    private List<WebElement> paymentInformations;

    @FindBy(className = "form-select")
    private WebElement countrySelections;

    @FindBy(css = ".btn.mt-5")
    private WebElement completeBookingButton;

    @FindBy(className = "text-danger")
    private List<WebElement> errorMessages;

   @FindBy(css = "div.mt-3")
   private WebElement mainErrorMessage;

    List<String> errors;

    List<String> errors1;

    public String getHeader(){
        return header.getText();
    }

    public void enterPhoneNumber(String phoneNumber){
        errors = errorMessages.stream().map(WebElement::getText).toList();
        BrowserUtils.scrollUpWithPageUp();
        BrowserUtils.wait(1.2);
        paymentInformations.get(1).sendKeys(phoneNumber);
    }

    public void enterCardholderName(String cardholderName){
        BrowserUtils.scrollDownWithPageDown();
        BrowserUtils.wait(1.2);
        paymentInformations.get(2).sendKeys(cardholderName);
    }

    public void enterCardNumber(String cardNumber){
        errors = errorMessages.stream().map(WebElement::getText).toList();
        paymentInformations.get(3).sendKeys(cardNumber);
    }

    public void enterExpirationDate(String expirationDate){
        paymentInformations.get(4).sendKeys(expirationDate);
    }

    public void enterCVVCode(String cvv){
        paymentInformations.get(5).sendKeys(cvv);
    }

    public void selectCountry(String country){
        Select select = new Select(countrySelections);
        select.selectByVisibleText(country);
    }

    public void clickOnCompleteBookingButton(){
        completeBookingButton.click();
    }
    public boolean isRemovedInvalidPhoneNumberErrorMessage(String errorMessage){
        errors1 = errorMessages.stream().map(WebElement::getText).toList();
        List<String> difference = new ArrayList<>(errors);
        difference.removeAll(errors1);
        return difference.get(0).equals(errorMessage);
    }
    public boolean isRemovedInvalidCardNumberErrorMessage(String errorMessage){
        errors1 = errorMessages.stream().map(WebElement::getText).toList();
        List<String> difference = new ArrayList<>(errors);
        difference.removeAll(errors1);
        return difference.get(0).equals(errorMessage);
    }

    public String getMainErrorMessage(){
        return mainErrorMessage.getText();
    }

}
