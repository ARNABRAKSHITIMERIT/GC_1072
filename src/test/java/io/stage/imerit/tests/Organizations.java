package io.stage.imerit.tests;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.stage.imerit.pages.HomePage;
import io.stage.imerit.pages.NewOrganizationPage;

public class Organizations extends BaseClass {

	@Test(priority = 11 , dependsOnMethods = { "verifyDashboardLogin" })
	public void verifyCreateOrganizationTextDisplayed() throws InterruptedException, IOException {
		HomePage homePage = new HomePage(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'create organization')]")));

		String createOrganizationButton = homePage.viewCreateOrganizationText();
		Assert.assertEquals("Create Organization", createOrganizationButton);
	}

	@Test(priority = 12 , dependsOnMethods = { "verifyDashboardLogin" })
	public void verifyHomePageTitle() throws InterruptedException, IOException {
		String homePageTitle = driver.getTitle();
		Assert.assertEquals("Organizations", homePageTitle);
	}

	@Test(priority = 13 , dependsOnMethods = { "verifyCreateOrganizationTextDisplayed" })
	public void verifyNewOrganizationPageTitle() throws InterruptedException, IOException {
		HomePage homePage = new HomePage(driver);
		homePage.clickOnCreateOrganization();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='organizationName']")));

		String newOrganizationPageTitle = driver.getTitle();
		Assert.assertEquals("New organization", newOrganizationPageTitle);
	}

	@Test(priority = 14 , dependsOnMethods = { "verifyHomePageTitle" })
	public void verifyOrganizationArnabStagePresent() throws InterruptedException, IOException {
		HomePage homePage = new HomePage(driver);
		driver.get("https://app.imerit-stage.io/");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'ARNAB_STAGE')]")));

		String organizationArnabStage = homePage.viewOrganizationArnabStage();
		Assert.assertEquals("ARNAB_STAGE", organizationArnabStage);
	}

	@Test(priority = 15 , dependsOnMethods = { "verifyHomePageTitle" })
	public void verifyOrganizationImeritEngineServerlessPresent() throws InterruptedException, IOException {
		HomePage homePage = new HomePage(driver);
		driver.navigate().refresh();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'iMerit Engine Serverless')]")));

		String organizationImeritEngineServerless = homePage.viewOrganizationImeritEngineServerless();
		Assert.assertEquals("iMerit Engine Serverless", organizationImeritEngineServerless);
	}

	@Test(priority = 16 , dependsOnMethods = { "verifyHomePageTitle" })
	public void verifyOrganizationImeritTestOrgPresent() throws InterruptedException, IOException {
		HomePage homePage = new HomePage(driver);
		driver.navigate().refresh();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'IMERIT_TEST_ORG_2023.05.28-01.47.18')]")));

		String organizationImeritTestOrg = homePage.viewOrganizationImeritTestOrg();
		Assert.assertEquals("IMERIT_TEST_ORG_2023.05.28-01.47.18", organizationImeritTestOrg);
	}

	@Test(priority = 17 , dependsOnMethods = { "verifyNewOrganizationPageTitle" })
	public void verifyNewOrganizationTextDisplayed() throws InterruptedException, IOException {
		NewOrganizationPage newOrganizationPage = new NewOrganizationPage(driver);
		driver.navigate().to("https://app.imerit-stage.io/organizations/create");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'new organization')]")));

		boolean isNewOrganizationTextDisplayed = newOrganizationPage.viewNewOrganization();
		Assert.assertEquals(true, isNewOrganizationTextDisplayed);
	}

	@Test(priority = 18 , dependsOnMethods = { "verifyNewOrganizationPageTitle" })
	public void verifyOrganizationInformationTextDisplayed() throws InterruptedException, IOException {
		NewOrganizationPage newOrganizationPage = new NewOrganizationPage(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Organization information')]")));

		boolean isOrganizationInformationTextDisplayed = newOrganizationPage.viewOrganizationInformation();
		Assert.assertEquals(true, isOrganizationInformationTextDisplayed);
	}

	@Test(priority = 19 , dependsOnMethods = { "verifyNewOrganizationPageTitle" })
	public void verifyOrganizationNameTextDisplayed() throws InterruptedException, IOException {
		NewOrganizationPage newOrganizationPage = new NewOrganizationPage(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'Organization name')]")));

		boolean isOrganizationNameTextDisplayed = newOrganizationPage.viewOrganizationName();
		Assert.assertEquals(true, isOrganizationNameTextDisplayed);
	}

	@Test(priority = 20 , dependsOnMethods = { "verifyNewOrganizationPageTitle" })
	public void verifyCancelButtonPresent() throws InterruptedException, IOException {
		NewOrganizationPage newOrganizationPage = new NewOrganizationPage(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'cancel')]")));

		boolean isCancelButtonDisplayed = newOrganizationPage.viewCancel();
		Assert.assertEquals(true, isCancelButtonDisplayed);
	}

	@Test(priority = 21 , dependsOnMethods = { "verifyNewOrganizationPageTitle" })
	public void verifyCreateAndSearchNewOrganization() throws InterruptedException, IOException {
		NewOrganizationPage newOrganizationPage = new NewOrganizationPage(driver);
		
		Timestamp time_stamp = new Timestamp(System.currentTimeMillis());
		String timestamp_string = time_stamp.toString();
		String new_organization_name = ("NEW_ORGANIZATION_TEST" + " " + timestamp_string);
		new_organization_name = new_organization_name.replace(":", "-");
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='organizationName']")));

		newOrganizationPage.enterNewOrganizationValue(new_organization_name);
		
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'create')]")));
		
		newOrganizationPage.clickOnCreate();

		driver.navigate().to("https://app.imerit-stage.io/");

		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='search']")));
		
		newOrganizationPage.enterSearchValue(new_organization_name);

		Thread.sleep(2000);

		int search_count = driver.findElements(By.xpath("//body/div[@id='__next']/div[3]/div[1]/div[2]/div[1]/ul[1]/li[1]/a[1]/div[1]")).size();
		Assert.assertEquals(1, search_count);

		System.out.println(" ---------------------------------------------------------------------------------------------------- ");
		System.out.println("New Organization Created = " + new_organization_name);
		System.out.println(" ---------------------------------------------------------------------------------------------------- ");
	}

	@Test(priority = 22 , dependsOnMethods = { "verifyHomePageTitle" })
	public void verifySortOrganizationsByName() throws InterruptedException, IOException {
		HomePage homePage = new HomePage(driver);
		driver.get("https://app.imerit-stage.io/");

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/button[1]")));

		homePage.clickOnSortByName();
		
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[1]/div[1]/span[1]/span[1]")));

		String sortOrganizationByName = homePage.viewName();
		Assert.assertEquals("Name", sortOrganizationByName);
	}

}