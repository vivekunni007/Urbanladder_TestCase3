package userDefinedLibraries;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * This class is defined in order to implement excel read and write
 * 
 * @author Vivek Unni
 * @since 2020-11-02
 * 
 */
public class ExcelUtils {

	public static File src;
	public static String exfilepath = "C:\\Users\\user\\Documents\\TestCase_3\\src\\test\\resources\\DataTable.xlsx";
	public static FileInputStream fileip;
	public static FileOutputStream fileop;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFCell cell;
	public static XSSFRow Row;

	public static void excelConfig() {
		src = new File(exfilepath);
		try {
			fileip = new FileInputStream(src);
			workbook = new XSSFWorkbook(fileip);
			// creating sheet instance
			sheet = workbook.getSheetAt(0);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeExcel() {
		try {

			// Close input stream
			fileip.close();
			// Create an object of FileOutputStream class to create write data
			// in excel file
			fileop = new FileOutputStream(new File(exfilepath));
			// write data in the excel file
			workbook.write(fileop);
			// close output stream
			fileop.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
