public class Notebook {
    private final int id;
    private final int ram;
    private final int hdd;
    private final String os;
    private final String color;

    public Notebook(int id, int ram, int hdd, String os, String color){
        this.id = id;
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this.color = color;
    }

    public int getId() {
        return id;
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

    @Override
    public String toString() {
        return String.format("Ноутбук %d. RAM: %d, HDD: %d, OS: %s, Color: %s.\n", id, ram,hdd,os,color);
    }
}
