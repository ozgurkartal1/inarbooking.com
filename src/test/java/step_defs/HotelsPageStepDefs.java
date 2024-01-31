package step_defs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.BrowserUtils;

import static org.assertj.core.api.BDDAssertions.then;

public class HotelsPageStepDefs extends BaseStep {

	Logger logger = LogManager.getLogger(HotelsPageStepDefs.class);

	@When("The user clicks on the {string} tab")
	public void the_user_clicks_on_the_stays_tab(String tabName) {
		PAGES.getTabBar().clickOnTab(tabName);
		logger.debug("The user clicks on Stays tab");
	}

	@Then("The user should see search hotels button")
	public void the_user_should_see_search_hotels_button() {
		then(PAGES.getHotelsTab().isVisibleSearchHotelButton()).withFailMessage("Search Hotels button is not displayed")
				.isTrue();
	}

	@When("The user enters {string}")
	public void the_user_enters(String location) {
		PAGES.getHotelsTab().enteredLocation(location);
		logger.debug("The user enters location as " + location);
	}
	@And("The user selects check-in date as {string} of next month and check-out date as {string}")
	public void the_user_selects_check_in_date_as_of_next_month_and_check_out_date_as(String check_in, String check_out) {
		PAGES.getHotelsTab().clickOnDateField();
		PAGES.getHotelsTab().clickOnNextButton();
		PAGES.getHotelsTab().selectDate(Integer.parseInt(check_in));
		PAGES.getHotelsTab().selectDate(Integer.parseInt(check_out));
		logger.debug("The user selects check-in date as " + check_in + " of next month check-out date as " + check_out);
	}
	@And("The user selects number of adults as {string} and number of children {string} number of rooms {string}")
	public void the_user_selects_number_of_adults_as_and_number_of_children_number_of_rooms(String numOfAdults, String numOfChildren, String numOfRooms) {
		PAGES.getHotelsTab().clickOnSelectionsField();
		PAGES.getHotelsTab().setNumberOfAdults(Integer.parseInt(numOfAdults));
		PAGES.getHotelsTab().setNumberOfChildren(Integer.parseInt(numOfChildren));
		PAGES.getHotelsTab().setNumberOfRooms(Integer.parseInt(numOfRooms));
		logger.debug("The user selects number of adults as " + numOfAdults);
		logger.debug("The user selects number of children as " + numOfChildren);
		logger.debug("The user selects number of rooms as " + numOfRooms);
	}
	@And("The user clicks on search hotel button")
	public void the_user_clicks_on_search_hotel_button() {
		PAGES.getHotelsTab().clickOnSearchHotelsButton();
		logger.info("The user clicks on search hotels button");
	}

	@Then("The user should be on the hotel's home page")
	public void theUserShouldBeOnTheHotelSHomePage() {
		BrowserUtils.wait(1);
		then(PAGES.getHotelsTab().getStaysHeader()).withFailMessage("The user is not on the Stays Home Page").isTrue();
	}
}
