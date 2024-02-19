package io.stage.imerit.tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.stage.imerit.pages.LoginPage;
import io.stage.imerit.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readConfig = new ReadConfig();
	String URL = readConfig.getBaseURL(); 
	String browser = readConfig.getBrowser();
	 
	public static WebDriver driver;

	@BeforeSuite
	public void Set_Up() throws InterruptedException, IOException {
		switch (browser.toLowerCase()) {

		case "chrome":
			
			FileUtils.forceDelete(new File(".\\allure-results"));
			
			ChromeOptions opt = new ChromeOptions();
			
			opt.setBrowserVersion("121");
			opt.setAcceptInsecureCerts(true);
			
			opt.addExtensions(new File(".\\src\\test\\resource\\idnmojbcdinkcmmlaoomomcehpcklgpf.crx"));
			
			//opt.addArguments("--headless=new");
			opt.addArguments("--disable-gpu");
			opt.addArguments("--window-size=1920,1200");
			opt.addArguments("--ignore-certificate-errors");
			opt.addArguments("--no-sandbox");
			opt.addArguments("--allow-insecure-localhost");
			opt.addArguments("--allow-running-insecure-content");
			opt.addArguments("--disable-dev-shm-usage");
			opt.addArguments("--disable-dev-shm-usage");
			opt.addArguments("--user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36");
			
			//WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(opt);
			driver.manage().window().maximize();
			
		    Thread.sleep(2000);
			
			String currentHandle = driver.getWindowHandle();
			Set<String> handles = driver.getWindowHandles();
			for (String actual : handles) {
				if (!actual.equalsIgnoreCase(currentHandle)) {
					driver.close();
					driver.switchTo().window(actual);
				}
			}
			
	    	break;

		case "msedge":
			
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			
			break;

		default:
			driver = null;
			break;
		}
	}

	@AfterSuite
	public void Tear_Down() {
		driver.close();
		driver.quit();
	}
	
}