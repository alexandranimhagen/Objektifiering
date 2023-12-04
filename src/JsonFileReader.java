// En klass för att läsa JSON-filer och konvertera dem till en lista av DataObject-objekt.
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

public class JsonFileReader {

    // Metod för att läsa en JSON-fil och returnera en lista av DataObject-objekt
    public List<DataObject> readJsonFile(String filePath) {
        try (Reader reader = new FileReader(filePath)) {
            // Skapa en Gson-instans för att konvertera JSON till Java-objekt
            Gson gson = new Gson();

            // Skapa en Type för att hantera generiska typer som List<DataObject>
            Type dataListType = new TypeToken<List<DataObject>>() {}.getType();

            // Använd Gson för att konvertera JSON-filen till en lista av DataObject-objekt
            return gson.fromJson(reader, dataListType);
        } catch (IOException e) {
            // Hantera eventuella IO-fel genom att skriva ut felmeddelandet och returnera null
            e.printStackTrace();
            return null;
        }
    }
}
