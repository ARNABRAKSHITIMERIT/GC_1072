package io.stage.imerit.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;

public class LoginPage {
	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//*[@id=\"identifierId\"]")
	WebElement emailId;

	@FindBy(xpath = "//*[@id=\"identifierNext\"]/div/button/div[3]")
	WebElement emailIdNextButton;

	@FindBy(xpath = "//input[@type='password']")
	WebElement emailPassword;

	@FindBy(xpath = "//*[@id=\"passwordNext\"]/div/button/div[3]")
	WebElement emailPasswordNextButton;

	@FindBy(xpath = "//input[@id='username']")
	WebElement dashboardUsername;

	@FindBy(xpath = "//input[@id='password']")
	WebElement dashboardPassword;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement dashboardSignInButton;

	//@FindBy(xpath = "(//table[1]/tbody[1]/tr[1]/td[5]/div[1]/div[1]/span[1])[1]")
	@FindBy(xpath = "//span[@class='y2']")
	WebElement emailOtpText;

	@FindBy(xpath = "//input[@id='otp']")
	WebElement dashboardOtp;

	@FindBy(xpath = "//button[contains(text(),'verify otp')]")
	WebElement dashboardOtpConfirmation;

	public void enterEmailId(String emailIdValue) {
		emailId.sendKeys(emailIdValue);
	}

	public void clickOnEmailIdNext() {
		Actions actions = new Actions(ldriver);
		actions.moveToElement(emailIdNextButton).click().perform();
	}

	public void enterEmailPassword(String emailPasswordValue) throws InterruptedException, IOException {

		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		js.executeScript("arguments[0].scrollIntoView(true);", emailPassword);
                Thread.sleep(5000);
		emailPassword.click();
		Thread.sleep(5000);
		emailPassword.sendKeys(emailPasswordValue);
	}

	public void clickOnEmailPasswordNext() {
		Actions actions = new Actions(ldriver);
		actions.moveToElement(emailPasswordNextButton).click().perform();
	}

	public void enterDashboardUsername(String dashboardUsernameValue) {
		dashboardUsername.sendKeys(dashboardUsernameValue);
	}

	public void enterDashboardPassword(String dashboardPasswordValue) {
		dashboardPassword.sendKeys(dashboardPasswordValue);
	}

	public void clickOnDashboardSignIn() {
		dashboardSignInButton.click();
	}

	public String getOtp() {
		String emailOtp = emailOtpText.getAttribute("textContent");
		String[] emailOtpRecent = emailOtp.split(" ");
		String emailOtpFinal = emailOtpRecent[4];
		return emailOtpFinal;
	}

	public void enterDashboardOtp(String dashboardOtpValue) {
		dashboardOtp.sendKeys(dashboardOtpValue);
	}

	public void clickOnDashboardVerifyOtp() {
		dashboardOtpConfirmation.click();
	}

}
