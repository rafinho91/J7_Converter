package pl.sda;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CSVFileWriter implements SDAFileWriter{
    public void write(List<Map<String ,String >> models, String filePath){
        try {
            FileWriter fileWriter = new FileWriter(filePath);
//            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            StringBuilder stringBuilder = new StringBuilder();
            int i =0;
            Set<String> keys = models.get(0).keySet();
            Iterator<String> headers = keys.iterator();
            while (headers.hasNext()) {
                stringBuilder.append(headers.next()).append(";");
            }
            stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());
            stringBuilder.append("\n");
            while (i < models.size()){
                Map<String, String> model = models.get(i);
                Set<Map.Entry<String, String>> entries = model.entrySet();
                Iterator<Map.Entry<String, String>> iterator = entries.iterator();
                while(iterator.hasNext()) {
                    String next = iterator.next().getValue();
                    stringBuilder.append(next);
                    stringBuilder.append(";");
                }
                stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());
                stringBuilder.append("\n");
                i++;
            }
            fileWriter.write(stringBuilder.toString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
