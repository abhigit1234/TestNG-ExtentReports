package TestNG;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class IntegrationExcel_DataProvider_TestMethod {
	@DataProvider
	public String[][] data() throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\tubby\\eclipse-workspace\\excel\\family.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		int rowcnt = sheet.getPhysicalNumberOfRows();
		int cellcnt = sheet.getRow(0).getPhysicalNumberOfCells();

		String[][] data =new String[rowcnt-1][cellcnt];
		
		for (int i = 0; i < rowcnt-1; i++) {
			for (int j = 0; j < cellcnt; j++) {
				XSSFCell cell = sheet.getRow(i+1).getCell(j);
				DataFormatter df = new DataFormatter();
				data[i][j] = df.formatCellValue(cell);
				}
			
		}
		wb.close();
		fis.close();
		return data;
		
//for (Object[] objects : data) {
//	System.out.println(Arrays.toString(objects));
//}
	}

}