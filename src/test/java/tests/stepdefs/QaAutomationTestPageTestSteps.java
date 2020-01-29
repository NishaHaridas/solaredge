package tests.stepdefs;

import cucumber.api.Scenario;
import cucumber.api.java8.En;
import helper.Browser;
import pages.QaAutomationTestPage;

public class QaAutomationTestPageTestSteps implements En {
    Browser browser;
    private QaAutomationTestPage qaAutomationTestPage;

    public QaAutomationTestPageTestSteps()
    {
        Given("^a web \\\"([^\\\"]*)\\\" browser is on the page \\\"([^\\\"]*)\\\"$", (String browserName, String url) -> {
            browser = new Browser(browserName, url);
            qaAutomationTestPage = new QaAutomationTestPage(browser);
            browser.navigateTo(url);
        });

        When("^I fill in \"([^\"]*)\" with \"([^\"]*)\"$", (String field, String value) -> {
            this.FillFieldValue(field, value);
        });
        When("^I select \"([^\"]*)\" with \"([^\"]*)\"$", (String field, String value) -> {
            this.SelectDropdownValue(field, value);
        });

        When("^I click on the Send message button$", () -> {
            qaAutomationTestPage.clickOnSendMessageButton();
        });

        Then("^the form is successfully submitted$", () -> {
            qaAutomationTestPage.validateSuccesMessage();
        });

        After(new String[]{"@web"}, (Scenario scenario) -> {
            browser._driver.quit();
        });
    }

    /* Fill the elements calling pom methods.
    * Can be improved by replacing switch.
    */
    private void SelectDropdownValue(String field, String value) throws InterruptedException {
        switch (field) {
            case "country":
                qaAutomationTestPage.selectCountry(value);
                break;
            case "state":
                qaAutomationTestPage.selectState(value);
                break;
        }
    }
    /**
     * Fill the elements calling pom methods.
     * Can be improved by replacing switch.
     */
    private void FillFieldValue(String field, String value){
        switch (field){
            case "yourname":
                qaAutomationTestPage.setYourNameField(value); break;
            case "youremailaddress":
                qaAutomationTestPage.setYourEmailAddressField(value); break;
            case "subject":
                qaAutomationTestPage.setSubjectField(value); break;
            case "message":
                qaAutomationTestPage.setMessageField(value); break;
            case "firstname":
                qaAutomationTestPage.setFirstNameField(value); break;
            case "lastname":
                qaAutomationTestPage.setLastNameField(value); break;
            case "company":
                qaAutomationTestPage.setCompanyField(value); break;
            case "streetaddress":
                qaAutomationTestPage.setStreetAddressField(value); break;
            case "city":
                qaAutomationTestPage.setCityField(value); break;
            case "zipcode":
                qaAutomationTestPage.setZipCodeField(value); break;
        }
    }
}

