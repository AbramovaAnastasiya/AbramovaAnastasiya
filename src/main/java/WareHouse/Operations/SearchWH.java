package WareHouse.Operations;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchWH {

    private static String product_search;
    private static ArrayList<String> arrayListWH;
    public SearchWH(ArrayList<String> arrayListWH){
        this.arrayListWH = arrayListWH;}
    public static void searchPr(){
        //     getArrayListWH();
        System.out.println("Введите название товара, который требуется найти");
        Scanner sc = new Scanner(System.in);
        product_search = sc.nextLine();
        arrayListWH.contains(product_search);
        if (arrayListWH.contains(product_search)) {
            System.out.println("Товар " + product_search + " есть на складе");
        } else if (!(arrayListWH.contains(product_search))) {
            System.out.println("Товар " + product_search + " отсутствует на складе");
        }



}}


