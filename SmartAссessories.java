package lesson_3.homework2;

public class SmartAссessories extends SmartPhoneAndWatch{
    private String nameAcc;
    public SmartAссessories(String nameAcc,String brand, String model){
        this.name = "Аксессуары для смартфонов";
        this.nameAcc = nameAcc;
        this.brand = brand;
        this.model = model;
    }
    public void setNameAcc(String nameAcc){this.nameAcc = nameAcc;}
    public String getNameAcc(){return nameAcc;}

    @Override
    public void open() {
        System.out.println("Вы открыли категорию " + name);}
    public void choose(){
        System.out.println("Вы выбрали " + nameAcc + " " + brand + " " + model);
        };
    };


