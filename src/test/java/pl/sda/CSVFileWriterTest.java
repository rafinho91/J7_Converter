package pl.sda;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

public class CSVFileWriterTest {
    @Test
    public void fileWriterTest() throws IOException {
        //given
        String expectedFilePath = "C:\\sda\\J7_Converter\\src\\test\\resources\\citiesTEST.csv";
        String filePath = "C:\\sda\\J7_Converter\\src\\test\\resources\\citiesTESTWriter.csv";
        CSVFileReader reader = new CSVFileReader();
        CSVFileWriter writer = new CSVFileWriter();
        //when
        List<Map<String, String>> expectedCities = reader.read(expectedFilePath);
        writer.write(expectedCities,filePath);
        List<Map<String, String>> cities = reader.read(filePath);
        //then
        Assert.assertEquals(expectedCities, cities);
    }
}
