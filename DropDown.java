package lesson_3.homework2;

public class DropDown implements Element{
    public String getType(){return "Выпадающий список";}
    public void click(){
        System.out.println("Вы нажали на элемент "+ getType());
    }
}
