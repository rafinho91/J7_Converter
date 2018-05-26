package pl.sda;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ExcelFileWriter implements SDAFileWriter{

    @Override
    public void write(List<Map<String, String>> models, String filePath) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("cities");

        int rowCount = 0;
        Row headerRow = sheet.createRow(rowCount++); //przekazuje 0 a nastepnie inkrementuje
        // HEADERS
        Object[] objects = models.get(0).keySet().toArray();
        String[] headers = new String[objects.length];
        for (int i = 0; i < headers.length; i++) {
            headers[i] = objects[i].toString();
        }
        // VALUES
        int cellCount = 0;
        for (String header : headers){
            Cell cell = headerRow.createCell(cellCount++);
            cell.setCellValue(header);
        }
        for (Map<String, String> model : models){
            Row row = sheet.createRow(rowCount++);
            for (int i = 0; i < headers.length; i++) {
                Cell cell = row.createCell(i);
                cell.setCellValue(model.get(headers[i]));
            }
        }
        FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath));
        workbook.write(fileOutputStream);
        fileOutputStream.close();
    }
}
