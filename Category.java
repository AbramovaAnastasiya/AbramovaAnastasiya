package lesson_3.homework2;

public abstract class Category {
    protected String iconDescription;
    protected String name;
    protected String brand;
    protected String model;

    public abstract void open();
    public void setBrand(String brand){this.brand = brand;}
    public void setModel(String model) {this.model = model;}
    public String getName(){return name;}
    public String getBrand(){return brand;}
    public String getModel(){return model;}
}
