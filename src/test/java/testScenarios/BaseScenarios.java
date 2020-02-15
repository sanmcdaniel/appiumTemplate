package testScenarios;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.net.URL;


public class BaseScenarios {

    protected AppiumDriver driver;

    @Before
    public void setup() throws Exception {

        File filePath = new File(System.getProperty("user.dir"));
        File appDir = new File(filePath, "/app");
        File app = new File(appDir, "superapp.app-Debug-3.zip");

        DesiredCapabilities deviceSetup = new DesiredCapabilities();

        deviceSetup.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        deviceSetup.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 11 Pro");
        deviceSetup.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.3");
        deviceSetup.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        deviceSetup.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), deviceSetup);

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
