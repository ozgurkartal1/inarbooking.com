package step_defs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.Hotel;

import static org.assertj.core.api.BDDAssertions.then;

public class HotelsFilteringPageStepDefs extends BaseStep{

    public static Hotel hotel;

    Logger logger = LogManager.getLogger(HotelsFilteringPageStepDefs.class);

    @Then("The {string} title is displayed")
    public void theTitleIsDisplayed(String title) {
        then(PAGES.getHotelsFilteringPage().getTitleOfPage()).isEqualTo(title);
    }

    @And("The user should see that the hotels's locations are {string}")
    public void theUserShouldSeeThatTheHotelsSLocationsAre(String city) {
        then(PAGES.getHotelsFilteringPage().isSpecifiedCityInList(city)).isTrue();
    }

    @And("The user enters destination field city name as {string}")
    public void theUserEntersDestinationFieldAs(String city) {
        PAGES.getHotelsFilteringPage().enteredCity(city);
        logger.debug("The user enters destinaton field city name as " + city);
    }

    @And("The user set the min price as {string}")
    public void theUserSetTheMinPriceAs(String minPrice) {
        PAGES.getHotelsFilteringPage().setMinPrice(Integer.parseInt(minPrice));
        logger.debug("The user set the min price as " + minPrice);
    }

    @And("The user set the max price as {string}")
    public void theUserSetTheMaxPriceAs(String maxPrice) {
        PAGES.getHotelsFilteringPage().setMaxPrice(Integer.parseInt(maxPrice));
        logger.debug("The user set the max price as " + maxPrice);
    }
    @And("The user clikcs on search button")
    public void theUserClikcsOnSearchHotelButton() {
        PAGES.getHotelsFilteringPage().clicksOnSearchButton();
        logger.info("The user clicks on search button");
    }

    @Then("Verify that all prices of filtering hotels are between {string} and {string}")
    public void verifyThatAllPricesOfHotelsAreBetweenAnd(String minPrice, String maxPrice) {
       then(PAGES.getHotelsFilteringPage().arePricesOfHotelsBetweenMinAndMax(Integer.parseInt(minPrice), Integer.parseInt(maxPrice))).isTrue();
    }

    @When("The user selects feature as {string} from bar on the left side")
    public void theUserSelectFeatureAsFromBarOnTheLeftSide(String feature) {
        PAGES.getHotelsFilteringPage().selectFeature(feature);
        logger.debug("The user select feature as " + feature + " from bar on the left side");
    }

    @And("The user clicks on see availability button for highest rated hotel")
    public void theUserClicksOnSeeAvailabilityButtonForHighRatedHotel() {
        hotel = PAGES.getHotelsFilteringPage().clickOnHighestRatedHotel();
        logger.info("The user clicks on see availability button for highest rated hotel");
    }

    @And("The user clicks on see availability button for #{int} hotel is displayed")
    public void theUserClicksOnSeeAvailabilityButtonForHotelIsDisplayed(int numberOfHotel) {
        hotel = PAGES.getHotelsFilteringPage().clickOnHotelsSeeAvailabiliyButton(numberOfHotel);
        logger.debug("The use clicks on see availability button for " + numberOfHotel + ". hotel is displayed");
    }

    @And("The user set the number of rooms as {string}")
    public void theUserSetTheNumberOfRoomsAs(String numberOfRooms) {

    }
}
