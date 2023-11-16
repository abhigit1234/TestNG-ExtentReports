package TestNG;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.text.Format;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class demo2 {

	public static void main(String[] args) throws Throwable {

		FileInputStream fis = new FileInputStream("C:\\Users\\tubby\\eclipse-workspace\\excel\\dataprovider1.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");

		int rowcnt = sheet.getPhysicalNumberOfRows();
		int cellcnt = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[rowcnt-1][cellcnt];		
		
		for (int i =0; i < rowcnt-1; i++) {
			for (int j = 0; j < cellcnt; j++) {
				XSSFCell cell = sheet.getRow(i+1).getCell(j);
				DataFormatter df = new DataFormatter();
				data[i][j] = df.formatCellValue(cell);
			
			}
			}
		wb.close();
		fis.close();
	for (Object[] objects : data) {
		System.out.println(Arrays.toString(objects));
	}
		
	
	}
	
		
}