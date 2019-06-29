package Learn.AdvanceSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchBrowser {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "lib//geckodriver.exe");
		WebDriver driver=new FirefoxDriver();

	}

}
