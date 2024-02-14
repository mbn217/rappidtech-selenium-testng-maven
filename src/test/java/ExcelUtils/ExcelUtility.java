package ExcelUtils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelUtility {
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    /**
     *
     * @param filePath  the path to the excel file
     * @param sheetName the sheet name insdie your workbook : example "Sheet1"
     */
    public  static void getExcelInstance( String filePath , String sheetName){
        try {
            workbook = new XSSFWorkbook(filePath);
            sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @return the number of rows present in the Excel sheet
     */
    public static int getRowCount(){
        int  rowCount = sheet.getPhysicalNumberOfRows();
        System.out.println("No of Rows : " + rowCount);
        return rowCount;
    }

    /**
     *
     * @return the number of column present in the Excel sheet
     */
    public static int getColCount(){
        int colCount = sheet .getRow(0).getPhysicalNumberOfCells();
        return colCount;
    }

    public static String getCellDataString(int rowNum , int colNum){
        String cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
        return cellData;
    }







}
