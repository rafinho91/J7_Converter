package pl.sda;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class App 
{
    public static void main( String[] args )
    {
        CSVFileReader reader = new CSVFileReader();
        try {
            List<Map<String ,String>> list = reader.read("C:\\sda\\J7_Converter\\src\\test\\resources\\citiesTEST.csv");
            FileWriterFactory.write(list, "C:\\sda\\J7_Converter\\citiesWRITER.json");
        } catch (IOException e) {
            System.out.println("WYSTĄPIŁ BŁĄD");
        }
    }
}
