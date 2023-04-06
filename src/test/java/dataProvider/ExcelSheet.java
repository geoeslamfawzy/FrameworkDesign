package dataProvider;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class ExcelSheet {
    /*@Test(dataProvider = "getExcelData")
    public void testExcelData(Map<String, String> map){
        System.out.println(map.get("password"));
    }
    @DataProvider
    public Object[] getExcelData() throws IOException {
        String filePath = System.getProperty("user.dir") + "\\src\\test\\java\\data\\userData.xlsx";
        FileInputStream fileInputStream = new FileInputStream(filePath);

        //1- Maka an object that reads the file and understand excel sheet data
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        //2- from the file, we need to read the sheet (as the excel file contains multiple sheets)
        XSSFSheet sheet = workbook.getSheetAt(0);

        //3- Parse the data in the excel sheet into this array
        int rowNum = sheet.getLastRowNum();
        int colNum = sheet.getRow(0).getLastCellNum();
        //Object[][] data = new Object[rowNum][colNum]; // 9 rows and 4 iterations
        Object[] data= new Object[rowNum];
        HashMap<String, String> map;
        for(int i=1; i<rowNum; i++){ //This to ignore the header
            map = new HashMap<>();
            for(int j=0; j<colNum; j++){
                String key = sheet.getRow(0).getCell(j).getStringCellValue();
                String value = sheet.getRow(i).getCell(j).getStringCellValue();
                map.put(key, value);
                data[i-1] = map;
            }
        }
        return data;
    }*/
}
