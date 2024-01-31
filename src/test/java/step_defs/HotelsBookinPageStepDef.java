package step_defs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.BrowserUtils;

import static org.assertj.core.api.BDDAssertions.then;

public class HotelsBookinPageStepDef extends BaseStep{

    Logger logger = LogManager.getLogger(HotelsBookinPageStepDef.class);

    @Then("The displayed hotel name should be same with specified hotel name")
    public void theDisplayedHotelNameShouldBeSameWithSpecifiedHotelName() {
        then(HotelsDetailsPageStepDefs.hotelName).isEqualTo(PAGES.getHotelsBookingPage().getHotelTitle());
    }

    @And("The displayed city of hotel should be {string}")
    public void theDisplayedCityOfHotelShouldBe(String city) {
        then(PAGES.getHotelsBookingPage().isSelectedCityNameMatchedDisplayedCity(city)).isTrue();
    }

    @And("The user selects {string}")
    public void theUserSelects(String option) {
        PAGES.getHotelsBookingPage().selectYesOrNo(option);
        logger.debug("The user selected " + option);
    }

    @And("The user clicks on Next, Final Details button")
    public void theUserClicksOnNextFinalDetailsButton() {
        PAGES.getHotelsBookingPage().clicksOnNextFinalDetailsButton();
        logger.info("The user clicks on Next, Final Details button");
    }


    @And("The user enters first name as {string}")
    public void theUserEntersFirstNameAs(String firstName) {
        PAGES.getHotelsBookingPage().enterUserFirstName(firstName);
        logger.debug("The user entered first name as " + firstName);
    }

    @And("The user enters last name as {string}")
    public void theUserEntersLastNameAs(String lastName) {
        PAGES.getHotelsBookingPage().enterUserLastName(lastName);
        logger.debug("The user entered last name as " + lastName);
    }

    @And("The user enters email adresses as {string}")
    public void theUserEntersEmailAdressesAs(String emailAddress) {
        PAGES.getHotelsBookingPage().enterUserEmailAddress(emailAddress);
        logger.debug("The user entered email adresses as " + emailAddress);
    }

    @And("The user selects booking person as {string}")
    public void theUserSelectsAsBookingPerson(String bookingPerson) {
        PAGES.getHotelsBookingPage().selectBookingPerson(bookingPerson);
        logger.debug("The user selected booking person as " + bookingPerson);
    }

    @And("The user selects arrival time as {string}")
    public void theUserSelectsAsArrivalTime(String arrivalTime) {
        PAGES.getHotelsBookingPage().selectArrivalTime(arrivalTime);
        logger.debug("The user selects arrival time as " + arrivalTime);
    }

    @Then("The user should see that error message as {string}")
    public void theUserShouldSeeThatErrorMessageAs(String errorMessage) {
        BrowserUtils.scrollUpWithPageUp();
        BrowserUtils.wait(1);
        then(PAGES.getHotelsBookingPage().getErrorMessage()).withFailMessage("Error message does not show up").isEqualTo(errorMessage);
        logger.debug("The user saw that error message as " + errorMessage);
    }

    @And("The displayed total lenght of stay should be the same with length of stay on hotel details page")
    public void theDisplayedTotalLenghtOfStayShouldBe() {
        then(PAGES.getHotelsBookingPage().getLengthOfStay()).isEqualTo(HotelsDetailsPageStepDefs.lengthOfStay);
    }

    @And("The calculated amount based on the number of rooms as {string} should be the same with original price")
    public void theCalculatedAmountBasedOnTheNumberOfRoomsShouldBeTheSameWithOriginalPrice(String numberOfRooms) {
        then(PAGES.getHotelsBookingPage().getOriginalPrice()).
                isEqualTo(Integer.parseInt(numberOfRooms) * HotelsDetailsPageStepDefs.totalPriceForOneRoom);
    }
}
