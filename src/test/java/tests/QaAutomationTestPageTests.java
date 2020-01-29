package tests;

import helper.Browser;
import helper.TestHelper;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.QaAutomationTestPage;

public class QaAutomationTestPageTests extends TestHelper {
    Browser browser;
    private QaAutomationTestPage qaAutomationTestPage;
    private String pageUrl = "/contact/qa_automation_test";

    @Parameters({"browserName", "baseUrl"})
    @BeforeClass(groups = {"web"})
    public void setUp(String browserName, String baseUrl) {
        browser = new Browser(browserName, baseUrl + pageUrl);
        qaAutomationTestPage = new QaAutomationTestPage(browser);
        browser.navigateToBaseUrl();
    }

    @Test(groups = {"web"})
    public void formFillTest() throws InterruptedException {

        qaAutomationTestPage.setYourNameField("testuser");
        qaAutomationTestPage.setYourEmailAddressField("testuser@gmail.com");
        qaAutomationTestPage.setSubjectField("QA Automation Test");
        qaAutomationTestPage.setMessageField("A sample QA Automation Test");
        qaAutomationTestPage.selectCountry("United States");
        qaAutomationTestPage.setFirstNameField("test");
        qaAutomationTestPage.setLastNameField("Client");
        qaAutomationTestPage.setCompanyField("test Client company");
        qaAutomationTestPage.setStreetAddressField("test Client address");
        qaAutomationTestPage.setCityField("test City");
        qaAutomationTestPage.selectState("New York");
        qaAutomationTestPage.setZipCodeField("10081");
        qaAutomationTestPage.clickOnSendMessageButton();
        qaAutomationTestPage.validateSuccesMessage();
    }

    @AfterClass(groups = {"web"})
    public void tearDown() {
        browser._driver.quit();
    }
}
