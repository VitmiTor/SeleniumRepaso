package model;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelSheet;

@ExcelSheet("Items")
public class Items {
    @ExcelCellName("Key")
    private String key;
    @ExcelCellName("Name")
    private String name;
    @ExcelCellName("Price")
    private double price;
    @ExcelCellName("quantity")
    private int quantity;

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
