package lesson_3.homework2;

public class LaptopAndTablet extends Category {
    protected float diagonal;
    protected int RAM;
    public void open() {
        if (name == null) {
            System.out.println("Вы находитесь в разделе Ноутбуки и Планшеты, выберите подраздел");
        } else {
            System.out.println("Открыта категория " + name);
        }
    }
}

