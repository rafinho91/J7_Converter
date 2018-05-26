package pl.sda;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVCityFileReaderTest {

    @Test
    public void parseCSVRowTest() throws IOException {
        //given
        String filePath = "C:\\sda\\J7_Converter\\src\\test\\resources\\citiesTEST.csv";
        CSVCityFileReader reader = new CSVCityFileReader();
        //when
        List<City> expectedCities = new ArrayList<>();
        expectedCities.add(new City("Poznan", "Poland",
                450000,"mixed"));
        expectedCities.add(new City("Moscow", "Russia",
                5000000,"cold"));
        List<City> cities = reader.read(filePath);
        //then
        Assert.assertEquals(expectedCities, cities);
    }
}
