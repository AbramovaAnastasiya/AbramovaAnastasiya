package lesson_3.homework2;

public class SearchButton implements Element{
    public String getType(){return "Кнопка поиска";}
    public void click(){
        System.out.println("Вы нажали на элемент "+ getType());
    }
}
