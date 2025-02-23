package com.StepDefinitions;

import org.openqa.selenium.WebDriver;

import com.Enums.Context;
import com.PageElements.AddToCartPageElements;
import com.Pages.AddToCartPage;
import com.Utilities.DriverUtilis;
import com.Utilities.ReusableUtils;

import io.cucumber.java.en.*;

public class AddToCartPageDefs {
	AddToCartPage addtocart;
	DriverUtilis driverUtilis;
	public AddToCartPageDefs(DriverUtilis driverUtilis) {
		this.driverUtilis=driverUtilis;
		addtocart=this.driverUtilis.getBasePage().getAddToCartPage();
	}
	@And("Click on the add to cart button")
	public void click_on_the_add_to_cart_button() {
	    addtocart.addToCartProductbtn();
	}

	@And("Click on the cart button")
	public void click_on_the_cart_button() {
	    addtocart.addToCart();
	}

	@Then("Validate {string} is added to shopping cart page")
	public void validate_is_added_to_shopping_cart_page(String strMobile) {
		driverUtilis.getScenarioContext().setContext(Context.PRICE, strMobile);
	   addtocart.validatingProduct(strMobile);
	}

	@And("Click on delete button from shopping cart page")
	public void click_on_delete_button_from_shopping_cart_page() {
	    addtocart.deleteProduct();
	}

	@And("Validate {string} page is displayed")
	public void validate_page_is_displayed(String cartpage) {
		String strPrice=driverUtilis.getScenarioContext().getContext(Context.PRICE).toString();
		addtocart.validatingCart(cartpage);
	    
	}
}
