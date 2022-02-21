package lesson_3.homework2;

public class Tablet extends LaptopAndTablet implements Element{
    private boolean LTE;
    private int memory;
    private String x;
    private String type;

    public Tablet(String brand, String model, float diagonal, int memory, int RAM, boolean LTE){
        this.name = "Планшеты";
        this.brand = brand;
        this.model = model;
        this.diagonal = diagonal;
        this.memory = memory;
        this.RAM = RAM;
        this.LTE = LTE;
    }
    public String getType() {return "Картинка";}
    public void click(){
        System.out.println("Вы нажали на элемент "+ getType() + " " + name);
    }

    public void SetMemory(int memory){
        if (memory>=1 && memory<=2048) this.memory = memory;
        else if(memory<1) this.memory = 1;
        else this.memory = 2048;
    }

    public int getMemory(){return memory;}
    public boolean getLTE(){return LTE;}


    public void setLTE(boolean LTE){
        if (LTE == true) x = "да ";
        else x="нет";}

    public String getX(){
       setLTE(getLTE());
       return x;}

    public void open(){super.open();}


}
