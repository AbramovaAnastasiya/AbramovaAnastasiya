package WareHouse.Operations;

import java.util.ArrayList;

public class Count_WH {
    private static int product_count;
    private static ArrayList<String> arrayListWH;
    public Count_WH(ArrayList<String> arrayListWH){
        this.arrayListWH = arrayListWH;}
    public static void countPr(){
        product_count = 0;
        for (int i=0; i<arrayListWH.size(); i++){
            if (!(arrayListWH.get(i)==null)){
        product_count = product_count + 1;}}
        System.out.println("На складе " + product_count + " товаров");
    }
}
