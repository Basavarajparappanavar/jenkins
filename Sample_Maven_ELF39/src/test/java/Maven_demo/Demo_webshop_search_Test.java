package Maven_demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo_webshop_search_Test {
@Test
public void TC_Search() {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	driver.get("https://demowebshop.tricentis.com");
	driver.findElement(By.id("small-searchterms")).sendKeys("Books");
	driver.findElement(By.cssSelector("input[value='Search']")).click();
	driver.close();
}
}
