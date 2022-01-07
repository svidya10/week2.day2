package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AcmeTest {
	
	public static void main(String[] args) {
				WebDriverManager.chromedriver().setup();
				
				ChromeDriver driver = new ChromeDriver();
				driver.get("https://acme-test.uipath.com/login");
				
				driver.manage().window().maximize();
				
			
	
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
				driver.findElement(By.xpath("//input[@id='email' and @name='email']")).sendKeys("kumar.testleaf@gmail.com");
				
				driver.findElement(By.xpath("//input[@id='password' and @name='password']")).sendKeys("leaf@12");
				
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				String title = driver.getTitle();
				System.out.println(title);
				
				driver.findElement(By.xpath("//a[text()='Log Out']")).click();
				
				driver.close();
				
	}

}
