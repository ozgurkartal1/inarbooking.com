package step_defs;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;
import utils.Pages;

public abstract class BaseStep {

	protected final WebDriver DRIVER;

	protected static Pages PAGES;
	
	public BaseStep(){
		DRIVER = DriverManager.getWebDriver();
		PAGES = new Pages();
	}

	
}
