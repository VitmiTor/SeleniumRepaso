package model;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelSheet;

@ExcelSheet("ErrorMessages")
public class ErrorMessage {
    @ExcelCellName("Key")
    private String key;
    @ExcelCellName("Value")
    private String value;

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
