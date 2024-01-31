package utils;

import pages.HomePage;
import pages.header_section.HotelsTab;
import pages.header_section.TabBar;
import pages.hotels.*;

import java.io.PrintWriter;

public class Pages {

	private HomePage homePage;

	private TabBar tabBar;

	private HotelsTab hotelsTab;

	private HotelsFilteringPage hotelsFilteringPage;

	private HotelsDetailsPage hotelsDetailsPage;

	private HotelsBookingPage hotelsBookingPage;

	private HotelsCheckoutPage hotelsCheckoutPage;

	private HotelsConfirmationPage hotelsConfirmationPage;

	public Pages() {
		homePage = new HomePage();
		tabBar = new TabBar();
		hotelsTab = new HotelsTab();
		hotelsFilteringPage = new HotelsFilteringPage();
		hotelsDetailsPage = new HotelsDetailsPage();
		hotelsBookingPage = new HotelsBookingPage();
		hotelsCheckoutPage = new HotelsCheckoutPage();
		hotelsConfirmationPage = new HotelsConfirmationPage();
	}

	public HomePage getHomePage() {
		return homePage;
	}

	public TabBar getTabBar() {
		return tabBar;
	}

	public HotelsTab getHotelsTab() {
		return hotelsTab;
	}

	public HotelsFilteringPage getHotelsFilteringPage() {
		return hotelsFilteringPage;
	}

	public HotelsDetailsPage getHotelsDetailsPage() {
		return hotelsDetailsPage;
	}

	public HotelsBookingPage getHotelsBookingPage() {
		return hotelsBookingPage;
	}

	public HotelsCheckoutPage getHotelsCheckoutPage() {
		return hotelsCheckoutPage;
	}

	public HotelsConfirmationPage getHotelsConfirmationPage() {
		return hotelsConfirmationPage;
	}
}
