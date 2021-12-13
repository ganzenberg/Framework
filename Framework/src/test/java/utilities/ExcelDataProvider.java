package utilities;
import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook WB;
	
	public ExcelDataProvider() {
		
		File src = new File("./Config/Accept.xlsx");
		
		try {
			FileInputStream FIS = new FileInputStream (src);
			WB = new XSSFWorkbook(FIS);
		} catch (Exception e) {
			System.out.println("File not found"+ e.getMessage());
		}
	}
	
	public String getStringData(String sheet,int user, int Password) {
		
		return WB.getSheet(sheet).getRow(user).getCell(Password).getStringCellValue();
	}
}
