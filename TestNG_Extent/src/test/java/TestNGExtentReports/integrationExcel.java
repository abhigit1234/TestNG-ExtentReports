package TestNGExtentReports;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class integrationExcel {

	@DataProvider(name = "abhi")
	@Test
	public Object[][] getvalues() throws IOException {

		FileInputStream fis = new FileInputStream("C:\\Users\\tubby\\eclipse-workspace\\excel\\IntegrationExcel.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");

		int rowcnt = sheet.getPhysicalNumberOfRows();
		int cellcnt = sheet.getRow(0).getPhysicalNumberOfCells();

		Object[][] data = new Object[rowcnt-1][cellcnt];
		for (int i = 0; i < rowcnt-1; i++) {
			for (int j = 0; j < cellcnt; j++) {
				
				XSSFRow row = sheet.getRow(i+1);
				XSSFCell cell = row.getCell(j);
				DataFormatter df = new DataFormatter();
				data[i][j] = df.formatCellValue(cell);

			}
		}

		wb.close();
		fis.close();
		

		return data;

//		for(Object[] obj : data) {
//		System.out.println(	Arrays.toString(obj));
//		}
		
		
	}
}
