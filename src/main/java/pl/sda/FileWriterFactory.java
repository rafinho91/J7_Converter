package pl.sda;

import java.io.IOException;
import java.util.List;
import java.util.Map;
//todo dokonczyc plus napisac testowanie
public class FileWriterFactory {
    public static void write(List<Map<String ,String >> models, String filePath) throws IOException {
        SDAFileWriter fileWriter;
        String fileType = filePath.substring(filePath.lastIndexOf(".") + 1);
        switch(fileType) {
            case "csv":
                fileWriter = new CSVFileWriter();
                fileWriter.write(models, filePath);
            case "xlsx":
                fileWriter = new ExcelFileWriter();
                fileWriter.write(models, filePath);
            case "json":
                fileWriter = new JSONFileWriter();
                fileWriter.write(models, filePath);
        }
    }
}
