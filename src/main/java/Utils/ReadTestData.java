package Utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadTestData {

    String homeDir = System.getProperty("user.dir");
    String testDataDir =homeDir+ "src\\main\\java\\TestData\\OrderFormData.xlsx";
    FileInputStream fis = new FileInputStream(testDataDir);
    XSSFWorkbook workbook = new XSSFWorkbook(fis);

    public ReadTestData() throws IOException {
    }
    XSSFSheet sheet = workbook.getSheetAt(0);

    public String name = sheet.getRow(1).getCell(0).getStringCellValue();
    public String name1 = sheet.getRow(2).getCell(0).getStringCellValue();
    public String country = sheet.getRow(1).getCell(1).getStringCellValue();
    public String country1 = sheet.getRow(2).getCell(1).getStringCellValue();
    public String city = sheet.getRow(1).getCell(2).getStringCellValue();
    public String city1 = sheet.getRow(2).getCell(2).getStringCellValue();
    public String creditCard = sheet.getRow(1).getCell(3).getStringCellValue();
    public String creditCard1 = sheet.getRow(2).getCell(3).getStringCellValue();
    public String month = sheet.getRow(1).getCell(4).getStringCellValue();
    public String month1 = sheet.getRow(2).getCell(4).getStringCellValue();
    public String year = sheet.getRow(1).getCell(5).getStringCellValue();
    public String year1 = sheet.getRow(2).getCell(5).getStringCellValue();

}
