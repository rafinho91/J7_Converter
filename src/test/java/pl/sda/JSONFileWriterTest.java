package pl.sda;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JSONFileWriterTest {
    @Test
    public void fileWriterTest() throws IOException {
        //given
        String expectedFilePath = "C:\\sda\\J7_Converter\\src\\test\\resources\\citiesTEST.json";
        String filePath = "C:\\sda\\J7_Converter\\src\\test\\resources\\citiesTESTWriter.json";
        JSONFileReader reader = new JSONFileReader();
        JSONFileWriter writer = new JSONFileWriter();
        //when
        List<Map<String, String>> expectedCities = reader.read(expectedFilePath);
        writer.write(expectedCities,filePath);
        List<Map<String, String>> cities = reader.read(filePath);
        //then
        Assert.assertEquals(expectedCities, cities);
    }
}
