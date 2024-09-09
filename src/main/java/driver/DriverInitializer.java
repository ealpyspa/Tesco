package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.Map;

public class DriverInitializer {

    public static WebDriver initDriver(BrowserType type) {
        switch (type) {
            case CHROME_DESKTOP:
                ChromeOptions desktopOptions = new ChromeOptions();
                desktopOptions.addArguments("window-size=1920,1080");
                return new ChromeDriver(desktopOptions);
            case CHROME_NEXUS:
                Map<String, String> mobileEmulation = new HashMap<>();
                mobileEmulation.put("deviceName", "Nexus 5");
                ChromeOptions mobileOptions = new ChromeOptions();
                mobileOptions.addArguments("window-size=360,640");
                mobileOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

                return new ChromeDriver(mobileOptions);
            default:
                throw new IllegalArgumentException("Incorrect browser type!");
        }
    }
}