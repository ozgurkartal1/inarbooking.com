package pages.hotels;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class HotelsBookingPage extends BasePage {

    @FindBy(className = "hotel-title")
    private WebElement hotelTitle;

    @FindBy(className = "hotel-address")
    private WebElement hotelAdress;

    @FindBy(css = ".justify-content-between.fs-4 > span:nth-child(2)")
    private WebElement calculatedOriginalPrice;

    @FindBy(css = ".ms-2.fw-normal")
    private List<WebElement> yesOrNoOptions;

    @FindBy(className = "form-control")
    private List<WebElement> userInformationTextFields;

    @FindBy(xpath = "//input[@class='me-3 fs-4']/../span")
    private List<WebElement> bookingPersonOptions;

    @FindBy(css = ".total-stay > div")
    private WebElement lengthOfStay;

    @FindBy(className = "form-select")
    private WebElement arrivalSelection;

    @FindBy(className = "btn")
    private WebElement nextFinalDetailsButton;

    @FindBy(className = "invalid-feedback")
    private List<WebElement> errorMessages;

    public String getHotelTitle(){
        return hotelTitle.getText();
    }

    public String getHotelAdress(){
        return hotelAdress.getText();
    }

    public boolean isSelectedCityNameMatchedDisplayedCity(String city) {
        return getHotelAdress().contains(city);
    }

    public int getOriginalPrice(){
        String[] array = calculatedOriginalPrice.getText().split("[=.]");
        return Integer.parseInt(array[1].substring(2));
    }

    public void selectYesOrNo(String option){
        List<String> nameOfOptions = yesOrNoOptions.stream().map(WebElement::getText).toList();
        yesOrNoOptions.get(nameOfOptions.indexOf(option)).click();
    }

    public void enterUserFirstName(String firstName){
        userInformationTextFields.get(0).sendKeys(firstName);
    }

    public void enterUserLastName(String lastName){
        userInformationTextFields.get(1).sendKeys(lastName);
    }

    public void enterUserEmailAddress(String emailAddress){
        userInformationTextFields.get(2).sendKeys(emailAddress);
    }

    public void selectBookingPerson(String bookingPerson){
        List<String> valueOfButtons = bookingPersonOptions.stream().map(WebElement::getText).toList();
        bookingPersonOptions.get(valueOfButtons.indexOf(bookingPerson)).click();
    }

    public void selectArrivalTime(String arrivalTime){
        BrowserUtils.scrollDownWithPageDown();
        BrowserUtils.wait(1);

        Select select = new Select(arrivalSelection);
        select.selectByVisibleText(arrivalTime);
    }

    public void clicksOnNextFinalDetailsButton(){
        nextFinalDetailsButton.click();
    }

    public String getErrorMessage(){
        return errorMessages.get(0).getText();
    }

    public String getLengthOfStay(){
        return lengthOfStay.getText();
    }
}
