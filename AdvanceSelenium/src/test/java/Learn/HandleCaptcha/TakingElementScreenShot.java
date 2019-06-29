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

public class TakingElementScreenShot {

	public static void main(String[] args) throws IOException, TesseractException, InterruptedException {
		
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		
		WebDriver driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//a[@id='loginText']")).click();
		
		
		driver.findElement(By.xpath("//*[@id='userId']")).sendKeys("srinu07473");
		driver.findElement(By.xpath("//*[@id='pwd']")).sendKeys("538925");
		
		Thread.sleep(4000);
		WebElement ele=driver.findElement(By.xpath(".//img[@id='nlpCaptchaImg']"));
		
		File  sr= ele.getScreenshotAs(OutputType.FILE);
		String imageFile="screenSnaps/ImageFile.png";
		
		FileHandler.copy(sr, new File(imageFile));
		
		ITesseract image=new Tesseract();
		
		String imageText=image.doOCR(new File(imageFile));
		
		System.out.println("Text Data from Image ::: \n"+imageText);
		
		
		

	}

}
