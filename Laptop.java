package lesson_3.homework2;

public class Laptop extends LaptopAndTablet {
    private int SSD;
    private String videoCard;

    public Laptop(String brand, String model, float diagonal, int SSD, int RAM, String videoCard) {
        this.name = "Ноутбуки";
        this.brand = brand;
        this.model = model;
        this.diagonal = diagonal;
        this.SSD = SSD;
        this.RAM = RAM;
        this.videoCard = videoCard;
    }

    public void setSSD(int SSD) {
        if (SSD >= 16 && SSD <= 4096) this.SSD = SSD;
    }

    public int getSSD() {
        return SSD;
    }

    public void setVideoCard(String videoCard) {
        this.videoCard = videoCard;
    }

    ;

    public String getVideoCard() {
        return videoCard;
    }

    public void open() {
        super.open();
    }
}


