package helper;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

/**
 * Browser object to retrieve driver based on browser name.
 * Please note hardcoded path for selenium driver path
 */
public class Browser {
    public Browser(String browserName, String baseUrl) {
        setBrowser(browserName);
        setBaseUrl(baseUrl);
        Initialise(getBrowser());
    }

    private void Initialise(String browser) {
        capabilities = new DesiredCapabilities();
        seleniumFolderPath = System.getProperty("user.home") + "/solaredge/src/main/resources/chromedriver/windows/";
        switch (browser) {
            case "Chrome":
                ChromeOptions chrome_options = new ChromeOptions();
                chrome_options.addArguments("--disable-geolocation");
                chrome_options.addArguments("--ignore-certificate-errors");
                chrome_options.addArguments("--allow-running-insecure-content");
                chrome_options.addArguments("--incognito");
                chrome_options.addArguments("--disable-dev-shm-usage");

                System.setProperty("webdriver.chrome.driver", seleniumFolderPath + "chromedriver.exe");
                capabilities.setBrowserName("chrome");
                capabilities.setCapability(ChromeOptions.CAPABILITY, chrome_options);
                _driver = new ChromeDriver(capabilities);
                _driver.manage().window().maximize();
                break;
            case "Safari":
                capabilities.setBrowserName("safari");
//                _driver = new SafariDriver();
                break;
            case "Firefox":
//                _driver = new FirefoxDriver(capabilities);
                break;
            case "InternetExplorer":
                System.setProperty("webdriver.ie.driver", seleniumFolderPath + "IEDriverServer.exe");
                capabilities.setBrowserName("internet explorer");
                break;
            case "Edge":
                System.setProperty("webdriver.edge.driver", seleniumFolderPath + "MicrosoftWebDriver.exe");
                capabilities.setBrowserName("edge");
                break;
            case "Safari_iOS":
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 5");
                capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.6.5");
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
                break;
            default:
                System.out.println("Invalid browser passed in: " + browser);
                break;
        }
        _driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void navigateTo(String url) {
        _driver.get(url);
    }

    public void navigateToBaseUrl() {
        _driver.get(getBaseUrl());
    }

    public String getBrowser() {
        return this.browserName;
    }

    private void setBrowser(String browserName) {
        this.browserName = browserName;
    }

    private void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }


    // Public properties
    public WebDriver _driver;

    // Private properties
    private DesiredCapabilities capabilities;
    private String browserName;
    private String baseUrl;
    private String seleniumFolderPath;
}
