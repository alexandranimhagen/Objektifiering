// En klass för att läsa CSV-filer och konvertera dem till en lista av DataObject-objekt.
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVFileReader {

    // Metod för att läsa en CSV-fil och returnera en lista av DataObject-objekt
    public List<DataObject> readCsvFile(String filePath) {
        // Skapa en lista för att hålla DataObject-objekt
        List<DataObject> dataObjects = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;

            // Läs och hoppa över rubrikraden
            if ((nextLine = reader.readNext()) == null) {
                System.err.println("Tom fil eller problem med att läsa rubrikraden.");
                return dataObjects;
            }

            // Loopa igenom varje rad i CSV-filen
            while ((nextLine = reader.readNext()) != null) {
                String[] values = nextLine;

                // Skapa ett DataObject för varje rad och lägg till det i listan
                DataObject dataObject = new DataObject();
                if (values.length >= 8) {
                    dataObject.setA(values[0]);
                    dataObject.setB(values[1]);
                    dataObject.setC(values[2]);
                    dataObject.setD(values[3]);
                    dataObject.setE(values[4]);
                    dataObject.setF(values[5]);
                    dataObject.setG(values[6]);
                    dataObject.setH(values[7]);
                    dataObjects.add(dataObject);
                } else {
                    System.err.println("Färre än 8 värden i raden: " + String.join(",", values));
                }
            }
        } catch (IOException | CsvValidationException e) {
            // Hantera eventuella IO- eller CSV-valideringsfel genom att skriva ut felmeddelandet
            e.printStackTrace();
        }

        // Returnera den resulterande listan av DataObject-objekt
        return dataObjects;
    }
}
