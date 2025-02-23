package com.StepDefinitions;

import com.Enums.Context;
import com.PageElements.AmazonHomePageElements;
import com.Pages.AddToCartPage;
import com.Pages.AmazonHomePage;
import com.Utilities.DriverUtilis;

import io.cucumber.java.en.*;

public class BestSellerPageDefs {
	
	AmazonHomePage amazonhomepage;
	DriverUtilis driverUtilis;
	public BestSellerPageDefs(DriverUtilis driverUtilis) {
		this.driverUtilis=driverUtilis;
		amazonhomepage=this.driverUtilis.getBasePage().getAmazonHomePage();
	}
	
	@And("Navigate to best seller")
	public void navigate_to_best_seller() {
		amazonhomepage.clkOnHomebtn();
	}

	@And("validate {string} page is displayed")
	public void validate_page_is_displayed(String strBestSeller) {
	   amazonhomepage.validatingBestSellerPage(strBestSeller);
	}

	@When("Click on the Electronics")
	public void click_on_the_electronics() {
	   amazonhomepage.selectElectronicsbtn();
	}

	@And("validate the {string} page is displayed")
	public void validate_the_page_is_displayed(String elepage) {
	    amazonhomepage.validatingElectronicspage(elepage);
	}

	@And("Select any product in the electronics page")
	public void select_any_product_in_the_electronics_page() {
		driverUtilis.getScenarioContext().setContext(Context.PRICE,amazonhomepage.selectingProduct());
		
	   
	}

//	@And("Validate product is displayed in the cart page")
//	public void validate_product_is_displayed_in_the_cart_page() {
//	  amazonhomepage.validatingCartPage();
//	}
	@And("Click on the cart page button")
	public void click_on_the_cart_page_button() {
	   amazonhomepage.clkCartbtn();
	}
	@Then("Validate price of the product")
	public void validate_price_of_the_product() {
		String strPrice=driverUtilis.getScenarioContext().getContext(Context.PRICE).toString();
		System.out.println("After price "+strPrice);
	   amazonhomepage.validatingPrice(strPrice);
	}

}
