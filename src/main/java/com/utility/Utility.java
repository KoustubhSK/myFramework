package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {

	public static void getscreenshot(WebDriver driver) throws IOException {

		File s = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		File d = new File("C:/Users/hp/OneDrive/Desktop/SS/failed.png");

		FileUtils.copyFile(s, d);

	}

	public static String getdatafromexcel(int row ,int cell) throws EncryptedDocumentException, IOException {

		String data;

		FileInputStream excel = new FileInputStream("C:/Users/hp/eclipse-workspace/June2020/TestData/TestingData.XLSX");

		Sheet outdata = WorkbookFactory.create(excel).getSheet("sheet1");

		try {

			data = outdata.getRow(row).getCell(cell).getStringCellValue();
		}

		catch (Exception e) {

			long uv = (long) outdata.getRow(row).getCell(cell).getNumericCellValue();

			data = ("" + uv);

		}
		
		return data;

	}

}
