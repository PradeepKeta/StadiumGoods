package com.StadiumGoods.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestShopping {

	public static WebDriver driver;
	public String appUrl = "https://stadium:goods2018!@stage.stadiumgoods.cloud";

	@BeforeTest
	public void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pradeepk\\Documents\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(appUrl);
		driver.manage().window().maximize();
	}

	@Test
	public void verifyCheckoutFlow() throws InterruptedException {

		Boolean isPresent = driver.findElements(By.className("klaviyo_close_modal")).size() > 0;
		if (isPresent) {
			try {
				driver.findElement(By.className("klaviyo_close_modal")).click();
			} catch (Exception e) {

			}
		}

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)");

		// driver.findElement(By.xpath("//*[@id=\"top\"]/body/div[2]/div[1]/div[2]/div/div/div/div[4]/section/ul/li[1]/a/img")).click();
		driver.findElement(
				By.xpath("//*[@id=\"top\"]/body/div[2]/div[1]/div[2]/div/div/div/div[4]/section/ul/li[8]/div/div[1]/a"))
				.click();
		Thread.sleep(3000);
		Boolean isPresent2 = driver.findElements(By.className("klaviyo_close_modal")).size() > 0;
		if (isPresent2) {
			try {
				driver.findElement(By.className("klaviyo_close_modal")).click();
			} catch (Exception e) {

			}
		}
		driver.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div[2]/div[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div[2]/div[2]/label[1]/span")).click();

		driver.findElement(
				By.xpath("//*[@id=\"product_addtocart_form\"]/section/div[1]/div[4]/div[2]/div[2]/div[2]/button"))
				.click();

		Thread.sleep(2000);
		Boolean isPresent3 = driver.findElements(By.className("klaviyo_close_modal")).size() > 0;
		if (isPresent3) {
			try {
				driver.findElement(By.className("klaviyo_close_modal")).click();
			} catch (Exception e) {

			}
		}
		driver.findElement(By.xpath("//*[@id=\"slider-cart\"]/div/div/div[2]/div[1]/div[2]/div/ul/li[1]/button"))
				.click();
		// Wait for 5 Sec
		Thread.sleep(2000);
		Boolean isPresent4 = driver.findElements(By.className("klaviyo_close_modal")).size() > 0;
		if (isPresent4) {
			try {
				driver.findElement(By.className("klaviyo_close_modal")).click();
			} catch (Exception e) {

			}
		}
		driver.findElement(By.name("checkout_method")).click();

		driver.findElement(By.id("onepage-guest-register-button")).click();

		Thread.sleep(2000);

		driver.findElement(By.id("shipping:email")).sendKeys("helloh1@gmail.com");

		driver.findElement(By.id("shipping:firstname")).sendKeys("John");

		driver.findElement(By.id("shipping:lastname")).sendKeys("Parker");

		driver.findElement(By.id("shipping:street1")).sendKeys("123 street");

		driver.findElement(By.id("shipping:city")).sendKeys("courtland");

		Select sec = new Select(driver.findElement(By.id("shipping:region_id")));
		sec.selectByVisibleText("Alabama");

		driver.findElement(By.id("shipping:postcode")).sendKeys("35618");

		driver.findElement(By.id("shipping:telephone")).sendKeys("1230001234");

		driver.findElement(By.xpath("//*[@id=\"shipping-buttons-container\"]/button")).click();

		Thread.sleep(5000);
		Boolean isPresent5 = driver.findElements(By.className("klaviyo_close_modal")).size() > 0;
		if (isPresent5) {
			try {
				driver.findElement(By.className("klaviyo_close_modal")).click();
			} catch (Exception e) {

			}
		}

		driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button")).click();

		Thread.sleep(2000);
		Boolean isPresent6 = driver.findElements(By.className("klaviyo_close_modal")).size() > 0;
		if (isPresent6) {
			try {
				driver.findElement(By.className("klaviyo_close_modal")).click();
			} catch (Exception e) {

			}
		}

		driver.findElement(By.id("p_method_creditcard")).click();

		driver.findElement(By.id("creditcard_cc_number")).sendKeys("4242424242424200");

		Select secExp = new Select(driver.findElement(By.id("creditcard_expiration")));
		secExp.selectByIndex(1);

		Select secExpYr = new Select(driver.findElement(By.id("creditcard_expiration_yr")));
		secExpYr.selectByIndex(3);

		driver.findElement(By.id("creditcard_cc_cid")).sendKeys("3561");

		driver.findElement(By.xpath("//*[@id=\"creditcard_cc_type_cvv_div\"]/div[2]/div/input")).sendKeys("35618");

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"review-buttons-container\"]/button")).click();

		Thread.sleep(8000);

		String expectedResult = "Thank You!";
		String actualResult = driver
				.findElement(By.xpath("//*[@id=\"top\"]/body/div[2]/div[1]/div[2]/div/div/div[1]/h1")).getText();

		Assert.assertEquals(actualResult, expectedResult);

	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
