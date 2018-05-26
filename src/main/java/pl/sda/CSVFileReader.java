package pl.sda;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CSVFileReader implements SDAFileReader{
    public List<Map<String ,String >> read(String filePath) throws IOException {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String[] headers = null;
        String line;
        List<Map<String ,String>> models = new ArrayList<>();

        int i =0;
        while ((line = bufferedReader.readLine()) != null && !line.isEmpty()){
            if (i == 0) {
                headers = line.split(";");
                i++;
            } else {
                Map<String ,String > parsedModel = parseModelRow(headers, line);
                models.add(parsedModel);
            }
        }
        return models;
    }

    private Map<String ,String > parseModelRow(String[] headers, String line) {
        Map<String ,String > model = new LinkedHashMap<>();
        String[] values = line.split(";");
        for (int i = 0; i < headers.length; i++) {
            model.put(headers[i], values[i]);
        }
        return model;
    }
}
