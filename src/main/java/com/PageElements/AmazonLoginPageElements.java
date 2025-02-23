package com.PageElements;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonLoginPageElements {
	@FindBy(css="#twotabsearchtextbox")
	public WebElement searchbar;
	@FindBy(css="#nav-search-submit-button")
	public WebElement searchItem;
    @FindBy(css="[class*='a-size-mini a-spacing-none']")
    public List<WebElement> selectedMobile;
    @FindBy(css="#imgTagWrapperId")
    public WebElement zoomin;
    @FindBy(css="#magnifierLens")
    public WebElement zoomInproduct;
}
