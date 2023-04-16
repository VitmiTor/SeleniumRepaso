package data;

import com.poiji.bind.Poiji;
import model.ErrorMessage;
import model.UserData;

import java.io.File;
import java.util.List;

public class ExcelReader {
    private static final String excelPath = "src/test/resources/data/datosUserunique.xlsx";


    public static List<ErrorMessage> getErrorMessageList() {
        return Poiji.fromExcel(new File(excelPath), ErrorMessage.class);
    }

    public static List<UserData> getUserDataList() {
        return Poiji.fromExcel(new File(excelPath), UserData.class);
    }
}
