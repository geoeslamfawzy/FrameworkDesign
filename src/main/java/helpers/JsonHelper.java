package helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import constants.FrameworkConstants;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class JsonHelper {
    //This to make a hashmap that is used to point to the value of a key
    private static Map<String, String> CONFIGMAP = new HashMap<>();

    private JsonHelper(){}
    static {
        try {
            FileInputStream file = new FileInputStream(FrameworkConstants.getResourcesPath("loginData.json"));
            CONFIGMAP = new ObjectMapper().readValue(new File(""), HashMap.class);
            Properties properties = new Properties(); //This class to work on the file
            properties.load(file);

            /**
             * properties is an object, while the key and value in the configuration files are string
             *      Thus, we iterate on each object on the properties of the configuration file to get its keyset
             *          loop on the properties you have and put
             *          Make a hashmap to store all keys&Values in the configuration file
             *          for each keyset in the properties you have
             *              1- Put the key in the Configuration file as a key in this map
             *              2- put its corresponding values as a value in this map
             */
            for (Map.Entry<Object, Object> entry : properties.entrySet()) {
                //Put everything; key and value, in a hashmap
                CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
            }
            /*properties.entrySet().forEach(entry -> CONFIGMAP.
                    put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue())));

             */
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
