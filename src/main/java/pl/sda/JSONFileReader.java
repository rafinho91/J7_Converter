package pl.sda;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class JSONFileReader implements SDAFileReader {
    public List<Map<String, String>> read(String filePath) throws IOException {
        List<Map<String, String>> models = new ArrayList<>();
        byte[] bytes = Files.readAllBytes(Paths.get(filePath));
        String json = new String(bytes, "UTF-8");
        JSONObject jsonObject = new JSONObject(json);
        String rootKey = jsonObject.keySet().iterator().next();
        JSONArray rawValues = new JSONArray(jsonObject.get(rootKey).toString());
        for (Object rawValue : rawValues) {
            Map<String, String> parsedModel = new HashMap<>();
            JSONObject value = new JSONObject(rawValue.toString());
            Iterator<String> iterator = value.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                parsedModel.put(key, value.getString(key));
            }
            models.add(parsedModel);
        }
        return models;
    }
}
