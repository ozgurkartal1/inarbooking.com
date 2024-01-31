package pages.hotels;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.Hotel;
import utils.BrowserUtils;
import java.util.Collections;
import java.util.List;

public class HotelsFilteringPage extends BasePage {
    @FindBy(css = ".listWrapper > h1")
    private WebElement title;

    @FindBy(css = ".fs-5.m-0")
    private List<WebElement> locationsOfHotels;

    @FindBy(css = ".search-btn-flight > button")
    private WebElement searchButton;

    @FindBy(xpath = "//label[text() = 'Destination']/../input")
    private WebElement destinationTextField;

    @FindBy(className = "siPrice")
    private List<WebElement> pricesOfHotels;

    @FindBy(xpath = "//div[@class='lsCheckboxItem']/span")
    private List<WebElement> features;

    @FindBy(xpath= "//div[@class='siRating']/button")
    private List<WebElement> ratingsOfHotels;

    @FindBy(className = "siCheckButton")
    private List<WebElement> seeAvailabilityButtons;

    public String getTitleOfPage(){
        return title.getText();
    }

    public boolean isSpecifiedCityInList(String city){
        List<String> locationOfHotels = locationsOfHotels.stream().map(WebElement::getText).toList();
        return locationOfHotels.stream().allMatch(locationOfHotel -> locationOfHotel.contains(city));
    }

    public void setMinPrice(int value){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementsByClassName('lsOptionInput')[0].value = " + value);
    }

    public void setMaxPrice(int value){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementsByClassName('lsOptionInput')[1].value = " + value);
    }

    public void clicksOnSearchButton(){
        actions.moveToElement(searchButton).perform();
        searchButton.click();
    }

    public void enteredCity(String city){
        destinationTextField.sendKeys(city);
    }

    public boolean arePricesOfHotelsBetweenMinAndMax(int min, int max){
        List<Integer> prices = pricesOfHotels.stream().map(price -> Integer.parseInt(price.getText().substring(1))).toList();
        return prices.stream().allMatch(price -> price >= min && price <= max);
    }

    public void selectFeature(String feature){
        List<String> namesOfFeature = features.stream().map(WebElement::getText).toList();
        actions.moveToElement(features.get(namesOfFeature.indexOf(feature))).perform();
        features.get(namesOfFeature.indexOf(feature)).findElement(By.xpath("../input")).click();
        BrowserUtils.wait(1);
    }

    public Hotel clickOnHighestRatedHotel(){
        BrowserUtils.scrollUpWithPageUp();
        BrowserUtils.wait(2);

        List<Double> list = ratingsOfHotels.stream().map(rate -> Double.parseDouble(rate.getText())).toList();
        double max = Collections.max(list);
        String nameOfHotel = ratingsOfHotels.get(list.indexOf(max)).findElement(By.xpath("../../../div[1]/h1")).getText();
        actions.moveToElement(ratingsOfHotels.get(list.indexOf(max)).findElement(By.xpath("../../div[2]/button"))).perform();
        ratingsOfHotels.get(list.indexOf(max)).findElement(By.xpath("../../div[2]/button")).click();

        return new Hotel(50, nameOfHotel);
    }

    public Hotel clickOnHotelsSeeAvailabiliyButton(int numberOfHotel){
        BrowserUtils.scrollUpWithPageUp();
        BrowserUtils.wait(2);

        int priceOfHotel = Integer.parseInt(seeAvailabilityButtons.get(numberOfHotel - 1).findElement(By.xpath("../span[1]")).getText().substring(1));
        String nameOfHotel = seeAvailabilityButtons.get(numberOfHotel - 1).findElement(By.xpath("../../../div[1]/h1")).getText();

        seeAvailabilityButtons.get(numberOfHotel - 1).click();

        return new Hotel(priceOfHotel, nameOfHotel);
    }

}

