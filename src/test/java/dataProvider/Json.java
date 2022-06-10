package dataProvider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Json {
    @Test
    public void testJson(){

    }

    @DataProvider
    public Object[] readFromJson() throws IOException, JsonMappingException{

        String JsonFilePath1 = System.getProperty("system.dir")+ "\\src\\test\\java\\data\\userData.csv";
        String JsonFilePath2 = System.getProperty("system.dir")+ "\\src\\test\\java\\data\\userData - Copy.json";
        HashMap<String, String> map1 = new ObjectMapper()
                .readValue(new File(JsonFilePath1), new TypeReference<HashMap<String, String>>() {
                });
        HashMap<String, String> map2 = new ObjectMapper()
                .readValue(new File(JsonFilePath2), new TypeReference<HashMap<String, String>>() {
                });
        return new Object[] {map1, map2};
    }
}
