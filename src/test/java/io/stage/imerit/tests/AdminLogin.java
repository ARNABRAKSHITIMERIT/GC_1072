package io.stage.imerit.tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.stage.imerit.pages.LoginPage;

public class AdminLogin extends BaseClass {

	public String otp;

	@Test(priority = 1)
	public void verifyEmailIdEntry() throws InterruptedException, IOException {
		LoginPage loginPage = new LoginPage(driver);

		driver.get("https://accounts.google.com/");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"identifierId\"]")));

		loginPage.enterEmailId("arnabrakshit_test1@imerit.net");
	}

	@Test(priority = 2, dependsOnMethods = { "verifyEmailIdEntry" })
	public void verifyEmailIdNextClick() throws InterruptedException, IOException {
		LoginPage loginPage = new LoginPage(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"identifierNext\"]/div/button/div[3]")));

		loginPage.clickOnEmailIdNext();
	}

	@Test(priority = 3, dependsOnMethods = { "verifyEmailIdNextClick" })
	public void verifyEmailPasswordEntry() throws InterruptedException, IOException {
		LoginPage loginPage = new LoginPage(driver);

		//Thread.sleep(10000) ;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")));

		loginPage.enterEmailPassword("Dhoni@7610");
	}

	@Test(priority = 4, dependsOnMethods = { "verifyEmailPasswordEntry" })
	public void verifyEmailPasswordNextClick() throws InterruptedException, IOException {
		LoginPage loginPage = new LoginPage(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"passwordNext\"]/div/button/div[3]")));

		loginPage.clickOnEmailPasswordNext();

		Thread.sleep(10000) ;
		
		//WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		//wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class=\"XY0ASe\"]")));
  }

	@Test(priority = 5, dependsOnMethods = { "verifyEmailPasswordNextClick" })
	public void verifyDashboardUsernameEntry() throws InterruptedException, IOException {
		LoginPage loginPage = new LoginPage(driver);

		driver.get(URL);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='username']")));

		loginPage.enterDashboardUsername("arnabrakshit_test1@imerit.net");
	}

	@Test(priority = 6, dependsOnMethods = { "verifyDashboardUsernameEntry" })
	public void verifyDashboardPasswordEntry() throws InterruptedException, IOException {
		LoginPage loginPage = new LoginPage(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));

		loginPage.enterDashboardPassword("Abcd@1234");
	}

	@Test(priority = 7, dependsOnMethods = { "verifyDashboardPasswordEntry" })
	public void verifyDashboardSignInClick() throws InterruptedException, IOException {
		LoginPage loginPage = new LoginPage(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));

		loginPage.clickOnDashboardSignIn();
	}

	@Test(priority = 8, dependsOnMethods = { "verifyDashboardSignInClick" })
	public void verifyEmailOtpExtraction() throws InterruptedException, IOException {
		LoginPage loginPage = new LoginPage(driver);

		driver.get("https://mail.google.com/mail/u/1/#search/otp+for+login+authentication");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table[1]/tbody[1]/tr[1]/td[5]/div[1]/div[1]/span[1])[1]")));

		otp = loginPage.getOtp();
	}

	@Test(priority = 9, dependsOnMethods = { "verifyEmailOtpExtraction" })
	public void verifyOtpEntry() throws InterruptedException, IOException {
		LoginPage loginPage = new LoginPage(driver);

		verifyDashboardUsernameEntry();
		verifyDashboardPasswordEntry();
		verifyDashboardSignInClick();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='otp']")));

		loginPage.enterDashboardOtp(otp);
	}

	@Test(priority = 10, dependsOnMethods = { "verifyOtpEntry" })
	public void verifyDashboardLogin() throws InterruptedException, IOException {
		LoginPage loginPage = new LoginPage(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'verify otp')]")));

		loginPage.clickOnDashboardVerifyOtp();
	}

}
