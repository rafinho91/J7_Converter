package pl.sda;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ExcelFileReader implements SDAFileReader{
    @Override
    public List<Map<String, String>> read(String filePath) throws IOException {
        List<Map<String, String>> models = new ArrayList<>();

        FileInputStream inputStream = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(inputStream);

        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();

//        List<String> headers = new ArrayList<>();
        Row headerRow = rowIterator.next();
        Iterator<Cell> headerRowIterator = headerRow.iterator();
        String[] headers = new String[headerRow.getPhysicalNumberOfCells()];

        int i = 0;
        while (headerRowIterator.hasNext()) {
            Cell cell = headerRowIterator.next();
            headers[i] = cell.getStringCellValue();
            i++;
        }

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Map<String, String> model = new LinkedHashMap<>();
            i = 0;
            Iterator<Cell> cellIterator = row.iterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                String value;
                value = cell.getCellTypeEnum().equals(CellType.NUMERIC) ?
                        String.valueOf((int)cell.getNumericCellValue()) : cell.toString();
                model.put(headers[i],value);
                i++;
            }
            models.add(model);
        }
        return models;
    }
}
