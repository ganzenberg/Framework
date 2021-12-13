package utilities;
import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	public static void captureScreenshot(WebDriver driver)
	{
	
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileHandler.copy(src, new File("./Screenshots/Login.png"));
		} catch (Exception e) {
			System.out.println("unable to capture"+ e.getMessage());
		}
		
	}
	
}
