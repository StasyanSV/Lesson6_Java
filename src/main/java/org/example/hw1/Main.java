/*
Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
Создать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки,
отвечающие фильтру. Критерии фильтрации можно хранить в Map.
Например: Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …
Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Создаем множество ноутбуков
        //List<Notebook> listNb = Db.init(10);
        List<Notebook> listNb = Db.init(10);
        System.out.println(listNb);

        Scanner scanner = new Scanner(System.in);

        // Фильтр по параметрам, введенным пользователем
        Map<Integer, String> filter = new HashMap<>();

        int input = 0;
        while (input != 7){
            System.out.println("Введите цифру, соответствующую необходимому критерию:\n" +
                    "1 - ОЗУ, 2 - Объем HDD, 3 - Операционная система, 4 - Цвет, 5 - Поиск, 6 - Удалить фильтры, 7 - Выход:");
            input = scannerCheck(scanner);

            if (input == 1) {
                System.out.printf("Выберите минимальный размер RAM: (минимум %d, максимум %d)\n",
                        Config.getMinRam(),Config.getMaxRam());
                input = scannerCheck(scanner);

                if (input < Config.getMinRam() || input > Config.getMaxRam()){
                    System.out.println("!!! Неверный размер RAM (больше максимума или меньше минимума)");
                    System.out.println();
                } else {
                    filter.put(1, Integer.toString(input));
                    System.out.println("Фильтр применен.");
                    System.out.println();
                }
            } else if (input == 2) {
                System.out.printf("Выберите минимальный размер HDD: (минимум %d, максимум %d)\n",
                        Config.getMinHdd(),Config.getMaxHdd());
                input = scannerCheck(scanner);

                if (input < Config.getMinHdd() || input > Config.getMaxHdd()){
                    System.out.println("!!! Неверный размер HDD (больше максимума или меньше минимума)");
                    System.out.println();
                } else {
                    filter.put(2, Integer.toString(input));
                    System.out.println("Фильтр применен.");
                    System.out.println();
                }
            } else if (input == 3) {
                System.out.print("Выберите OS: ");
                for (int i = 0; i < Config.getArrOs().length; i++) {
                    System.out.print(i + " - " + Config.getArrOs()[i] + " ");
                }
                System.out.println();
                input = scannerCheck(scanner);

                if (input < 0 || input > Config.getArrOs().length){
                    System.out.println("!!! Неверное значение OS");
                    System.out.println();
                } else {

                    filter.put(3, Config.getArrOs()[input]);
                    System.out.println("Фильтр применен.");
                    System.out.println();
                }
            } else if (input == 4) {
                System.out.print("Выберите цвет: ");
                for (int i = 0; i < Config.getArrColor().length; i++) {
                    System.out.print(i + " - " + Config.getArrColor()[i] + " ");
                }
                System.out.println();
                input = scannerCheck(scanner);

                if (input < 0 || input > Config.getArrColor().length){
                    System.out.println("!!! Неверное значение цвета");
                    System.out.println();
                } else {
                    filter.put(4, Config.getArrColor()[input]);
                    System.out.println("Фильтр применен.");
                    System.out.println();
                }
            } else if (input == 5) {
                System.out.println(filter);
                if (filter.isEmpty()){
                    System.out.println(listNb);
                } else {
                    for (int i = 0; i < listNb.size(); i++) {
                        if ((filter.containsKey(1) && Integer.parseInt(filter.get(1)) > listNb.get(i).getRam()) ||
                                (filter.containsKey(2) && Integer.parseInt(filter.get(2)) > listNb.get(i).getHdd()) ||
                                (filter.containsKey(3) && !filter.get(3).equals(listNb.get(i).getOs()))  ||
                                (filter.containsKey(4) && !filter.get(4).equals(listNb.get(i).getColor()))) {
                            listNb.remove(i);
                            i--;
                        }
                    }
                }
                System.out.println(listNb);
            } else if (input == 6) {
                filter.clear();
                System.out.println("Фильтры очищены.");
                System.out.println();
            } else if (input == 7) {
                System.out.println("Попрощались!");
                System.out.println();
            } else {
                System.out.println("!!! Вы ввели неверную цифру, повторите ввод");
                System.out.println();
            }
        }
        scanner.close();
    }

    static int scannerCheck(Scanner scanner){
        while (!scanner.hasNextInt()){
            System.out.println("Неверный ввод, повторите ввод");
            scanner.next();
        }
        return Integer.parseInt(scanner.next());
    }
}
