package step_defs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.DriverManager;

public class Hooks extends BaseStep {

	Logger logger = LogManager.getLogger(Hooks.class);

	@Before
	public void setUpTestEnvironment() {
		DriverManager.getWebDriver("chrome");
		logger.info("TEST STARTED!!");
	}

	@After
	public void tearDownTestEnvironment() {
		DriverManager.closeDriver();
		logger.info("TEST FINISHED!!");
	}

}
