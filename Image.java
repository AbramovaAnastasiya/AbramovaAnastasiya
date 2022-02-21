package lesson_3.homework2;

public class Image implements Element {
    //public String type;
    public String name;
    public String getType(){return "Картинка";}
    public String getName(){return name;}
    public void setName(String name){this.name = name;}
    public void click(){
        System.out.println("Вы нажали на элемент "+ getType() + " " + name);
    }
}
