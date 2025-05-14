package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;

public class BaseClass {
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    private static final ConcurrentHashMap<Long, WebDriver> driverMap = new ConcurrentHashMap<>();
    public static final String LT_USERNAME = System.getenv("LT_USERNAME");
    public static final String LT_ACCESS_KEY = System.getenv("LT_ACCESS_KEY");
    private static final String BUILD_NAME = System.getProperty("buildName", "CucumberTestNG-LambdaTest-Parallel");

    public static void setup(String browser, String version, String platform, String testName) throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName", browser);
        caps.setCapability("version", version);
        caps.setCapability("platform", platform);
        
        // Common LambdaTest capabilities
        caps.setCapability("build", BUILD_NAME);
        caps.setCapability("name", testName);
        caps.setCapability("network", true);
        caps.setCapability("video", true);
        caps.setCapability("console", true);
        caps.setCapability("visual", true);
        
        // Thread-safe driver initialization
        WebDriver driver = new RemoteWebDriver(
                new URL("https://" + LT_USERNAME + ":" + LT_ACCESS_KEY + "@hub.lambdatest.com/wd/hub"),
                caps
        );
        
        driverThreadLocal.set(driver);
        driverMap.put(Thread.currentThread().getId(), driver);
    }

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public static void tearDown() {
        WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
            driver.quit();
            driverThreadLocal.remove();
            driverMap.remove(Thread.currentThread().getId());
        }
    }

    public static void tearDownAll() {
        driverMap.forEach((threadId, driver) -> {
            if (driver != null) {
                driver.quit();
            }
        });
        driverMap.clear();
        driverThreadLocal.remove();
    }
}
