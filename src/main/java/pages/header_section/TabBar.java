package pages.header_section;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class TabBar extends BasePage {

	@FindBy(className = "headerListItem")
	private List<WebElement> tabs;

	public void clickOnTab(String tabName) {
		List<String> tabNames = tabs.stream().map(WebElement::getText).toList();
		tabs.get(tabNames.indexOf(tabName)).click();
	}

}
