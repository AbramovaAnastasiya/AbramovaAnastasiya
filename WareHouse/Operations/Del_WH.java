package WareHouse.Operations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Del_WH {
    private static String product_dell;
    private static ArrayList<String> arrayListWH;
    public Del_WH(ArrayList<String> arrayListWH){
        this.arrayListWH = arrayListWH;}

    public static void dellPr(){
        System.out.println("Введите название товара, который нужно убрать со склада");
        Scanner sc = new Scanner(System.in);
        product_dell = sc.nextLine();
        Iterator<String> listWHIterator = arrayListWH.iterator();
        while(listWHIterator.hasNext()) {
            String next1 = listWHIterator.next();
            if ((next1!= null) && ( next1.equals(product_dell))) {
                listWHIterator.remove();
            }
        }
}}
