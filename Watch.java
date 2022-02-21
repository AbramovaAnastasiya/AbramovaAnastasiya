package lesson_3.homework2;

import java.awt.*;

public class Watch extends SmartPhoneAndWatch {
private String sensors;

public Watch(String brand, String model, String sensors){
    this.name = "Смарт-Часы";
    this.brand = brand;
    this.model = model;
}

    public void setSensors(String sensors) {this.sensors = sensors;}
    public String getSensors() {return sensors;}

    public void open() {
    super.open();
        this.brand = "Apple";
        this.model = "Apple Watch Series 5";
        this.sensors = "Датчик каллорий";
        //this.iconDescription = (" Здесь вы найдёте лучшие смарт-часы!");

        //System.out.println("Открыта категория " + name + iconDescription);
       // System.out.println("Вы выбрали часы бренда "+ brand + " модель " + model + "с датчиком: "+ getSensors());
    }

}
