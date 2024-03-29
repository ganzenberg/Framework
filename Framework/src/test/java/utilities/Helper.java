package utilities;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	public static String captureScreenshot(WebDriver driver)
	{
	
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotpath = System.getProperty("user.dir")+"./Screenshots/Login"+getCurrentDatetime()+".png";
		
		try {
			FileHandler.copy(src, new File(screenshotpath));
		} catch (Exception e) {
			System.out.println("unable to capture"+ e.getMessage());
		}
		return screenshotpath;
	}
	

	public static String getCurrentDatetime() {
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customFormat.format(currentDate);
	}
	
}
