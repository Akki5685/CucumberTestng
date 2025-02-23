package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.Enums.Context;
import com.PageElements.AddToCartPageElements;
import com.Utilities.ReusableUtils;
import com.Utilities.ScenarioContext;

public class AddToCartPage extends AddToCartPageElements {
	//ScenarioContext scenarioContext=new ScenarioContext();
    private final WebDriver webDriver;
    private ReusableUtils reusableUtils;
    public AddToCartPage(WebDriver webDriver){
    	this.webDriver=webDriver;
    	reusableUtils=new ReusableUtils(webDriver);
    	PageFactory.initElements(webDriver, this);	
    }
    
    public void addToCartProductbtn()  {
    	reusableUtils.clickElement(addtoCartbtn);
    }
    
    public void addToCart() {
    	reusableUtils.clickElement(addtoCart);
    }
    
    public void validatingProduct(String StrMobileName) {
    	reusableUtils.waittime();
    	String strExpected=reusableUtils.getElemText(productText);
    	reusableUtils.waittime();
    	System.out.println("-----------"+strExpected);
    	boolean value=false;
    	if(strExpected.contains(StrMobileName)) {
    		value=true;
    	}
    	reusableUtils.validateAssertTrue(value, "mobile is not present");
    //	ScenarioContext.setContext(Context.PRICE, strExpected);
         
    }
    
    public void deleteProduct() {
    	reusableUtils.clickElement(deleteBtn);
    }
    
     public void validatingCart(String cartpage) {
    	 reusableUtils.waittime();
    	 String strExpected=reusableUtils.getElemText(validateCart);
    	 boolean value=false;
    	 if(strExpected.contains(cartpage)) {
    		 value=true;
    	 }
    	 reusableUtils.validateAssertTrue(value, "cart page is not empty");
     }
}
