package pl.sda;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JSONFileReaderTest {

    @Test
    public void fileReaderTest() throws IOException {
        //given
        String filePath = "C:\\sda\\J7_Converter\\src\\test\\resources\\citiesTEST.json";
        JSONFileReader reader = new JSONFileReader();
        //when
        List<Map<String ,String >> expectedCities = new ArrayList<>();
        Map<String ,String > poznan = new LinkedHashMap<>();
        poznan.put("name", "Poznan");
        poznan.put("country", "Poland");
        poznan.put("numberOfInhabitants", "450000");
        poznan.put("climate", "mixed");
        Map<String ,String > moscow = new LinkedHashMap<>();
        moscow.put("name", "Moscow");
        moscow.put("country", "Russia");
        moscow.put("numberOfInhabitants", "5000000");
        moscow.put("climate", "cold");
        expectedCities.add(poznan);
        expectedCities.add(moscow);

        List<Map<String ,String >> cities = reader.read(filePath);
        //then
        Assert.assertEquals(expectedCities, cities);
    }
}
