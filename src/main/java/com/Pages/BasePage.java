package com.Pages;

import org.openqa.selenium.WebDriver;

public class BasePage{

    private final WebDriver webDriver;
    private AddToCartPage addtocart;
    private AmazonLoginPage amazonLoginPage;
    private AmazonHomePage amazonhomepage;
    
    public BasePage(WebDriver webDriver){

        this.webDriver=webDriver;
    }

	public AmazonLoginPage getAmazonLoginPage() {
		return (amazonLoginPage == null) ? amazonLoginPage = new AmazonLoginPage(webDriver) : amazonLoginPage;
	}

	public AddToCartPage getAddToCartPage() {
		return (addtocart == null) ? addtocart = new AddToCartPage(webDriver) : addtocart;
	}
	public AmazonHomePage getAmazonHomePage() {
		return (amazonhomepage == null) ? amazonhomepage = new AmazonHomePage(webDriver) : amazonhomepage;
	}
		
}

