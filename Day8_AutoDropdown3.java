package selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver ;
import org.openqa.selenium.support.ui.Select;

public class Day8_AutoDropdown3 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    driver.navigate().to("https://qavbox.github.io/demo/signup/");
		WebElement select = driver.findElement(By.name("sgender"));
		Select s=new Select(select);
		s.selectByVisibleText("Male");
		Thread.sleep(2000);
		WebElement tools = driver.findElement(By.id("tools"));
		Select s1=new Select(tools);
		List<WebElement> len = s1.getOptions();
		int count = len.size();
		System.out.println(count);
		for(int i=0;i<count;i++) {
			String text = len.get(i).getText();
			System.out.println(text);
			System.out.println("");
		}
		boolean multi = s1.isMultiple();
		System.out.println(multi);
		for(int i=0;i<count;i++) {
			s1.selectByIndex(i);
			Thread.sleep(3000);
		}
		String first = s.getFirstSelectedOption().getText();
		System.out.println(first);
		List<WebElement> all = s1.getAllSelectedOptions();
		int count1=all.size();
		for(int i=0;i<count1;i++) {
			String text1 = all.get(i).getText();
			System.out.println(text1);
			System.out.println("");
		}
		String wrap = s1.getWrappedElement().getText();
		System.out.println(wrap);
		System.out.println("");
		for(int i=count1-1;i>=0;i--) {
			s1.deselectByIndex(i);
			Thread.sleep(2000);
		}
		driver.close();
		
		
		
	}

}
