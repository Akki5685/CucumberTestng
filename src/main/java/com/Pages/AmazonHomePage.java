package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.PageElements.AmazonHomePageElements;
import com.PageElements.AmazonLoginPageElements;
import com.Utilities.ReusableUtils;

public class AmazonHomePage extends AmazonHomePageElements {
	private final WebDriver webDriver;
	private ReusableUtils reusableUtils;
	public AmazonHomePage(WebDriver webDriver) {
		this.webDriver=webDriver;
		reusableUtils=new ReusableUtils(webDriver);
		PageFactory.initElements(webDriver, this);
	}
//	public String cartpricebefore1;
    public void clkOnHomebtn() {
    	reusableUtils.clickElement(homebutton);
    	for(int i=0;i<bestsellerbtn.size();i++) {
    		if(bestsellerbtn.get(i).getText().contains("Best Sellers")) {
    			//bestsellerbtn.get(i).c
    			reusableUtils.clickElement(bestsellerbtn.get(i));
    			break;
    		}
    	}
    	
    }
    public void validatingBestSellerPage(String strBestSeller) {
    	String expectedStr=reusableUtils.getElemText(bestSellerstext);
    	reusableUtils.validateTextEqual(expectedStr, strBestSeller, "bestSeller page is not displayed");
    }
    public void selectElectronicsbtn() {
    	reusableUtils.clickElement(electronicsbtn);
    }
    public void validatingElectronicspage(String elepage) {
    	String expectedStr=reusableUtils.getElemText(electronicsText);
    	reusableUtils.validateTextEqual(expectedStr, elepage, "electronics page is not displayed");
    }
    public String selectingProduct() {
    	String product="boAt Bassheads 100 in Ear Wired Earphones with Mic(Black)";
    	for(int i=0;i<productslist.size();i++) {
    		if(productslist.get(i).getText().contains(product)) {
    			reusableUtils.clickElement(productslist.get(i));
    			break;
    		}
    	}
    	String cartpricebefore=reusableUtils.getElemText(beforecartprice);
    	cartpricebefore=cartpricebefore.replaceAll("[^\\d.]", "");
    	return cartpricebefore;
    	
    }
    public void validatingCartPage() {
    	String check="Added to Cart";
    	String expectedText=reusableUtils.getElemText(addedtocartText);
    	boolean value=false;
    	if(expectedText.contains(check)) {
    		value=true;
    	}
    	reusableUtils.validateAssertTrue(value, "product is not added to cart");
    	//reusableUtils.validateTextEqual(expectedText,check,);
    }
    public void clkCartbtn() {
    	reusableUtils.clickElement(cartbtn);
    }

	public void validatingPrice(String strCartPrice) {
  	        String cartpriceafter=reusableUtils.getElemText(finalcartprice);
  	        String finalprice=cartpriceafter.replaceAll("[^\\d.]", "");
  	        String beforeprice=strCartPrice+".00";
  	        reusableUtils.validateTextEqual(beforeprice, finalprice,"cart price is not mactched ");
            		
	}
}
