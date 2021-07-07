package findinghospitals;

import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

public class WritingExcelFile {
			
	public static XSSFWorkbook workbook;
	public static void writeExcel(List<WebElement> clist) throws InterruptedException {
		//XSSFWorkbook
		workbook = new XSSFWorkbook();
		//XSSFSheet
		XSSFSheet sheet = workbook.createSheet("Hospitals");
		//Writing the data
	
		for(int list =0; list < clist.size(); list++) {
			
			Row row = sheet.createRow(list);
			Cell cell = row.createCell(0);
			cell.setCellValue(clist.get(list).getText());
	    }        
	try {
			FileOutputStream file = new FileOutputStream("Output.xlsx");
			workbook.write(file);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}



