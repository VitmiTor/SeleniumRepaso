package data;

import model.UserData;

import java.util.HashMap;
import java.util.Map;

public class MapParser {
    public static Map<String, String> getErrorMessageMap() {
        final var map = new HashMap<String, String>();
        final var errorMessageList = ExcelReader.getErrorMessageList();

        for (var element : errorMessageList) {
            map.put(element.getKey(), element.getValue());
        }
        return map;
    }

    public static Map<String, UserData> getCredentials() {
        final var map = new HashMap<String, UserData>();
        final var credentialList = ExcelReader.getUserDataList();

        for (var credential : credentialList) {
            map.put(credential.getKey(), credential);
        }
        return map;
    }
    
}
