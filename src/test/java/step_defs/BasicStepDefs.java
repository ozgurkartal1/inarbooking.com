package step_defs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BasicStepDefs extends BaseStep {

	Logger logger = LogManager.getLogger(BasicStepDefs.class);

	@Given("The user on the Inar Academy Home page")
	public void the_user_on_the_inar_academy_home_page() {
		DRIVER.get("https://InarAcademy:Fk160621.@test.inar-academy.com");
		logger.info("The user on the Inar Academy Home Page");
	}

	@And("The user clicks on the booking link")
	public void the_user_clicks_on_the_booking_link() {
		PAGES.getHomePage().clickOnBookingTab();
		logger.info("The user clicks on the booking link");
	}

}
