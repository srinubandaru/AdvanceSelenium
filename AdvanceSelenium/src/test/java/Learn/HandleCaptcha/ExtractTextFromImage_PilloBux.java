package Learn.HandleCaptcha;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class ExtractTextFromImage_PilloBux {

	public static void main(String[] args) throws IOException, TesseractException, InterruptedException {
		
		//WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		
		System.setProperty("webdriver.gecko.driver", "lib/geckodriver.exe");
		
		//ChromeOptions opt=new ChromeOptions();
		//opt.addArguments("--disable-notifications");
		
		//WebDriver driver=new ChromeDriver(opt);
		
		//WebDriver driver=new ChromeDriver();
		
		WebDriver driver=new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.get("https://pillowbux.com");
		Thread.sleep(3000);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@ng-if='!isLoggedIn']")).click();
		driver.findElement(By.xpath("//a[@ng-if='!isLoggedIn']")).click();
		
		Thread.sleep(4000);
		//driver.findElement(By.xpath("//input[@id='name']")).click();
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("srinubandaru1990@gmail.com");
		System.out.println(" login Text Box :::::: ");
		//driver.findElement(By.xpath("//input[@id='email'][@name='password']")).click();
		driver.findElement(By.xpath("//input[@id='email'][@name='password']")).sendKeys("myPB#1681");
		System.out.println(" Password Text Box :::::: ");
		driver.findElement(By.xpath(".//button[@title='Sign In']")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//a[text()='Start Solving Now!']")).click();
		Thread.sleep(3000);
		
		
	
		WebElement ele=driver.findElement(By.xpath(".//img[@id='captchaimg']"));
		
		File  sr= ele.getScreenshotAs(OutputType.FILE);
		String imageFile="screenSnaps/ImageFile.png";
		
		FileHandler.copy(sr, new File(imageFile));
		
		ITesseract image=new Tesseract();
		
		String imageText=image.doOCR(new File(imageFile));
		
		System.out.println("Text Data from Image ::: \n"+imageText);
		
		
		

	}

}
