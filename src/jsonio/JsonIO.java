package jsonio;

import org.json.JSONArray;
import org.json.JSONTokener;

import java.io.FileReader;


public class JsonIO {
    public static JSONArray readJSON(String filePath){
        try (FileReader reader = new FileReader(filePath)) {
            JSONTokener data = new JSONTokener(reader);

            JSONArray js = new JSONArray(data);
            return js;
        } catch (Exception e) {
            return null;
        }
    }
}
