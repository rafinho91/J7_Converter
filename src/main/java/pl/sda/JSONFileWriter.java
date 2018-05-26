package pl.sda;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JSONFileWriter implements SDAFileWriter{

    @Override
    public void write(List<Map<String, String>> models, String filePath) throws IOException {
        FileWriter fileWriter = new FileWriter(filePath);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        JSONArray jsonArray = new JSONArray();

        Object[] objects = models.get(0).keySet().toArray();
        String[] headers = new String[objects.length];
        for (int i = 0; i < headers.length; i++) {
            headers[i] = objects[i].toString();
        }
        for (Map<String, String> model : models){
            JSONObject jsonObject = new JSONObject();
            for (int j = 0; j < headers.length; j++) {
                jsonObject.put(headers[j],model.get(headers[j]));
            }
            jsonArray.put(jsonObject);
        }
        JSONObject jsonObject = new JSONObject();
        String  name = filePath.substring(filePath.lastIndexOf("\\")+1,filePath.lastIndexOf("."));
        jsonObject.put(name,jsonArray);
        bufferedWriter.write(jsonObject.toString());
        bufferedWriter.close();
        fileWriter.close();
    }
}
