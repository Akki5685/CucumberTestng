package com.TextExecutor;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        features = "src/test/resources/Features",
        glue = "com.StepDefinitions",
        tags="",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/cucumber-json-report.json",
                "timeline:target/test-output-thread/",
                "junit:target/cucumber-reports/cucumber-junit-report.xml",
                "html:target/cucumber-reports/cucumber-pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
              
        }
        
)
public class TestRunner  extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Execution Started");
    }
 /* @Test(
    		groups= {"cucumber"},
    		description="Runs Cucumber Scenarios",
    		dataProvider="scenarios",
    		retryAnalyzer = Retryy.class
    		)
    @Override
    public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
    	super.runScenario(pickleWrapper, featureWrapper);
    }

    @AfterSuite
    public void afterSuite()
    {
        System.out.println("Test Execution Started");
    }*/
    //execution command::"mvn clean test -Ddataproviderthreadcount=3 -Dcucumber.filter.tags=@ShoppingToCart"

   // mvn clean test -D"dataproviderthreadcount"="3" -D"cucumber.filter.tags"="@BestSeller"" //for cicd or terminal
    
    //driverUtilis.getScenarioContext().setContext(Context.PRICE, strMobile);
    //String strPrice=driverUtilis.getScenarioContext().getContext(Context.PRICE).toString();
}
