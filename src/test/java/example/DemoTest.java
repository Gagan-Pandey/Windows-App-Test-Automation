package example;

import io.appium.java_client.windows.WindowsDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;


public class DemoTest {

    static WindowsDriver driver;

    @BeforeClass
    public static void setup() throws MalformedURLException {

        String appPath = "C:\\BC4Utility\\BC4Utility.exe";

        URL appiumServerURL = new URL("http://127.0.0.1:4723/");
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Windows");
        capabilities.setCapability("automationName", "Windows");
        capabilities.setCapability("deviceName", "WindowsPC");
        capabilities.setCapability("app", appPath);
        capabilities.setCapability("fullReset", "true");
        capabilities.setCapability("autoGrantPermissions", "true");

        driver = new WindowsDriver(appiumServerURL, capabilities);

    }

    @Test
    public void testBC4UtilityApp(){
        Assert.assertTrue(driver.findElementByAccessibilityId("btnCheckAll").isDisplayed());

        driver.findElementByAccessibilityId("btnCheckAll").click();

        driver.findElementByAccessibilityId("btnUpdateFirmware").click();

        Assert.assertTrue(driver.findElementByName("Bin file not specified").isDisplayed());

        driver.findElementByXPath("//Button[@ClassName=\"Button\" and @Name=\"OK\"]").click();
        driver.findElementByXPath("//Button[@Name=\"Exit\"][@AutomationId=\"btnExit\"]").click();
    }

    @After
    public void afterClass(){
        driver.quit();
    }
}
