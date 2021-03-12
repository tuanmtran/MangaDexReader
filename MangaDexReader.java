package com.example.MangaDexReader;

import com.codeborne.selenide.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

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
					"trollny");
			webDriver.findElement(By.name("login_password")).sendKeys("tuan2001");
			webDriver.findElement(By.id("login_button")).click();
			Thread.sleep(500);
			// If anything goes wrong, print out the error.
		} catch (final Exception e) {
			System.out.println(e.getClass().toString());
		}
	}

	/**
	 *
	 */
	private static void randomPicker() {
		try {
			// Navigate to a random manga
			webDriver.navigate().to("https://mangadex.org/manga");
			
			// If anything goes wrong, print out the error.
		} catch (final Exception e) {
			System.out.println(e.getClass().toString());
		}
	}

	/**
	 *
	 */
	@SuppressWarnings("unchecked")
	private static void autoScroll() {
		try {

			// Get the url to the title page
			webDriver.findElement(By.linkText("Chapters")).click();
			String og_url = webDriver.getCurrentUrl();
			String url = og_url.substring(0, og_url.length() - 10);

			// Start with the first chapter available
			webDriver.findElements(By.linkText("Oneshot")).get(1).click();

			// auto click to next page, and next chapter
			while (!url.equals(webDriver.getCurrentUrl())) {

				//control pause between clicks
				Thread.sleep(500);
				webDriver.findElement(By.partialLinkText("MangaDex")).sendKeys(Keys.ARROW_RIGHT);
			}

		// If anything goes wrong, print out the error.
		} catch (final Exception e) {
			System.out.println(e.getClass().toString());
		}
	}
}
