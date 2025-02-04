package selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Day8_AutoDropdown2 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.google.co.in/");
		driver.findElement(By.xpath("(//textarea[@id='APjFqb'])[1]")).sendKeys("yuvan");
		List<WebElement> auto = driver.findElements(By.xpath("//span[contains(text(),\"uvan\")]"));
		int count=auto.size();
		System.out.println(count);
		for(int i=0;i<count;i++) {
			String text = auto.get(i).getText();
			System.out.println(text);
			
			
		}
		auto.get(2).click();
		//auto.getFirst();
		//auto.getLast();
		driver.navigate().to("https://demoqa.com/select-menu");
		WebElement sel = driver.findElement(By.id("cars"));
		Select s=new Select(sel);
		List<WebElement> list = s.getOptions();
		int cou = list.size();
		System.out.println(cou);
		for(int i=0;i<cou;i++) {
			String value = list.get(i).getText();
			System.out.println(value);
			System.out.println("");
		}
		
		s.selectByVisibleText("Volvo");
		Thread.sleep(2000);
		s.selectByVisibleText("Audi");
		Thread.sleep(2000);
		s.selectByVisibleText("Opel");
		Thread.sleep(2000);
		String opt = s.getFirstSelectedOption().getText();
		System.out.println(opt);
		List<WebElement> opt1 = s.getAllSelectedOptions();
		int size=opt1.size();
		System.out.println(size);
		for(int i=0;i<size;i++) {
			String text1=opt1.get(i).getText();
			System.out.println(text1);
			System.out.println("");
		}
		String wrap = s.getWrappedElement().getText();
		System.out.println(wrap);
		System.out.println("");
		
		s.deselectByVisibleText("Audi");
		Thread.sleep(2000);
		for(int i=size-1;i>=0;i--) {
			s.deselectByIndex(i);
			Thread.sleep(2000);
			
		}
		boolean multi = s.isMultiple();
		System.out.println(multi);
		
		driver.close();
		
	}

}
