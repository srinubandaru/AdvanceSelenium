package Learn.HandleCaptcha;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class ToReadImages {

	public static void main(String[] args) throws IOException {
		
	ITesseract image=new Tesseract();
		
		try {
			
			//C:\Users\srinu\git\AdvanceSelenium\AdvanceSelenium\screenSnaps\PilloBuxCaptchaImage.PNG
			//File file=new File("dataFiles/ImageforText2.png");
		
		File file=new File("screenSnaps/PilloBuxCaptchaImage2.PNG");
			if (file.exists()) {
				System.out.println(file.getCanonicalPath()+ "  Yes File Exist ");
				
			}
			
			//String imageText=image.doOCR(new File("C:\\Users\\srinu\\git\\AdvanceSelenium\\AdvanceSelenium\\dataFiles\\ImageForText.png"));
			
			String imageText=image.doOCR(file);
			
			System.out.println("Text Data from Image ::: \n"+imageText);
			
			
		} catch (TesseractException e) {
			
			System.out.println("Exception : "+e.getMessage());
			// TODO Auto-generated catch block
		
		}
		
		

	}

}
