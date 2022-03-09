package WareHouse;

import WareHouse.Operations.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

import static WareHouse.ConsoleWH.arrayListWH;

public class Main {
    static XSSFWorkbook workbook = new XSSFWorkbook(); // создать  xslx
    static XSSFSheet sheet = workbook.createSheet("WareHouse"); // Создать страницу
    public static String[] mas;
    static int fix_size;
    static SizeWH sizeWH = new SizeWH(fix_size);


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        sizeWH.Fix_size();

        mas = new String[sizeWH.getFix_size()];
        ArrayList<String> arrayListWH = new ArrayList<String>(sizeWH.getFix_size());
        Collections.addAll(arrayListWH, mas);
        ConsoleWH consoleWH = new ConsoleWH(arrayListWH, fix_size);


        Add_WH add_wh = new Add_WH(arrayListWH);
        add_wh.setFix_size(sizeWH.getFix_size());
        Del_WH del_wh = new Del_WH(arrayListWH);
        SearchWH searchWH = new SearchWH(arrayListWH);
        Count_WH count_wh = new Count_WH(arrayListWH);

        consoleWH.input();
        System.out.println(arrayListWH);
        Export("WH.xlsx");
    }

    public static void Export(String file) throws FileNotFoundException, IOException {
        Set<String> mySet = new HashSet<String>(arrayListWH); //Записать список товаров без дубликатов
        for (String s : mySet) {
            System.out.println(s + " " + Collections.frequency(arrayListWH, s)); //Вывести количество вхождений каждого товара
        }
        FileOutputStream out = new FileOutputStream("WH.xlsx");

        mas = mySet.toArray(new String[0]); // Записать в массив товары без дублей

        Row row = sheet.createRow(0);
        Cell name = row.createCell(0);
        name.setCellValue("Товар");  // Название первой колонки
        Cell count = row.createCell(1);
        count.setCellValue("Количество"); // Название второй колонки

        for (int i = 1; i < mas.length + 1; i++) {
            row = sheet.createRow(i);
            name = row.createCell(0);
            count = row.createCell(1);
            if (mas[i-1] != null){
                name.setCellValue(mas[i - 1]); //  заносим товары в таблицу
                count.setCellValue((Collections.frequency(arrayListWH, mas[i - 1]))); // во вторую колонку заносим кол-во вхождений
            }
        }
        sheet.autoSizeColumn(0);
        sheet.autoSizeColumn(1);
        workbook.write(out);
        workbook.close();
    }
}



