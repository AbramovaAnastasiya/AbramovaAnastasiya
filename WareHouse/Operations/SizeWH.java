package WareHouse.Operations;

import java.util.Scanner;

public class SizeWH  {
    private int fix_size;

    public SizeWH(int fix_size) {
        this.fix_size = fix_size;
    }
    public void Fix_size(){
        System.out.println("Введите размер склада");
        Scanner sc = new Scanner(System.in);
        fix_size = Integer.parseInt(sc.nextLine());
    }

    public int getFix_size(){return fix_size;}
    public void setFix_size(int fix_size){
        this.fix_size = fix_size;
    }
}


