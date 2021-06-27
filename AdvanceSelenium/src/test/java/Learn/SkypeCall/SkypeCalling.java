package Learn.SkypeCall;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SkypeCalling {

	public static void main(String[] args) {
		

		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		
		WebDriver d=new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://globfone.com/call-phone/");
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d.findElement(By.xpath("//input[@id='call-number']")).sendKeys("8885103234");
		JavascriptExecutor js=(JavascriptExecutor)d;
		js.executeScript("window.scrollBy(0,500)");
		d.findElement(By.xpath("//a[text()='call']")).click();

	}

}
