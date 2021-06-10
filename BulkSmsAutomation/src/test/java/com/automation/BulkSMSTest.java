package com.automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class BulkSMSTest extends DriverSetup {

	public static String baseURL = "http://159.89.38.11/login";

	@Test
	public static void Test() throws InterruptedException {
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(1000);

		// Login Section

		WebElement gmail = driver.findElement(By.xpath("//input[contains(@name,'username')]"));
		gmail.sendKeys("test@orangetoolz.com");

		Thread.sleep(15);

		WebElement password = driver.findElement(By.xpath("//input[contains(@name,'password')]"));
		password.sendKeys("8Kh8nTe*^jdk");
		Thread.sleep(20);

		driver.findElement(By.xpath("//button[contains(@id,'m_login_signin_submit')]")).click();
		
		//Slide bar Section
		WebElement slidebar = driver.findElement(By.xpath("//aside[contains(@id,'main-sidebar')]"));
		Actions actionProvider = new Actions(driver);
		actionProvider.clickAndHold(slidebar).build().perform();
		
		//Profile Section
		driver.findElement(By.xpath("//a[contains(@href,'http://159.89.38.11/profile')]")).click();
		
		driver.findElement(By.xpath("//input[contains(@name,'first_name')]")).clear();
		driver.findElement(By.xpath("//input[contains(@name,'first_name')]")).sendKeys("Adam");
		driver.findElement(By.xpath("//input[contains(@name,'last_name')]")).sendKeys("Smith");
		
		driver.findElement(By.xpath("//input[contains(@name,'phone')]")).clear();
		driver.findElement(By.xpath("//input[contains(@name,'phone')]")).sendKeys("12345678");
		
		driver.findElement(By.xpath("//textarea[contains(@name,'address')]")).clear();
		driver.findElement(By.xpath("//textarea[contains(@name,'address')]")).sendKeys("Road No -03, House No -35,\r\n"
				+ "		Block-A, Mirpur-12, Dhaka-1216");
						
		driver.findElement(By.xpath("//button[contains(normalize-space(),'Save changes')]")).submit();
		Thread.sleep(30);
	}

}
