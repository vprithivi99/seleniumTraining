/* Decompiler 11ms, total 914ms, lines 55 */
package selenium;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {
   public static void main(String[] args) throws InterruptedException {
      WebDriver driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
      driver.manage().window().maximize();
      driver.get("https://www.amazon.in/");
      String url = driver.getCurrentUrl();
      System.out.println(url);
      String title = driver.getTitle();
      System.out.println(title);
      if (url.contains("amazon.in")) {
         System.out.println("Url is same");
      }

      if (title.contains("Books")) {
         System.out.println("Books Mentioned In Title");
      }

      boolean logo = driver.findElement(By.cssSelector("#nav-logo-sprites")).isDisplayed();
      if (logo) {
         System.out.println("Amazonn Logo is Present");
      }

      driver.findElement(By.id("twotabsearchtextbox")).clear();
      driver.findElement(By.id("twotabsearchtextbox")).sendKeys(new CharSequence[]{"Mobiles"});
      boolean but = driver.findElement(By.id("nav-search-submit-button")).isEnabled();
      if (but) {
         System.out.println("Search button is enabled");
      } else {
         System.out.println("Button is Disabled");
      }

      driver.findElement(By.id("nav-search-submit-button")).submit();
      driver.findElement(By.id("a-autoid-1-announce")).click();
      driver.findElement(By.id("nav-cart-count-container")).click();
      String price = driver.findElement(By.cssSelector("span[id='sc-subtotal-amount-activecart'] span[class='a-size-medium a-color-base sc-price sc-white-space-nowrap']")).getText();
      System.out.println(price);
      driver.findElement(By.cssSelector("input[value='Proceed to checkout']")).click();
      driver.findElement(By.name("email")).sendKeys(new CharSequence[]{"8072250341"});
      driver.findElement(By.cssSelector("input[type='submit']")).click();
      driver.findElement(By.id("ap_password")).sendKeys(new CharSequence[]{"mohanraj7471"});
      driver.findElement(By.id("signInSubmit")).click();
      driver.findElement(By.cssSelector("input[data-testid='Address_selectShipToThisAddress']")).click();
      Thread.sleep(6000L);
      driver.findElement(By.xpath("(//input[@id='pp-76VjnE-99'])[1]")).sendKeys(new CharSequence[]{"mohan"});
   }
}
