import java.util.ArrayList;
import java.util.List;

public class Db {
    static List<Notebook> init(int quantity){
        List<Notebook> list = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            int ram = (int) (Math.random() * (Config.getMaxRam() - Config.getMinRam()) + Config.getMinRam());
            int hdd = (int) (Math.random() * (Config.getMaxHdd() - Config.getMinHdd()) + Config.getMinHdd());
            int randOs = (int) (Math.random() * Config.getArrOs().length);
            int randColor = (int) (Math.random() * Config.getArrColor().length);
            list.add(i, new Notebook(i, ram, hdd, Config.getArrOs()[randOs], Config.getArrColor()[randColor]));
        }

        return list;
    }
}