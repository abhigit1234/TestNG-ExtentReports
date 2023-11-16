package TestNG_Practice;

import java.io.*;
import java.util.*;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class integration {


	@DataProvider(parallel = true)

	public String[][] getvalues() throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\tubby\\eclipse-workspace\\excel\\IntegrationExcel.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		int rowcnt = sheet.getPhysicalNumberOfRows();
		int cellcnt = sheet.getRow(0).getLastCellNum();

		String[][] data = new String[rowcnt - 1][cellcnt];

		for (int i = 0; i < rowcnt - 1; i++) {
			for (int j = 0; j < cellcnt; j++) {

				XSSFCell cell = sheet.getRow(i + 1).getCell(j);
				DataFormatter df = new DataFormatter();
				data[i][j] = df.formatCellValue(cell);

			}
		}
		wb.close();
		fis.close();
		return data;

	}

}