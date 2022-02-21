package lesson_3.homework2;

public class Appliances extends Category {
    private String nameApp;
    public Appliances(String nameApp){
        this.nameApp = nameApp;}

    public String getNameApp(){
        return nameApp;}

   @Override
   public void open(){
       this.name = "Бытовая техника";
       System.out.println("Вы находитесь в категории " + name);
   };

}
