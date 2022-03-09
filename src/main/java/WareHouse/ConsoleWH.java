package WareHouse;

import WareHouse.Operations.Add_WH;
import WareHouse.Operations.Count_WH;
import WareHouse.Operations.Del_WH;
import WareHouse.Operations.SearchWH;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class ConsoleWH {
    public String command;
    private final int fix_size;
    public static ArrayList<String> arrayListWH;

    ConsoleWH(ArrayList<String> arrayListWH, int fix_size) {
        this.arrayListWH = arrayListWH;
        this.fix_size = fix_size;
    }

    public void input() throws IOException {
        command = "";
        while (!command.equals("exit")){
        System.out.println("Введите команду(add, delete, search, count, exit)");
        Scanner sc = new Scanner(System.in);
        command = sc.nextLine();


        switch (command) {
            case "exit":
                break;
            case "add":
                Add_WH.addPr();
                System.out.println(arrayListWH);
                break;
            case "delete":
                Del_WH.dellPr();
                System.out.println(arrayListWH);
                break;
            case "search":
                SearchWH.searchPr();
                break;
            case "count":
                Count_WH.countPr();
                break;
            default: System.out.println("Неверный ввод, повторите попытку");
        }

    }


}}
