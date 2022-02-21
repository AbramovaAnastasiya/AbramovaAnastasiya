package lesson_3.homework2;

public class InputBox implements Element{
    //public String type;
    public String getType(){return "Поле ввода";}
    public void click(){
        System.out.println("Вы нажали на элемент "+ getType());
    }

}
