package lesson_3.homework2;

public class SmartPhone extends SmartPhoneAndWatch {
    private int memory;

    public SmartPhone(String brand, String model, int memory){
        this.name = "Смартфоны";
        this.brand = brand;
        this.model = model;
        this.memory = memory;}
    public void setMemory(int memory) {
        if (memory>=64 && memory<=264) this.memory = memory;}

    public int getMemory(){return memory;}

    public void open() {super.open();}

   // public void choose(){
    //    System.out.println("Вы выбрали смартфон бренда "+ brand + " модель " + model + "с объёмом памяти: "+ memory + "ГБ");
   // }

}
