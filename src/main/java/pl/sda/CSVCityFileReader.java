package pl.sda;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVCityFileReader{
    public List<City> read(String filePath) throws IOException {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String[] headers = null;
        String line;
        List<City> cities = new ArrayList<>();

        int i = 0;
        while ((line = bufferedReader.readLine()) != null && !line.isEmpty()) {
            if (i == 0) {
                headers = line.split(";");
                i++;
            } else {
                City parsedCity = parseCSVRow(headers, line);
                cities.add(parsedCity);
            }
        }
        return cities;
    }

    private City parseCSVRow(String[] headers, String line) {
        City city = new City();
        String[] values = line.split(";");
        for (int i = 0; i < headers.length; i++) {
            setCityFieldFromCSVFile(city, headers[i], values[i]);
        }
        return city;
    }

    private void setCityFieldFromCSVFile(City city, String header, String value) {
        if ("name".equals(header)) {
            city.setName(value);
        }
        if ("country".equals(header)) {
            city.setCountry(value);
        }
        if ("numberOfInhabitants".equals(header)) {
            city.setNumberOfInhabitants(Long.parseLong(value));
        }
        if ("climate".equals(header)) {
            city.setClimate(value);
        }
    }
}
