package io.stage.imerit.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewOrganizationPage {

	WebDriver ldriver;

	public NewOrganizationPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//h3[contains(text(),'new organization')]")
	WebElement newOrganization;

	@FindBy(xpath = "//h2[contains(text(),'Organization information')]")
	WebElement organizationInformation;

	@FindBy(xpath = "//label[contains(text(),'Organization name')]")
	WebElement organizationName;

	@FindBy(xpath = "//a[contains(text(),'cancel')]")
	WebElement cancel;

	@FindBy(xpath = "//input[@id='organizationName']")
	WebElement newOrganizationValue;

	@FindBy(xpath = "//button[contains(text(),'create')]")
	WebElement create;

	@FindBy(xpath = "//input[@id='search']")
	WebElement search;

	public boolean viewNewOrganization() {
		boolean isNewOrganizationDisplayed = newOrganization.isDisplayed();
		return isNewOrganizationDisplayed;
	}

	public boolean viewOrganizationInformation() {
		boolean isOrganizationInformationDisplayed = organizationInformation.isDisplayed();
		return isOrganizationInformationDisplayed;
	}

	public boolean viewOrganizationName() {
		boolean isOrganizationNameDisplayed = organizationName.isDisplayed();
		return isOrganizationNameDisplayed;
	}

	public boolean viewCancel() {
		boolean isCancelDisplayed = cancel.isDisplayed();
		return isCancelDisplayed;
	}

	public void enterNewOrganizationValue(String newOrganizationValueTimestamp) {
		newOrganizationValue.sendKeys(newOrganizationValueTimestamp);
	}

	public void clickOnCreate() {
		create.click();
	}

	public void enterSearchValue(String searchValueNewOrganization) {
		search.sendKeys(searchValueNewOrganization);
	}

}
