package lesson_3.homework2;

public class SmartPhoneAndWatch extends Category {

    @Override
    public void open(){
        if (name == null){
            System.out.println("Вы находитесь в разделе Смартфоны и Смарт-часы, выберите подраздел");
        }
        else {System.out.println("Открыта категория " + name);
        //iconDescription = ("Здесь вы найдёте лучшие" + name +"!");
        //System.out.println(iconDescription);

    }}}



