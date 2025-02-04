package selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Day8_AutoDropdown {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.navigate().refresh();
		driver.manage().deleteAllCookies();
		driver.get("https://demo.automationtesting.in/AutoComplete.html");
		driver.findElement(By.id("searchbox")).sendKeys("Ind");
		List<WebElement> sugg = driver.findElements(By.xpath("//a[contains(text(),'Ind')]"));
		sugg.get(2).click();
		String acttext = driver.findElement(By.className("ui-autocomplete-multiselect-item")).getText();
		System.out.println(acttext);
		String exptext="India";
		if(exptext.equals(acttext)) {
			System.out.println("Dropdown handled");
		}
		else {
			System.out.println("Invalid");
		}
		driver.navigate().to("https://codenboxautomationlab.com/registration-form/");
		WebElement select = driver.findElement(By.id("nf-field-22"));
		Select s2=new Select(select);
		s2.selectByVisibleText("Selenium Automation");
		WebElement select2 = driver.findElement(By.id("nf-field-24"));
		Select s3=new Select(select2);
		s3.selectByVisibleText("March");
			Thread.sleep(3000);
		String text = driver.findElement(By.id("nf-field-24")).getText();
		System.out.println(text);
		if(text.equals("March")) {
			System.out.println("Handled successfully");
		}
		else {
			System.out.println("Not Handled");
		}
			
		driver.manage().window().minimize();
		driver.close();
		
		
		
		
	
	}

}
