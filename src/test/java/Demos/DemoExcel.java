package Demos;

import Utilities.ExcelUtility;

public class DemoExcel {

    public static void main(String[] args) {
        ExcelUtility.getExcelInstance("./testdata/data.xlsx", "Sheet1");
        System.out.println(ExcelUtility.getRowCount());
        System.out.println(ExcelUtility.getColCount());
        System.out.println(ExcelUtility.getCellDataString(0,0));
        System.out.println(ExcelUtility.getCellDataString(2,0));
        int rowCount = ExcelUtility.getRowCount();
        int colCount = ExcelUtility.getColCount();

        for(int i = 0 ; i < rowCount ; i++){
            for (int j = 0 ; j < colCount ; j++ ){
                System.out.print(ExcelUtility.getCellDataString( i, j) + "    |  ");  //(0,0), (0,1) // (1,0) (1,1) // (2,0) (2,1)
            }
            System.out.println();
        }



    }

}
