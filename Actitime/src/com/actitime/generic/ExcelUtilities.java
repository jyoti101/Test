package com.actitime.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author jnagpal
 * reviewed by Diganta
 * created on 29/07/2018 at 12:30 PM
 */

public class ExcelUtilities 
{
	/**
	 * This method read data from excel sheet
	 * @param filepath
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return String
	 */
	public static String readData(String filepath, String sheet, int row, int cell)
	{
		String value = null;
		try {
		
		Workbook wb = WorkbookFactory.create(new FileInputStream(new File(filepath)));
		value = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		
		}
		catch(EncryptedDocumentException e)
		{
			e.printStackTrace();
		}
		catch(InvalidFormatException e)
		{
			e.printStackTrace();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}	
		return value;
	}
}
