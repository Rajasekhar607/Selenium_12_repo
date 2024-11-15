package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	/*
	 * This method is used to read String data from excel
	 * user must pass sheet name,row index,column index
	 * @param sheetName
	 * @Param rowIndex
	 * @param colindex
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
   public String dataFromExcel(String sheetName,int rowIndex,int colIndex) throws EncryptedDocumentException, IOException {
	   FileInputStream fis=new FileInputStream("./src/test/resources/TestData/Testscriptdata.xlsx");
	Workbook workBook = WorkbookFactory.create(fis);
   return workBook.getSheet(sheetName).getRow(rowIndex).getCell(colIndex).getStringCellValue();
	   
   }
   public boolean booleanDataFromExcel(String sheetName,int rowIndex,int colIndex) throws EncryptedDocumentException, IOException {
	   FileInputStream fis=new FileInputStream("./src/test/resources/TestData/Testscriptdata.xlsx");
	   Workbook workBook = WorkbookFactory.create(fis);
	   return workBook.getSheet(sheetName).getRow(rowIndex).getCell(colIndex).getBooleanCellValue();
   }
   public double NumericDataFromExcel(String sheetName,int rowIndex,int colIndex) throws EncryptedDocumentException, IOException {
	   FileInputStream fis=new FileInputStream("./src/test/resources/TestData/Testscriptdata.xlsx");
	   Workbook workBook = WorkbookFactory.create(fis);
	   return workBook.getSheet(sheetName).getRow(rowIndex).getCell(colIndex).getNumericCellValue();
	   
   }
   public LocalDateTime dataFromExcel1(String sheetName,int rowIndex,int colIndex) throws EncryptedDocumentException, IOException {
	   FileInputStream fis=new FileInputStream("./src/test/resources/TestData/Testscriptdata.xlsx");
	   Workbook workBook = WorkbookFactory.create(fis);
	   return workBook.getSheet(sheetName).getRow(rowIndex).getCell(colIndex).getLocalDateTimeCellValue();
   }
   
}
