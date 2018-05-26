package pl.sda;

import java.util.Objects;

public class City {
    private String name;
    private String country;
    private long numberOfInhabitants;
    private String climate;

    public City() {
    }

    public City(String name, String country, long numberOfInhabitants, String climate) {
        this.name = name;
        this.country = country;
        this.numberOfInhabitants = numberOfInhabitants;
        this.climate = climate;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getNumberOfInhabitants() {
        return numberOfInhabitants;
    }

    public void setNumberOfInhabitants(long numberOfInhabitants) {
        this.numberOfInhabitants = numberOfInhabitants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return numberOfInhabitants == city.numberOfInhabitants &&
                Objects.equals(name, city.name) &&
                Objects.equals(country, city.country) &&
                Objects.equals(climate, city.climate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, country, numberOfInhabitants, climate);
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", numberOfInhabitants=" + numberOfInhabitants +
                ", climate='" + climate + '\'' +
                '}';
    }
}
