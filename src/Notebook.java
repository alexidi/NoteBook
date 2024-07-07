import java.util.*;

class Notebook {
    private final String brand;
    private final int ram; // ОЗУ в ГБ
    private final int hdd; // Объем ЖД в ГБ
    private final String os; // Операционная система
    private final String color;

    // Конструктор
    public Notebook(String brand, int ram, int hdd, String os, String color) {
        this.brand = brand;
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this.color = color;
    }

    // Геттеры
    public String getBrand() {
        return brand;
    }

    public int getRam() {
        return ram;
    }

    public int getHdd() {
        return hdd;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    // Метод для вывода информации о ноутбуке
    @Override
    public String toString() {
        return "Notebook{" +
                "brand='" + brand + '\'' +
                ", ram=" + ram +
                ", hdd=" + hdd +
                ", os='" + os + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
