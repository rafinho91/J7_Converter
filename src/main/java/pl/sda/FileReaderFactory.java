package pl.sda;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
//todo testowanie dopisac
public class FileReaderFactory {
    public static List<Map<String, String>> read(String filePath) throws IOException {
        SDAFileReader fileReader;
        String fileType = filePath.substring(filePath.lastIndexOf(".") + 1);
        switch(fileType) {
            case "csv":
                fileReader = new CSVFileReader();
                return fileReader.read(filePath);
            case "xlsx":
                fileReader = new ExcelFileReader();
                return fileReader.read(filePath);
            case "json":
                fileReader = new JSONFileReader();
                return fileReader.read(filePath);
        }
        return null;
    }
}
