package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		// Open browser
		ChromeDriver driver = new ChromeDriver();

		// Load url
		driver.get("http://leaftaps.com/opentaps/");

		// maxi
		driver.manage().window().maximize();

		// enter username
		WebElement userName = driver.findElement(By.id("username"));

		userName.sendKeys("DemoCSR");

		// enter password
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// Login
		driver.findElement(By.className("decorativeSubmit")).click();

		// Click CRM/SFA
		driver.findElement(By.linkText("CRM/SFA")).click();

		// Click Leads Link
		driver.findElement(By.linkText("Leads")).click();

		// Click Find Leads
		driver.findElement(By.linkText("Find Leads")).click();

		// Click on Phone
		driver.findElement(By.xpath("//ul[@class='x-tab-strip x-tab-strip-top']/li[2]")).click();

		// Enter Phone Number
		driver.findElement(By.name("phoneCountryCode")).clear();
		driver.findElement(By.name("phoneCountryCode")).sendKeys(("1"));
		driver.findElement(By.name("phoneAreaCode")).sendKeys(("800"));
		driver.findElement(By.name("phoneNumber")).sendKeys(("123456"));

		// Click find leads button
		driver.findElement(By.xpath("//button[text() = 'Find Leads']")).click();

		Thread.sleep(1000);

		// Capture lead ID of First Resulting lead
		String leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"))
				.getText();
		System.out.println("Lead ID is : " + leadID);

		// Click First Resulting lead
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();

		// Click Delete
		driver.findElement(By.linkText("Delete")).click();

		// Click Find Leads
		driver.findElement(By.linkText("Find Leads")).click();

		// Enter captured lead ID
		driver.findElement(By.name("id")).sendKeys(leadID);

		// Click find leads button
		driver.findElement(By.xpath("//button[text() = 'Find Leads']")).click();

		Thread.sleep(1000);

		// Verify message "No records to display" in the Lead List. This message
		// confirms the successful deletion

		// String temp = driver.findElement(By.className("x-paging-info")).getText();
		if (driver.findElement(By.className("x-paging-info")).getText().contains("No records to display"))
			System.out.println("Lead deletion successful");
		else
			System.out.println("Lead deletion not successful");

		// Close the browser (Do not log out)
		driver.close();
	}

}
