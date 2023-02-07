package data;

import com.poiji.bind.Poiji;
import model.ErrorMessage;

import java.io.File;
import java.util.List;

public class ExcelReader {
    private static final String excelPath = "src/test/resources/data/Information.xlsx";

    public static List<ErrorMessage> getErrorMessageList() {
        return Poiji.fromExcel(new File(excelPath), ErrorMessage.class);
    }
}
