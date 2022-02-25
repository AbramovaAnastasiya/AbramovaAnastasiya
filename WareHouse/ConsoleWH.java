package WareHouse;

import WareHouse.Operations.Add_WH;
import WareHouse.Operations.Count_WH;
import WareHouse.Operations.Del_WH;
import WareHouse.Operations.SearchWH;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class ConsoleWH<mas> {
    public String command;
    private final int fix_size;
    private static ArrayList<String> arrayListWH;

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
            case "exit": System.exit(0);
                break;
            case "add":
                Add_WH.addPr();
                System.out.println(arrayListWH);
                String[] mas = arrayListWH.toArray(new String[0]);
                ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream("WareHouse.txt")) ;
                oos.writeObject(mas);
                oos.flush();
                oos.close();
                break;
            case "delete":
                Del_WH.dellPr();
                System.out.println(arrayListWH);
                String[] mas1 = arrayListWH.toArray(new String[0]);
                ObjectOutputStream oos1 = new ObjectOutputStream( new FileOutputStream("WareHouse.txt")) ;
                oos1.writeObject(mas1);
                oos1.flush();
                oos1.close();
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
