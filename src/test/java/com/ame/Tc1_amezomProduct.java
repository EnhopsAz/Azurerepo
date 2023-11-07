package com.ame;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc1_amezomProduct 
{
	WebDriver driver;
	
	@BeforeClass
	public void browserLaunch() 
	{
		//WebDriverManager.chromedriver().setup();
		//driver = new ChromeDriver();

		WebDriverManager.edgedriver().setup();
		driver= new EdgeDriver();
		
		

		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@Test
	public void productSearch() 
	{

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		WebElement txtSearch = driver.findElement(By.id("twotabsearchtextbox"));
		wait.until(ExpectedConditions.elementToBeClickable(txtSearch));
		txtSearch.sendKeys("Iphone 14");

		WebElement srcClick = driver.findElement(By.id("nav-search-submit-button"));

		wait.until(ExpectedConditions.elementToBeClickable(srcClick));
		srcClick.click();
	}

	@Test
	public void selectProduct() throws InterruptedException 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		WebElement selectPhone = driver.findElement(By.xpath("(//div[@class='a-section']//div[@class='a-section a-spacing-small a-spacing-top-small'])[3]"));
		wait.until(ExpectedConditions.elementToBeClickable(selectPhone));
		selectPhone.click();


	}

	@AfterClass
	public void closeBrowser() 
	{
		driver.close();
		

	}

}
