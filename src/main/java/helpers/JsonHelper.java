package helpers;

import constants.FrameworkConstants;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonHelper {
    public static Object[][] getJsonData(String filename, String JSON_Data, int JSON_attributes) throws IOException, ParseException {
        Object object = new JSONParser().parse(new FileReader(FrameworkConstants.readDataFile(filename)));
        JSONObject jo = (JSONObject) object;
        JSONArray js = (JSONArray) jo.get(JSON_Data);

        Object[][] arr = new String[js.size()][JSON_attributes];
        for (int i = 0; i < js.size(); i++){
            JSONObject obj1 = (JSONObject) js.get(i);
            arr[i][0] = String.valueOf(obj1.get("username"));
            arr[i][1] = String.valueOf(obj1.get("password"));
        }
        return arr;
    }
}
