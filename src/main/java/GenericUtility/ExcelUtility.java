package GenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelUtility {
    public String excelUtility(String sheet, int row, int col) throws Exception {

        try (FileInputStream f = new FileInputStream("./src/test/resources/ninzaHRM.xlsx");
        Workbook wb = WorkbookFactory.create(f)) 
        {
            DataFormatter formatter = new DataFormatter();
            Sheet sh = wb.getSheet(sheet);

            if (sh == null) {
                throw new IllegalArgumentException("Sheet not found: " + sheet);
            }

            Row r = sh.getRow(row);

            // If the entire row is empty or missing
            if (r == null) {
                return "";
            }

            // If the cell is empty or missing
            return formatter.formatCellValue(r.getCell(col, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL));
        }
    }  
    
    public void writeDataInExcel(String sh, int row, int cell, String data) throws Exception 
    {
    	FileInputStream fis = new FileInputStream("./src/test/resources/ninzaHRM.xlsx");
    	Workbook wb = WorkbookFactory.create(fis) ;
    	
    	wb.getSheet(sh).getRow(row).getCell(cell).setCellValue(data);
    	
    	FileOutputStream fos = new FileOutputStream("./src/test/resources/ninzaHRM.xlsx");
    	wb.write(fos);
    }
}
