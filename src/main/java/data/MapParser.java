package data;

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
}
