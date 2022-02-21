package lesson_3.homework2;

public class TV extends Category  {

    private float diagonal;
    //private String type;

    public TV(String brand, String model, float diagonal){
        this.name = "Телевизоры";
        this.brand = brand;
        this.model = model;
        this.diagonal = diagonal;
    }
    //@Override
    //public String getType() {return "Картинка";}
    //public void click(){
      //  System.out.println("Вы нажали на элемент "+ getType() + " " + name);
    //}

    public float getDiagonal() {
        return diagonal;
    }
    public void SetDiagonal(float diagonal){
        if (diagonal >=1 && diagonal<=98){
            this.diagonal = diagonal;
        }
    }
    public void open(){
        System.out.println("Вы находитесь в разделе " + name);
    }

}
