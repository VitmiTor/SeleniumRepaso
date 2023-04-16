package model;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelSheet;

@ExcelSheet("Datos")
public class UserData {
    @ExcelCellName("Key")
    private String key;
    @ExcelCellName("userEmail")
    private String email;
    @ExcelCellName("password")
    private String password;

    public String getKey() {
        return key;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
