package me.mahmudulhaque;

import java.io.FileReader;
import java.util.List;
import java.util.Objects;

public class CSVReader {
    private List<String[]> csvAsList;

    public List<String[]> getCSVAsList() {
        return csvAsList;
    }

    public void readCSV(String fileName) {
        try {
            FileReader filereader = new FileReader(Objects.requireNonNull(Main.class.getClassLoader().getResource(fileName)).getFile());

            com.opencsv.CSVReader csvReader = new com.opencsv.CSVReader(filereader);
            csvAsList = csvReader.readAll();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
