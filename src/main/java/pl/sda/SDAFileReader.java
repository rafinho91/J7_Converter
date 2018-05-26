package pl.sda;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface SDAFileReader {
    List<Map<String ,String>> read(String filePath) throws IOException;
}
