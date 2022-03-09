package WareHouse.Operations;

import java.util.*;
import java.util.stream.Collectors;

import static WareHouse.ConsoleWH.arrayListWH;

public class Add_WH {

    private static ArrayList<String> arrayListWH;
    static int[] count_el;
    private static int fix_size;
    static String product_add;
    public static int index;

    public Add_WH(ArrayList<String> arrayListWH) {
        this.arrayListWH = arrayListWH;
        this.fix_size = fix_size;
    }

    public void setFix_size(int fix_size) {
        this.fix_size = fix_size;
    }

    public int getFix_size() {
        return fix_size;
    }

    public static int getIndex(){
        for (int j =0; j<fix_size; j++ ){
            index = j;
        }
        return index;
    }

    public static void addPr() {

        Set setWH = new HashSet(arrayListWH);
        System.out.println("Введите товар, который нужно добавить");
        Scanner sc = new Scanner(System.in);
        product_add = sc.nextLine();
        count_el = new int[fix_size];


        for (int ind = 0; ind < fix_size; ind++) {
            if (arrayListWH.get(ind) == null) {
                arrayListWH.set(ind, product_add);
                System.out.println("Товар " + Add_WH.product_add + " добавлен!");
                return;
            }
            else if (ind>=fix_size) System.out.println("Склад заполнен");
    }
}}


