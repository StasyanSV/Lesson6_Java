public class Config {
    // конфиги
    private final static int minRam = 8;
    private final static int maxRam = 64;
    private final static int minHdd = 256;
    private final static int maxHdd = 2048;
    private final static String[] arrOs = new String[]{"Linux", "Windows", "MacOS"};
    private final static String[] arrColor = new String[]{"Red", "Green", "Blue", "White", "Black"};

    public static int getMinRam() {
        return minRam;
    }

    public static int getMinHdd() {
        return minHdd;
    }

    public static int getMaxHdd() {
        return maxHdd;
    }

    public static int getMaxRam() {
        return maxRam;
    }

    public static String[] getArrColor() {
        return arrColor;
    }

    public static String[] getArrOs() {
        return arrOs;
    }
}