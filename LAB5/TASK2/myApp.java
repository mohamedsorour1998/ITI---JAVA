import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class myApp {
    public static void main(String[] args) {
        String filePathOfCities = "Cities.csv";
        // create an arrayList to add all new created objects
        ArrayList<City> listOfCities = new ArrayList<>();
        ArrayList<String[]> dataOfCities = getCities(filePathOfCities);
        for (String[] city : dataOfCities) {
            String[] arrayOfCities = Arrays.toString(city).split(",");
            // create object of country class
            City myCity = new City();
            myCity.setId(Integer.parseInt(arrayOfCities[0].substring(1).trim()));
            myCity.setName(arrayOfCities[1]);
            myCity.setPopulation(Integer.parseInt(arrayOfCities[2].trim()));
            myCity.setCountryCode(
                    arrayOfCities[3].substring(0,
                            arrayOfCities[3].length() - 1).trim());
            listOfCities.add(myCity);
        }

        // Q1
        // Finding the highest populated city of each country
        List<City> HighestPopulatedCityOfEachCountry = listOfCities.stream()
                .collect(Collectors.groupingBy(City::getCountryCode))
                .values().stream()
                .map(cities -> cities.stream()
                        .max(Comparator.comparing(City::getPopulation))
                        .get())
                .collect(toList());
        // uncomment the following to print HighestPopulatedCityOfEachCountry
        // System.out.println("HighestPopulatedCityOfEachCountry");
        // for (City city : HighestPopulatedCityOfEachCountry) {
        // System.out.println(city.getName());
        // System.out.println(city.getPopulation());
        // System.out.println(city.getCountryCode());
        // }

        String filePathOfCountries = "Countries.csv";
        // create an arrayList to add all new created objects
        ArrayList<Country> listOfCountries = new ArrayList<>();
        ArrayList<String[]> dataOfCountries = getCountries(filePathOfCountries);
        for (String[] country : dataOfCountries) {
            String[] arrayOfCountries = Arrays.toString(country).split(",");
            // create object of country class
            Country myCountry = new Country();
            myCountry.setCode(arrayOfCountries[0].substring(1));
            myCountry.setName(arrayOfCountries[1]);
            myCountry.setContinent(arrayOfCountries[2]);
            myCountry.setSurfaceArea(Integer.parseInt(arrayOfCountries[3].trim()));
            myCountry.setPopulation(Integer.parseInt(arrayOfCountries[4].trim()));
            myCountry.setGnp(Double.parseDouble(arrayOfCountries[5].trim()));
            myCountry.setCapital(
                    Integer.parseInt(arrayOfCountries[6].substring(0,
                            arrayOfCountries[6].length() - 1).trim()));
            listOfCountries.add(myCountry);
        }

        // Q2
        // Finding the highest populated country of each continent
        List<Country> HighestPopulatedCountryOfEachContinent = listOfCountries.stream()
                .collect(Collectors.groupingBy(Country::getContinent))
                .values().stream()
                .map(countries -> countries.stream()
                        .max(Comparator.comparing(Country::getPopulation))
                        .get())
                .collect(toList());
        // uncomment the following to print HighestPopulatedCountryOfEachContinent
        // System.out.println("HighestPopulatedCountryOfEachContinent");
        // for (Country country : HighestPopulatedCountryOfEachContinent) {
        // System.out.println(country.getPopulation());
        // System.out.println(country.getContinent());
        // }

        // Q3
        // Finding the highest populated capital city

        // first step filling an array of Capital city ids
        int noOfCountries = listOfCountries.size();
        int[] arrayOfCountriesCapitals = new int[noOfCountries];
        for (int index = 0; index < noOfCountries; index++) {
            Country country = listOfCountries.get(index);
            int countryCapital = country.getCapital();
            arrayOfCountriesCapitals[index] = countryCapital;

        }
        List<City> HighestPopulatedCapitalCity = listOfCities.stream()
                .filter(city -> Arrays.stream(arrayOfCountriesCapitals).anyMatch(x -> x == city.getId()))
                .collect(Collectors.groupingBy(City::getCountryCode))
                .values().stream()
                .map(cities -> cities.stream()
                        .max(Comparator.comparing(City::getPopulation))
                        .get())
                .limit(1)
                .collect(toList());

        System.out.println("HighestPopulatedCapitalCity");
        for (City city : HighestPopulatedCapitalCity) {
            System.out.println(city.getName());
            System.out.println(city.getPopulation());
        }

    }

    private static ArrayList<String[]> getCities(String filePathOfCities) {
        // create an ArrayList to store rows of Cities CSV data
        ArrayList<String[]> dataOfCities = new ArrayList<>();
        try {
            // create an instance of BufferedReader class
            BufferedReader reader = new BufferedReader(new FileReader(filePathOfCities));
            String line;
            while ((line = reader.readLine()) != null) {
                // split line using comma as a separator and store the parts in an array
                String[] row = line.split(",");
                // add array of data to the ArrayList
                dataOfCities.add(row);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataOfCities;
    }

    private static ArrayList<String[]> getCountries(String filePathOfCities) {
        // create an ArrayList to store rows of Countries CSV data
        ArrayList<String[]> dataOfCountries = new ArrayList<>();
        try {
            // create an instance of BufferedReader class
            BufferedReader reader = new BufferedReader(new FileReader(filePathOfCities));
            String line;
            while ((line = reader.readLine()) != null) {
                // split line using comma as a separator and store the parts in an array
                String[] row = line.split(",");
                // add array of data to the ArrayList
                dataOfCountries.add(row);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataOfCountries;
    }
}
