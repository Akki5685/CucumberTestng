package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.PageElements.AmazonLoginPageElements;
import com.Utilities.ReusableUtils;

public class AmazonLoginPage extends AmazonLoginPageElements {
	private final WebDriver webDriver;
	private ReusableUtils reusableUtils;
	//public static String expectedTitle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
	public AmazonLoginPage(WebDriver webDriver) {
		this.webDriver=webDriver;
		webDriver.navigate().refresh();
		reusableUtils=new ReusableUtils(webDriver);
		PageFactory.initElements(webDriver, this);
	}
	public void launchAmazon(String strAppurl) {
		reusableUtils.gotoURL(strAppurl);
		webDriver.navigate().refresh();
	}
	public void searchingProduct(String searchMobile) {
		reusableUtils.sendText(searchbar, searchMobile);
		
	}
	public void searchItembar() {
		reusableUtils.clickElement(searchItem);
	}
	public void clkOnsearchedMobile() {
		//String product=reusableUtils.getElemText(selectedMobile);
		//reusableUtils.clickElement(selectedMobile);
		String product="Samsung Galaxy S21 FE 5G (Navy, 8GB RAM, 256GB Storage)";
		for(int i=0;i<selectedMobile.size();i++) {
		     if(selectedMobile.get(i).getText().contains(product)) {
		    	 reusableUtils.clickElement(selectedMobile.get(i));
		    	 break;
		     }
		}
		reusableUtils.switchToWindowUsingIndex(1);
		reusableUtils.waitUntilPageReadyState();
	}
//	public void windowSwith() {
//		
//		
//	}
	public void movetoElement() {
		reusableUtils.actionMovetoElement(zoomin);
		reusableUtils.waitUntilPageReadyState();
	}
	public void zoominproduct() {
		reusableUtils.validateElementDispalyed(zoomInproduct);
	}

}
