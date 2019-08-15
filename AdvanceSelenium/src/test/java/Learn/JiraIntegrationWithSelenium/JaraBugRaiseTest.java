package Learn.JiraIntegrationWithSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class JaraBugRaiseTest {
	
	public WebDriver driver;
	@JiraPolacy(logTicketReady=true)
	@Parameters("browser")
	@Test
	public void loginTest(String browserName)
	{
		
			if (browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "lib/geckodriver.exe");
				driver=new FirefoxDriver();
				
				
				
			}else if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
				driver=new ChromeDriver();
			}
			else if (browserName.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver", "lib/IEDriverServer.exe");
				driver=new InternetExplorerDriver();
			}else {
				
				System.out.println("Please give proper browser name firefox/chrome/ie");
			}
			
			driver.manage().window().maximize();
			
			driver.get("http://orangehrm.uftselenium.com/symfony/web/index.php/auth/login");
		
		    String pageTitle=driver.getTitle();
		    System.out.println("PageTitle : "+pageTitle);
		   Assert.assertEquals(pageTitle, "OrangeHRM123");
		
	}

}
