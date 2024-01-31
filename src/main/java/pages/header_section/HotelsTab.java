package pages.header_section;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.BrowserUtils;

import java.util.List;

public class HotelsTab extends BasePage {

	@FindBy(css = ".headerSearchItem > button")
	private WebElement searchHotelsButton;

	@FindBy(className = "headerSearchInput")
	private WebElement locationTextField;

	@FindBy(xpath = "//div[@class='headerSearch']/div[2]")
	private WebElement dateField;

	@FindBy(xpath = "//div[@class='headerSearch']/div[3]")
	private WebElement selectionsField;

	@FindBy(className = "rdrNextPrevButton")
	private List<WebElement> prevNextButtons;

	@FindBy(css = ".rdrDays > button")
	private List<WebElement> days;

	@FindBy(css = ".optionCounterNumber")
	private List<WebElement> numberOfSelections;

	@FindBy(className = "optionCounterButton")
	private List<WebElement> optionCounterButtons;

	@FindBy(className = "headerTitle")
	private WebElement staysHeader;

	public boolean isVisibleSearchHotelButton() {
		return searchHotelsButton.isDisplayed();
	}

	public void enteredLocation(String location){
		locationTextField.sendKeys(location);
	}

	public void clickOnDateField(){
		dateField.click();
	}

	public void clickOnSelectionsField(){
		selectionsField.click();
	}

	public void clickOnNextButton(){
		prevNextButtons.get(1).click();
	}

	public void clickOnPreviousButton(){
		prevNextButtons.get(0).click();
	}

	public void selectDate(int day){
		List<WebElement> activeDays = days.stream().filter(sa -> !sa.getAttribute("class").contains("rdrDayPassive")).toList();
		activeDays.get(day - 1).click();
	}

	public int getNumberOfAdults(){
		return Integer.parseInt(numberOfSelections.get(0).getText());
	}

	public int getNumberOfChildren(){
		return Integer.parseInt(numberOfSelections.get(1).getText());
	}

	public int getNumberOfRooms(){
		return Integer.parseInt(numberOfSelections.get(2).getText());
	}

	public void setNumberOfAdults(int numberOfAdults){
		int defNumberOfAdults = getNumberOfAdults();
		while(defNumberOfAdults < numberOfAdults){
			optionCounterButtons.get(1).click();
			defNumberOfAdults++;
		}
	}

	public void setNumberOfChildren(int numberOfChildren){
		int defNumberOfChildren = getNumberOfChildren();
		while(defNumberOfChildren < numberOfChildren){
			optionCounterButtons.get(3).click();
			defNumberOfChildren++;
		}
	}

	public void setNumberOfRooms(int numberOfRooms){
		int defNumberOfRooms = getNumberOfRooms();
		while(defNumberOfRooms < numberOfRooms){
			optionCounterButtons.get(5).click();
			defNumberOfRooms++;
		}
	}

	public void clickOnSearchHotelsButton(){
		searchHotelsButton.click();
	}

	public boolean getStaysHeader(){
		return staysHeader.isDisplayed();
	}

}
