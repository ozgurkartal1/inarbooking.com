package pages.hotels;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class HotelsDetailsPage extends BasePage {

    @FindBy(css = "div.most-popular-facilities > div > span")
    private List<WebElement> mostPopularFacilitiesList;

    @FindBy(css = "div.booking-hotel-properties > div > span:nth-child(2)")
    private List<WebElement> hotelPropertiesList;

    @FindBy(css = "h1.hotelTitle")
    private WebElement hotelTitle;

    @FindBy(css = "span.fs-5")
    private WebElement priceOfHotelsPerNight;

    @FindBy(className = "bookNow")
    private WebElement bookButton;

    @FindBy(css = "h2.mb-0")
    private WebElement priceBasedOnTotalDays;

    public boolean isSelectedFeatureDisplayedOnDetailPage(String feature){
        List<WebElement> mergedList = new ArrayList<>(mostPopularFacilitiesList);
        mergedList.addAll(hotelPropertiesList);
        List<String> merged = mergedList.stream().map(WebElement::getText).toList();
        return merged.stream().anyMatch(merge -> merge.toLowerCase(Locale.ROOT).contains(feature.toLowerCase(Locale.ROOT)));
    }

    public String getHotelTitle(){
        return hotelTitle.getText();
    }

    public int getPriceOfHotel(){
        return Integer.parseInt(priceOfHotelsPerNight.getText().substring(1, 3));
    }

    public void clickOnBookButton(){
        bookButton.click();
    }

    private List<String> getText(){
        return Arrays.asList(priceBasedOnTotalDays.getText().split("\\("));
    }
    public int getTotalPriceForOneRoom(){
        return Integer.parseInt(getText().get(0).substring(1, getText().get(0).length() - 1));
    }

    public String getTotalLengthOfStay(){
        return getText().get(1).substring(0, getText().get(1).length() - 1);
    }
}
