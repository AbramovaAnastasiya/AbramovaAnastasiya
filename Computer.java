package lesson_3.homework2;

public class Computer extends Category{
    private String type;
    private int SSD;
    private int RAM;

    public Computer(String type, String brand, int SSD, int RAM){
        this.name = "Компьютеры";
        this.type = type;
        this.brand = brand;
        this.SSD = SSD;
        this.RAM = RAM;
    }
    public Computer(){
        this.name = "Компьютеры";
    };

    public void setType(String type){this.type = type;}

    public void setSSD(int SSD) {
        if (SSD >= 16 && SSD <= 19600) this.SSD = SSD;
    }
    public int getSSD() {
        return SSD;
    }

    public void setRAM(int RAM) {
        if (RAM >= 8 && RAM <= 128) this.RAM = RAM;
    }
    public int getRAM() {return RAM;}

    public void open(){
        System.out.println("Открыта категория " + name);
    }

}
