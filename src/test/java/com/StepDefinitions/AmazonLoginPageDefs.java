package com.StepDefinitions;

import com.DriverManagers.ConfigFileManager;
import com.Pages.AmazonLoginPage;
import com.Utilities.DriverUtilis;

import io.cucumber.java.en.*;

public class AmazonLoginPageDefs {
	AmazonLoginPage amazonLoginPage;
	DriverUtilis driverUtilis;

	public AmazonLoginPageDefs(DriverUtilis driverUtilis) {
		this.driverUtilis = driverUtilis;
		amazonLoginPage = this.driverUtilis.getBasePage().getAmazonLoginPage();

	}
	@Given("Navigate to  Amazon Application")
	public void navigate_to_amazon_application() {
		 String strAppURL=ConfigFileManager.getInstance().getReadConfig().getApplicationURL();
		  amazonLoginPage.launchAmazon(strAppURL);
	}

	@And("Search for {string} from the search field")
	public void search_for_from_the_search_field(String searchMobile) {
	   amazonLoginPage.searchingProduct(searchMobile);
	   amazonLoginPage.searchItembar();
	}

	@When("Click on the searched product")
	public void click_on_the_searched_product() {
	   amazonLoginPage.clkOnsearchedMobile();
	  
	}

	@And("Mouse hover the mouse to the product to zoom in")
	public void mouse_hover_the_mouse_to_the_product_to_zoom_in() {
	    //amazonLoginPage.windowSwith();
	    amazonLoginPage.movetoElement();
	}

	@Then("Validate the selected product is zoom")
	public void validate_the_selected_product_is_zoom() {
	   amazonLoginPage.zoominproduct();
	}
}
