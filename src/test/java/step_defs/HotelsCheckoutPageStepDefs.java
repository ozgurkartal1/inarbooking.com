package step_defs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import utils.BrowserUtils;

import static org.assertj.core.api.BDDAssertions.then;

public class HotelsCheckoutPageStepDefs extends BaseStep{

    Logger logger = LogManager.getLogger(HotelsCheckoutPageStepDefs.class);

    @Then("The user should see that the checkout header as {string}")
    public void theUserShouldSeeThatTheCheckoutHeaderAs(String header) {
        BrowserUtils.scrollUpWithPageUp();
        BrowserUtils.wait(1);
        then(PAGES.getHotelsCheckoutPage().getHeader())
                .withFailMessage("The checkour header is not displayed correctly").isEqualTo(header);
    }

    @And("The user selects country as {string}")
    public void theUserSelectsCountryAs(String country) {
        PAGES.getHotelsCheckoutPage().selectCountry(country);
        logger.debug("The user selected country as " + country);
    }

    @And("The user enters phone number as {string}")
    public void theUserEntersPhoneNumberAs(String phoneNumber) {
        PAGES.getHotelsCheckoutPage().enterPhoneNumber(phoneNumber);
        logger.debug("The user entered phone number as " + phoneNumber);
    }

    @And("The user enter card holder's name as {string}")
    public void theUserEnterCardHolderSNameAs(String cardholderName) {
        PAGES.getHotelsCheckoutPage().enterCardholderName(cardholderName);
        logger.debug("The user entered card holder's name as " + cardholderName);
    }

    @And("The user enters card number as {string}")
    public void theUserEntersCardNumberAs(String cardNumber) {
        PAGES.getHotelsCheckoutPage().enterCardNumber(cardNumber);
        logger.debug("The user entered card number as " + cardNumber);
    }

    
    @And("The user enters cvv or cvc code as {string}")
    public void theUserEntersCvvOrCvcCodeAs(String cvv) {
        PAGES.getHotelsCheckoutPage().enterCVVCode(cvv);
        logger.debug("The user entered cvv or cvc code as " + cvv);
    }

    @Then("{string} error message does not show up")
    public void invalidPhoneNumberErrorMessageDoesNotShowUp(String errorMessage) {
        then(PAGES.getHotelsCheckoutPage().isRemovedInvalidPhoneNumberErrorMessage(errorMessage))
                .withFailMessage(errorMessage + "is still visible").isTrue();
    }

    @And("The user clicks on Compelete Booking button")
    public void theUserClicksOnCompeleteBookingButton() {
        PAGES.getHotelsCheckoutPage().clickOnCompleteBookingButton();
        logger.info("The user clicked on Compelete Booking button ");
    }

    @And("The user enters expiration date as {string}")
    public void theUserEntersExpirationDateAs(String expirationDate) {
        PAGES.getHotelsCheckoutPage().enterExpirationDate(expirationDate);
        logger.debug("The user entered expiration date as " + expirationDate);
    }

    @Then("{string} error message disappear")
    public void errorMessageDisappear(String errorMessage) {
        then(PAGES.getHotelsCheckoutPage().isRemovedInvalidCardNumberErrorMessage(errorMessage))
                .withFailMessage(errorMessage + "is still visible").isTrue();
    }

    @Then("The user should see that error message as {string} on checkout page")
    public void theUserShouldSeeThatErrorMessageAsOnCheckoutPage(String errorMessage) {
        try {
            then(PAGES.getHotelsCheckoutPage().getMainErrorMessage()).isEqualTo(errorMessage);
        }catch (NoSuchElementException ex){
            logger.error("white screen of death error");
        }

    }
}
