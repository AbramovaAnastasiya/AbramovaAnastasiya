package WareHouse.Operations;

import java.util.ArrayList;
import java.util.Scanner;

public class Add_WH {

    private static ArrayList<String> arrayListWH;
    private static int fix_size;
    static String product_add;

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

    public static void addPr() {

        System.out.println("Введите товар, который нужно добавить");
        Scanner sc = new Scanner(System.in);
        product_add = sc.nextLine();
        for (int ind = 0; ind < fix_size; ind++) {
            if (arrayListWH.get(ind) == null) {
                arrayListWH.set(ind,product_add);
                System.out.println("Товар " + Add_WH.product_add + " добавлен!");
                return;
            } else if (ind>=fix_size) System.out.println("Склад заполнен");
        }
    }
}


