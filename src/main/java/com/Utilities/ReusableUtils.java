package com.Utilities;


import com.DriverManagers.LoggerManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.print.DocFlavor;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.security.Key;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class ReusableUtils {

	 private final WebDriver webDriver;

	    Logger log= LoggerManager.getLogger(ReusableUtils.class);

	    public ReusableUtils(WebDriver webDriver)
	    {
	        this.webDriver=webDriver;
	    }

	    /**
	     * method load the given Url in browser tab
	     * @param strURL -URL to be load on browser
	     */

	    public void gotoURL(String strURL){
	        webDriver.get(strURL);
	        JavascriptExecutor js=(JavascriptExecutor) webDriver;
	        log.info(strURL+ "URL Loaded on the browser ");
	    }
	    /**
	     * method to click web element
	     * @param elementtoBeClick - element to be click
	     */
	    public void clickElement(WebElement elementtoBeClick){
	        elementtoBeClick.click();
	        log.info(elementtoBeClick+"-webElement clicked");
	    }

	    /**
	     * method to scroll and click the webElement
	     * @param elementtoBeClick -Element to be click
	     */

	    public void scrollAndClickElement(WebElement elementtoBeClick){
	        JavascriptExecutor js=(JavascriptExecutor) webDriver;
	        js.executeScript("arguments[0].scrollIntoView();",elementtoBeClick);
	        elementtoBeClick.click();
	        log.info(elementtoBeClick+" -scroll and click webElement");
	    }

	    /**
	     * method to scroll and click webElement
	     * @param elementtoBeClick -Element to be click
	     */

	    public void actionClickElement(WebElement elementtoBeClick)
	    {
	        Actions actions=new Actions(webDriver);
	        actions.moveToElement(elementtoBeClick).click().build().perform();
	        log.info(elementtoBeClick+" -click webElement");
	    }

	    /**
	     * method to  click webElement
	     * @param elementtoBeClick
	     */
	    public void jsClickElement(WebElement elementtoBeClick)
	    {
	        JavascriptExecutor js=(JavascriptExecutor) webDriver;
	        js.executeScript("arguments[0].click();",elementtoBeClick);
	        log.info(elementtoBeClick+" -click webElement");
	    }


	    /**
	     * Method to get the element Text
	     * @param elementtoGetText
	     * @return -element text will be return
	     */
	    public String getElemText(WebElement elementtoGetText){
	        log.info(elementtoGetText+" element has text "+elementtoGetText.getText());
	        return elementtoGetText.getText();
	    }

	    /**
	     * Method to validate to texts are equal using assert
	     * @param strActual
	     * @param strExpected
	     * @param strMessage
	     */
	    public void validateTextEqual(String strActual, String strExpected, String strMessage)
	    {
	        Assert.assertEquals(strActual,strExpected,strMessage);
	    }

	    /**
	     * Method to validate to texts contains using assert
	      * @param strActual
	     * @param strExpected
	     * @param strMessage
	     */
	    public void validateTextContains(String strActual, String strExpected, String strMessage)
	    {
	        Assert.assertEquals(strActual.contains(strExpected),strMessage);
	    }

	    /**
	     * Method is used to enter downkey by using keyword action
	     */
	    public void downKey()
	    {
	        try {
	            Robot r=new Robot();
	            r.keyPress(KeyEvent.VK_DOWN);
	            r.keyPress(KeyEvent.VK_ENTER);
	        }
	        catch (Exception e) {

	        }
	    }

	    /**
	     * Method to validate gven element is displayed or not,validate with assert condition
	     * @param elemDisplay
	     */
	    public void validateElementDispalyed(WebElement elemDisplay)
	    {
	     Assert.assertTrue(isElementDisplayed(elemDisplay));
	    }

	    /**
	     * Method to validate gven element is not displayed,validate with assert condition
	      * @param elemDisplay
	     */
	    public  void validateElementNotDisplayed(WebElement elemDisplay){
	        try {
	            Thread.sleep(500);
	        }
	        catch (InterruptedException e)
	        {
	            throw new RuntimeException(e);
	        }
	        Assert.assertTrue(!isElementDisplayed(elemDisplay));
	    }

	    /**
	     * Method to validate to given element is displayed or not
	     * @param elemDisplay
	     * @return
	     */
	    public  Boolean isElementDisplayed(WebElement elemDisplay)
	    {
	        try {
	            elemDisplay.isDisplayed();
	            log.info(elemDisplay+"element is Displayed on the page");
	            return  true;
	        }
	        catch (Exception e)
	        {
	            log.info(elemDisplay+"element is not diplayed in the page");
	            return  false;
	        }
	    }

	    /**
	     * Method to update send keys value and clear before update
	      * @param elemToBeUpdated
	     * @param strValue
	     */
	    public void updateElementValue(WebElement elemToBeUpdated, String strValue)
	    {
	        log.info(strValue+"update value to context"+elemToBeUpdated);
	        elemToBeUpdated.clear();
	        elemToBeUpdated.sendKeys(strValue);
	        log.info(strValue+"update value on element"+elemToBeUpdated);
	    }
	    public void sendText(WebElement element, String name) {
	    	element.sendKeys(name);
	    	log.info(name+" sending the element "+element);
	    }

	    /**
	     * Method to update Keys using sendkeys
	      * @param elemToBeUpdated
	     * @param keytype
	     */
	    public void updateElemKeys(WebElement elemToBeUpdated, Keys keytype)
	    {
	        elemToBeUpdated.sendKeys(keytype);
	        log.info(keytype+"update key on element"+elemToBeUpdated);
	    }

	    /**
	     * Method to update  keys using sendkeus
	      * @param elemToBeUpdated
	     * @param keytype
	     */
	    public void actionUpdateElemKeys(WebElement elemToBeUpdated,Keys keytype)
	    {
	        Actions actions=new Actions(webDriver);
	        actions.click(elemToBeUpdated).sendKeys(keytype).build().perform();
	        log.info(keytype+"update key on element"+elemToBeUpdated);
	    }
	    public void actionMovetoElement(WebElement eleToMove) {
	    	Actions actions=new Actions(webDriver);
	    	actions.moveToElement(eleToMove).build().perform();
	    	log.info(eleToMove+" element moved");
	    }

	    /**
	     * Method Wait untill element present
	      * @param elemToBeWaited
	     */
	    public  void waitUtillElementIsVisible(WebElement elemToBeWaited)
	    {
	        try {
	            Thread.sleep(5000);
	        }
	        catch (InterruptedException e)
	        {
	            throw new RuntimeException(e);
	        }
	    }

	    /**
	     * Method to wait untill the element present using condition
	     * @param waitCondition- wait condition
	     */
	    public void until(Function<WebDriver,Boolean> waitCondition)
	    {
	        WebDriverWait webDriverWait=new WebDriverWait(webDriver, Duration.ofSeconds(40));
	        try {
	            webDriverWait.until(waitCondition);
	        }catch (Exception e)
	        {
	            System.out.println(e.getMessage());
	        }
	    }

	    /**
	     * Method to wait untill the page load with help of ready state
	      */
	    public void waitUntilPageReadyState()
	    {
	        try {
	            Thread.sleep(3000);
	        }catch (InterruptedException e)
	        {
	            throw new RuntimeException(e);
	        }
	        until((function)->{
	            String strPageLoaded =String.valueOf(((JavascriptExecutor)webDriver).executeScript("return document.readystate"));
	            if(strPageLoaded.equals("complete"))
	            {
	                return true;
	            }
	            else {
	                return false;
	            }
	        });
	    }

	    /**
	     * Method to clear element text
	      * @param elemToClear
	     */
	    public void clearElementText(WebElement elemToClear){
	        elemToClear.clear();
	    }
	    public void waittime() {
	    	try {
	    		Thread.sleep(2000);
	    	}catch(InterruptedException e) {
	    		throw new RuntimeException(e);
	    	}
	    }

	    /**
	     * Method need to wait until the ajax call is done
	     */
		public void waitUntilAjaxCallsDone() {
			until((function) -> {
				Boolean blnJQueryCallDone = (Boolean) ((JavascriptExecutor) webDriver)
						.executeScript("return JQuery.active==0");
				return (blnJQueryCallDone);
			});
		}

	    /**
	     * Method to wait until the element clickable
	      * @param elemToBeWaited
	     */
	    public void waitUtilElementIsClickable(WebElement elemToBeWaited){
	        WebDriverWait wait = new WebDriverWait(webDriver,Duration.ofSeconds(20000));
	        wait.until(ExpectedConditions.elementToBeClickable(elemToBeWaited));
	    }

	    /**
	     * Method to validate page attribute contains text
	     * @param elemAttribute - element need to be validated
	     * @param strAttributeName - type of attribute name
	     * @param strTextToBeValidate - expected text value from the attribute
	     */
	    public void validateAttributeContainsText(WebElement elemAttribute,String strAttributeName,String strTextToBeValidate){
	        String strAttributeValue=elemAttribute.getAttribute(strAttributeName);
	        Assert.assertTrue(strAttributeValue.contains(strTextToBeValidate));
	    }

	    /**
	     * Method to switch window using the window title
	      * @param strTitle -expected window title
	     */
	    public void switchToWindow(String strTitle){
	        Set<String> listAllWindows=webDriver.getWindowHandles();
	        for(String strWindow:listAllWindows){
	            String strCurrentTitle=webDriver.switchTo().window(strWindow).getTitle();
	            if(strCurrentTitle.equalsIgnoreCase(strTitle)){
	                break;
	            }
	        }
	    }

	    /**
	     * Method to switch window using the window index
	      * @param intIndex - expected window index, index starts with zero
	     */
	    public void switchToWindowUsingIndex(int intIndex){
	        ArrayList<String> listAllWindows=new ArrayList< >(webDriver.getWindowHandles());
	        webDriver.switchTo().window(listAllWindows.get(intIndex));

	    }

	    /**
	     * Method to validate the element text is equal with expected text
	     * @param elemToValidate - element to get the text and validate
	     * @param strExpected - expected text value
	     */
	    public void validateElementTextEqual(WebElement elemToValidate,String strExpected){
	        Assert.assertEquals(elemToValidate.getText(),strExpected,strExpected+ " text Validation");
	    }

	    /**
	     * Method to click element and open in new tab
	     * @param elemToClick - element to be clicked
	     */
	    public void clickAndOpenInNewTab(WebElement elemToClick){
	        Actions actions=new Actions(webDriver);
	        actions.keyDown(Keys.LEFT_CONTROL).click(elemToClick).keyUp(Keys.LEFT_CONTROL).build().perform();
	        log.info(elemToClick+ " element clicked and open on mew window");
	    }

	    /**
	     * Method to wait until the element disappear
	      * @param elemeToBeWaited - element to disappear
	     */
	    public void waitUntilElementDisappear(WebElement elemeToBeWaited){
	        shortWait();
	        int count=1;
	        while (count<=8){
	            count++;
	            if(isElementDisplayed(elemeToBeWaited)){
	                try {
	                    Thread.sleep(10000);
	                }
	                    catch(InterruptedException e){
	                    throw new RuntimeException(e);

	                    }
	                }else{
	                break;
	            }
	        }
	    }

	    /**
	     * Method to get list all texts from list of elements and stored in array list
	     * @param elemToGetText - list of elements to get the list
	     * @return al texts as arraylist;
	     */
	    public ArrayList<String> getListElemText(List<WebElement> elemToGetText){
	        ArrayList<String> listOfText=new ArrayList<>();
	        for(int i=0;i<elemToGetText.size();i++){
	            listOfText.add(elemToGetText.get(i).getText());
	        }
	        return listOfText;
	    }

	    /**
	     * Method to validate array list equal
	     * @param listOfExpected -expected array list
	     * @param listOfActual - actual array list
	     * @param strmsg -message
	     */
	    public  void validateListEqual(ArrayList<String> listOfExpected, ArrayList<String>listOfActual, String strmsg){
	        Assert.assertEquals(listOfExpected,listOfActual,strmsg);
	    }

	    /**
	     * Method to validate array contains text value
	      * @param listOfText - array list
	     * @param strExpected - expected text value
	     * @param strMessage - Validation message for assertion
	     */
	    public void validateTextContainsInList(ArrayList<String>listOfText,String strExpected,  String strMessage){
	        boolean value=listOfText.contains(strExpected);
	        Assert.assertTrue(value,strMessage);
	    }

	    /**
	     * Method to validate element text contains validation
	     * @param elemToValidate - element to be validated
	     * @param strExpectedText - expected text
	     * @param strMessage - validation message for assertion
	     */
	    public void validateElementContainsText(WebElement elemToValidate, String strExpectedText, String strMessage){
	        Assert.assertTrue(getElemText(elemToValidate).contains(strExpectedText),strMessage);
	    }

	    /**
	     * Method to merge parent and child element
	     * @param elemParent - parent element
	     * @param byChild - child element using by option
	     * @return webElement will be returned
	     */
	    public  WebElement mergeToElement(WebElement elemParent, By byChild){
	        try{
	            WebElement elem=elemParent.findElement(byChild);
	            return elem;
	        }catch (Exception e){
	            return null;
	        }
	    }

	    /**
	     * Method to get the list of child counts for web element
	     * @param elemParent - parent element to get the child counts
	     * @return - no of child counts
	     */
	    public int getChildCount(WebElement elemParent){
	        try{
	            int noOFChild=Integer.parseInt(elemParent.getAttribute("childElementCount"));
	            return noOFChild;
	        }catch (Exception e){
	            return 0;
	        }
	    }

	    /**
	     * Method to scroll up to particular element
	      * @param elemToBeScroll - element to be scroll
	     */
	    public void scrollToElement(WebElement elemToBeScroll){
	        JavascriptExecutor js =(JavascriptExecutor) webDriver;
	        js.executeScript("arguments[0].scrollIntoView();",elemToBeScroll);
	    }

	    public void longWait(){
	        try{
	            Thread.sleep(20000);
	        }catch (InterruptedException e){
	            throw new RuntimeException(e);
	        }
	    }

	    public void shortWait(){
	        try{
	            Thread.sleep(3000);
	        }catch (InterruptedException e){
	            throw new RuntimeException(e);
	        }
	    }

	    /**
	     * Method to get the attribute value
	      * @param elemAttribute -element to get the attribute
	     * @param strAttributeName - attribute name
	     * @return attribute value as string
	     */
	    public String getAttributeValue(WebElement elemAttribute, String strAttributeName){
	        String strAttributeValue=elemAttribute.getAttribute(strAttributeName);
	        return strAttributeValue;
	    }

	    /**
	     * Method to validate assert true
	     * @param blnTrue - expected asssert value
	     * @param strMessage - validation message for assertion
	     */
	    public void validateAssertTrue(boolean blnTrue, String strMessage){
	        Assert.assertTrue(blnTrue,strMessage);
	    }

	    /**
	     * Method to validate given element is enabled or not
	     * @param elemEnable - element to be validated
	     * @return true/false boolean type.if element present it returns true
	     */
	    public Boolean isElementEnabled(WebElement elemEnable)
	    {
	        try {
	            elemEnable.isEnabled();
	            log.info(elemEnable+"element is enabled on the page");
	            return  true;
	        }catch (Exception e)
	        {
	            log.info(elemEnable+"element is not enabled in the page");
	            return false;
	        }
	    }

	    /**
	     * method to validate given element is enabled or not ,validate with assert condition
	     * @param elemEnable -element to be validated
	     */
	    public void validateElementEnabled(WebElement elemEnable)
	    {
	        Assert.assertTrue(isElementDisplayed(elemEnable));
	    }

	    /**
	     * Method to validate element is enabled or not,validate with assert condition
	      * @param elemEnable -element to be validated
	     */
	    public void validateElementDisabled(WebElement elemEnable)
	    {
	        Assert.assertFalse(isElementDisplayed(elemEnable));
	    }

	    /**
	     * Method for updating elements by using Actions
	      * @param elemToBeClick -WebElement
	     * @param strValue -string value
	     */
	    public void actionUpdateElement(WebElement elemToBeClick,String strValue)
	    {
	        Actions actions=new Actions(webDriver);
	        actions.click(elemToBeClick).sendKeys(strValue).build().perform();
	    }

	    /**
	     * Method to wait untill loading Icon Disappear
	     */
	    public void waitUntilLoadingIconDisappear()
	    {
	        shortWait();
	        int count=1;
	        while (count<=0)
	        {
	            try {
	                webDriver.findElement(By.xpath(""));
	                Thread.sleep(8000);
	                System.out.println("Loading IconWait"+count);
	            }
	            catch (Exception e)
	            {
	                System.out.println("Loading Icon Wait Completed");
	                break;
	            }
	            count++;
	        }
	    }

	    /**
	     * Method for double click the element
	      * @param elemToBeClick
	     */
	    public void doubleClickElement(WebElement elemToBeClick){
	        Actions actions=new Actions(webDriver);
	        actions.doubleClick(elemToBeClick).build().perform();
	    }

	    /**
	     * Method to Hover to element using action build
	     * @param elemToHover
	     */
	    public void hoverToElement(WebElement elemToHover)
	    {
	        Actions actions=new Actions(webDriver);
	        actions.moveToElement(elemToHover).build().perform();

	    }
}
