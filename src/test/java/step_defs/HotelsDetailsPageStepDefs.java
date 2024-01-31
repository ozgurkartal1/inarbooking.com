package step_defs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.BrowserUtils;


import static org.assertj.core.api.BDDAssertions.then;

public class HotelsDetailsPageStepDefs extends BaseStep {

    Logger logger = LogManager.getLogger(HotelsDetailsPageStepDefs.class);

    public static String hotelName;
    public static int totalPriceForOneRoom;
    public static String lengthOfStay;

    @Then("The user should see that {string} is among the hotel's features")
    public void theUserShouldSeeThatIsAmongTheHotelSFeatures(String feature) {
        then(PAGES.getHotelsDetailsPage().isSelectedFeatureDisplayedOnDetailPage(feature)).isTrue();
    }

    @Then("The selected hotel's name should be the same with shown name on Hotel Detail Page")
    public void theSelectedHotelSNameShouldBeTheSameWithShownNameOnHotelDetailPage() {
        then(PAGES.getHotelsDetailsPage().getHotelTitle()).isEqualTo(HotelsFilteringPageStepDefs.hotel.nameOfHotel);
        logger.info("The selected hotel's name is the same with shown name on Hotel Detail Page");
    }

    @And("The selected hotel's price should be the same amount with shown price on Hotel Detail Page")
    public void theSelectedHotelSPriceShouldBeTheSameAmountWithShownPriceOnHotelDetailPage() {
        then(HotelsFilteringPageStepDefs.hotel.priceOfHotel).isEqualTo(PAGES.getHotelsDetailsPage().getPriceOfHotel());
        logger.info("The selected hotel's price is the same with shown price on Hotel Detail Page");
    }

    @And("The user clicks on Reserve or Book Now! button")
    public void theUserClicksOnReserveOrBookNowButton() {
        BrowserUtils.scrollUpWithPageUp();
        BrowserUtils.wait(1);

        totalPriceForOneRoom = PAGES.getHotelsDetailsPage().getTotalPriceForOneRoom();
        lengthOfStay = PAGES.getHotelsDetailsPage().getTotalLengthOfStay();
        hotelName = PAGES.getHotelsDetailsPage().getHotelTitle();

        PAGES.getHotelsDetailsPage().clickOnBookButton();
        logger.info("The user clicked on Reserve or Book Now! button");
        BrowserUtils.wait(1);
    }


}
