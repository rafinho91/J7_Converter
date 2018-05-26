package pl.sda;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface SDAFileWriter {
    void write(List<Map<String ,String >> models, String filePath) throws IOException;
}
