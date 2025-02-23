package com.StepDefinitions;

import com.DriverManagers.LoggerManager;
import com.Utilities.DriverUtilis;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class Hooks {
	DriverUtilis driverUtilis;
    WebDriver webDriver;

    Logger log= LoggerManager.getLogger(Hooks.class);

    public  Hooks(DriverUtilis driverUtilis)
    {
        this.driverUtilis=driverUtilis;

    }

    @Before
    public void setup(Scenario scenario)
    {
        log.info(scenario.getName()+"execution is started");
        webDriver =driverUtilis.getDriverManager().getWebDriver();
    }

    @After
    public void tearDown(Scenario scenario)
    {
        if(scenario.isFailed())
        {
            try {
                log.info(null);
                byte[] screenshot=((TakesScreenshot)driverUtilis.getDriverManager().getWebDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot,"image/png",scenario.getName()+"screenshot");
            }
            catch (WebDriverException e)
            {
                log.info(e.getMessage());
                System.err.println(e.getMessage());
            }
        }
        else
        {
            log.info(scenario.getName()+"Scenario is passed");
        }
        driverUtilis.getDriverManager().closeDriver();
    }

}
