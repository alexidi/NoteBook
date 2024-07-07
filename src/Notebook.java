import java.util.*;

class Notebook {
    private final String brand;
    private int ram; // ОЗУ в ГБ
    private int hdd; // Объем ЖД в ГБ
    private String os; // Операционная система
    private String color;

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

    // Сеттеры
    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Метод для сравнения ноутбуков
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notebook notebook = (Notebook) o;
        return ram == notebook.ram && hdd == notebook.hdd && Objects.equals(brand, notebook.brand) && Objects.equals(os, notebook.os) && Objects.equals(color, notebook.color);
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
