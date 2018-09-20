import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Time;

/**
 * Created by Alex Plate on 20.09.2018.
 * https://stackoverflow.com/questions/52426370/using-apache-poi-input-time
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("Birthdays");

        Time time = Time.valueOf("19:30:00");

        // Нумерация начинается с нуля
        Row row = sheet.createRow(0);

        CellStyle cellStyle1 = workbook.createCellStyle();
        CreationHelper createHelper = workbook.getCreationHelper();
        cellStyle1.setDataFormat(
                createHelper.createDataFormat().getFormat("HH:MM AM/PM"));
        Cell cell = row.createCell(0);
        System.out.println(time.toString());
        cell.setCellValue(time);
        cell.setCellStyle(cellStyle1);

        // Записываем всё в файл
        workbook.write(new FileOutputStream("this.xls"));
        workbook.close();
    }
}
