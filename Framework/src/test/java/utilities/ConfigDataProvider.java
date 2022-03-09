package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {

	public Properties Pro;
	
	public ConfigDataProvider () 
	{
		File src = new File("./Config/conf.properties");
		
		try {
			FileInputStream FIL = new FileInputStream (src);
			Pro = new Properties();
			Pro.load(FIL);
		
		}  catch (Exception e) {
			System.out.println("File not found"+ e.getMessage());
		}
	}
	public String getbrowser()	{
		
		return Pro.getProperty("Browser");
	}
	public String getUrl()	{
		
		return Pro.getProperty("URL");
	}
		
	
}
