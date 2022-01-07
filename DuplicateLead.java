package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

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

		// Click on Email
		driver.findElement(By.xpath("//ul[@class='x-tab-strip x-tab-strip-top']/li[3]")).click();

		// Enter Email
		driver.findElement(By.name("emailAddress")).sendKeys(("abc@gmail.com"));

		// Click find leads button
		driver.findElement(By.xpath("//button[text() = 'Find Leads']")).click();

		Thread.sleep(1000);

		// Capture name of First Resulting lead
		String leadName = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a"))
				.getText();
		System.out.println("Lead name is : " + leadName);

		// Click First Resulting lead
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a")).click();

		// Click Duplicate Lead
		driver.findElement(By.linkText("Duplicate Lead")).click();

		// Verify the title as 'Duplicate Lead'
		if (driver.getTitle().contains("Duplicate Lead"))
			System.out.println("Duplicate Lead Page Title confirmed");
		else
			System.out.println("Duplicate Lead Page Title not confirmed");

		// Click Create Lead
		driver.findElement(By.className("smallSubmit")).click();

		// Confirm the duplicated lead name is same as captured name
		if (driver.findElement(By.id("viewLead_firstName_sp")).getText().equalsIgnoreCase(leadName))
			System.out.println("Duplicated Lead Name = Captured Name");
		else
			System.out.println("Duplicated Lead Name != Captured Name");

		// Close the browser (Do not log out)
		driver.close();

	}

}
