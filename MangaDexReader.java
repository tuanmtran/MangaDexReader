package com.example.MangaDexReader;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 */
public class MangaDexReader {
	static WebDriver webDriver;
	static boolean reading = true;

	/**
	 *
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(final String[] args) throws InterruptedException {
		// Telling the system where to find the chrome driver
		System.setProperty(
                "webdriver.chrome.driver",
                "C://Users//tuans//Desktop//Webdriver//chromedriver.exe");
		// Open Chrome browser
		webDriver = new ChromeDriver();

		testlogin();
		while (reading) {
			randomPicker();
			autoScroll();
		}
	}

	/**
	 *
	 */
	private static void testlogin() {
		try {
			// Open MangaDex
			webDriver.navigate().to("https://mangadex.org/login");

			// Login
			webDriver.findElement(By.name("login_username")).sendKeys(
					"your username");
			webDriver.findElement(By.name("login_password")).sendKeys("your pw");
			webDriver.findElement(By.id("login_button")).click();

			// If anything goes wrong, return false.
		} catch (final Exception e) {
			System.out.println(e.getClass().toString());
		}
	}

	/**
	 *
	 */
	private static void randomPicker() {
		try {
			//will naviagte to a random manga
			webDriver.navigate().to("https://mangadex.org/manga");
			
			// If anything goes wrong, return false.
		} catch (final Exception e) {
			System.out.println(e.getClass().toString());
		}
	}

	/**
	 *
	 */
	private static void autoScroll() {
		try {
			// Start with the first chapter avalaible
			//String id =
					//webDriver.findElements(By.id("data-id")).get(0).getText();
			//webDriver.navigate().to("https://mangadex.org/chapter/" + id);

			webDriver.findElements(By.className("text-truncate")).get(0).click();


			// auto click to next page
			int total = Integer.parseInt(
					webDriver.findElement(By.className("total-pages")).getText());
			for (int i = 1; i < total; i++) {
				Thread.sleep(5000);
				webDriver.navigate().to("https://mangadex.org/chapter/"); //+
				// id +
						//"/" + i);
			}

		// If anything goes wrong, return false.
		} catch (final Exception e) {
			System.out.println(e.getClass().toString());
		}
	}
}
