package io.stage.imerit.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver ldriver;

	public HomePage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'create organization')]")
	WebElement createOrganization;

	@FindBy(xpath = "//p[contains(text(),'ARNAB_STAGE')]")
	WebElement organizationArnabStage;

	@FindBy(xpath = "//p[contains(text(),'iMerit Engine Serverless')]")
	WebElement organizationImeritEngineServerless;

	@FindBy(xpath = "//p[contains(text(),'IMERIT_TEST_ORG_2023.05.28-01.47.18')]")
	WebElement organizationImeritTestOrg;

	@FindBy(xpath = "//body[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/button[1]")
	WebElement sortByName;

	@FindBy(xpath = "//body[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[1]/div[1]/span[1]/span[1]")
	WebElement name;

	public String viewCreateOrganizationText() {
		String createOrganizationText = createOrganization.getText();
		return createOrganizationText;
	}

	public void clickOnCreateOrganization() {
		createOrganization.click();
	}

	public String viewOrganizationArnabStage() {
		String existingOrganizationArnabStage = organizationArnabStage.getText();
		return existingOrganizationArnabStage;
	}

	public String viewOrganizationImeritEngineServerless() {
		String existingOrganizationImeritEngineServerless = organizationImeritEngineServerless.getText();
		return existingOrganizationImeritEngineServerless;
	}

	public String viewOrganizationImeritTestOrg() {
		String existingOrganizationImeritTestOrg = organizationImeritTestOrg.getText();
		return existingOrganizationImeritTestOrg;
	}

	public void clickOnSortByName() {
		sortByName.click();
	}

	public String viewName() {
		String sortName = name.getText();
		return sortName;
	}

}