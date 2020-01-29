package pages;

import helper.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pages.shared.Page;

public class QaAutomationTestPage extends Page {
    public QaAutomationTestPage(Browser browser) {
        super(browser);
    }

    @FindBy(xpath = "//input[@data-drupal-selector='edit-name']")
    private WebElement yourNameField;

    @FindBy(xpath = "//input[@data-drupal-selector='edit-mail']")
    private WebElement yourEmailAddressField;

    @FindBy(xpath = "//input[@id='edit-subject-0-value']")
    private WebElement subjectField;

    @FindBy(xpath = "//textarea[@id='edit-message-0-value']")
    private WebElement messageField;

    @FindBy(xpath=("//select[@id='edit-field-client-address-0-address-country-code--2']"))
    private WebElement selectCountry;

    @FindBy(xpath = "//input[@data-drupal-selector= 'edit-field-client-address-0-address-given-name']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@data-drupal-selector= 'edit-field-client-address-0-address-family-name']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@data-drupal-selector= 'edit-field-client-address-0-address-organization']")
    private WebElement companyField;

    @FindBy(xpath = "//input[@data-drupal-selector= 'edit-field-client-address-0-address-address-line1']")
    private WebElement streetAddressField;

    @FindBy(xpath = "//input[@data-drupal-selector= 'edit-field-client-address-0-address-locality']")
    private WebElement cityField;

    @FindBy (xpath = "//select[@data-drupal-selector= 'edit-field-client-address-0-address-administrative-area']")
    private WebElement selectState;

    @FindBy(xpath = "//input[@data-drupal-selector='edit-field-client-address-0-address-postal-code']")
    private WebElement zipCodeField;

    @FindBy(id = "edit-submit")
    private WebElement sendMessageButton;


    public void setYourNameField(String name) {
        yourNameField.clear();
        yourNameField.sendKeys(name);
    }

    public void setYourEmailAddressField(String email) {
        yourEmailAddressField.clear();
        yourEmailAddressField.sendKeys(email);
    }

    public void setSubjectField(String subject) {
        subjectField.clear();
        subjectField.sendKeys(subject);
    }


    public void setMessageField(String message) {
        messageField.clear();
        messageField.sendKeys(message);
    }

    public void selectCountry(String countryName) throws InterruptedException {
        selectCountry.click();
        Select drpCountry = new Select(driver.findElement(By.xpath("//select[@id='edit-field-client-address-0-address-country-code--2']")));
        drpCountry.selectByVisibleText(countryName);
        Thread.sleep(2000);
     }

    public void setFirstNameField(String firstname)  {
        firstNameField.clear();
        firstNameField.sendKeys(firstname);
    }

    public void setLastNameField(String lastname) {
        lastNameField.clear();
        lastNameField.sendKeys(lastname);
    }

    public void setCompanyField(String company) {
        companyField.clear();
        companyField.sendKeys(company);
    }

    public void setStreetAddressField(String streetname) {
        streetAddressField.clear();
        streetAddressField.sendKeys(streetname);
    }

    public void setCityField(String city) {
        cityField.clear();
        cityField.sendKeys(city);
    }

    public void selectState(String state) throws InterruptedException {
        selectState.click();
        Select drpCountry = new Select(driver.findElement(By.xpath("//select[@data-drupal-selector= 'edit-field-client-address-0-address-administrative-area']")));
        Thread.sleep(2000);
        drpCountry.selectByVisibleText(state);
    }

    public void setZipCodeField(String zipcode) {
        zipCodeField.clear();
         zipCodeField.sendKeys(zipcode);
    }
    public void clickOnSendMessageButton() {
        sendMessageButton.click();
    }


    public void validateSuccesMessage() {
        WebElement msg = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        String text = msg.getText();
        String expectedText = "×\n" +
                "Status message\n" +
                "Successfully submitted";
        Assert.assertEquals(text, expectedText);
    }
}