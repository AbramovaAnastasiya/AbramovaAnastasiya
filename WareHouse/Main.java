package WareHouse;

import WareHouse.Operations.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int fix_size;
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        SizeWH sizeWH = new SizeWH(fix_size);

        sizeWH.Fix_size();

        String[] mas = new String[sizeWH.getFix_size()];
        String[] mas1 = new String[1000];
//        mas[0] = "Шкаф";
//        mas[1] = "Стол";
//        mas[2] = "Стул";
//        mas[3] = "Кровать";
//        ObjectOutputStream oos1 = new ObjectOutputStream( new FileOutputStream("WareHouse.txt")) ;
//        oos1.writeObject(mas);
//        oos1.flush();
//        oos1.close();



        ObjectInputStream ois = new ObjectInputStream( new FileInputStream("WareHouse.txt"));
        mas1 = (String[]) ois.readObject();
        ois.close();
        if (mas1.length == sizeWH.getFix_size()){
            mas = mas1;
        }
        else mas = new String[sizeWH.getFix_size()];


     //   System.out.println(mas);



        ArrayList<String> arrayListWH = new ArrayList<String>(sizeWH.getFix_size());
        Collections.addAll(arrayListWH, mas);
        System.out.println(arrayListWH);
        ConsoleWH consoleWH = new ConsoleWH(arrayListWH, fix_size);

//        ObjectInputStream ois1 = new ObjectInputStream( new FileInputStream("WareHouse.txt"));
//        arrayListWH = (ArrayList<String>) ois1.readObject();
//        ois1.close();

   //     System.out.println(arrayListWH);

        Add_WH add_wh = new Add_WH(arrayListWH);
        add_wh.setFix_size(sizeWH.getFix_size());
        Del_WH del_wh = new Del_WH(arrayListWH);
        SearchWH searchWH = new SearchWH(arrayListWH);
        Count_WH count_wh = new Count_WH(arrayListWH);


        consoleWH.input();
        System.out.println(arrayListWH);

    }}

