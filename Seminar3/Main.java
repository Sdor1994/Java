import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        
        // Добавление элементов в список
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(45));
        }
        
        // Вывод элементов списка в одну строку
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println(); // Переход на новую строку
        
        ArrayList<Integer> list1 = new ArrayList<>(list); // Создание копии списка
        
        // Удаление четных элементов из списка
        for (int i = list1.size() - 1; i >= 0; i--) {
            if (list1.get(i) % 2 == 0) {
                list1.remove(i);
            }
        }
        
        // Вывод элементов обновленного списка в одну строку
        for (int i = 0; i < list1.size(); i++) {
            System.out.print(list1.get(i) + " ");
        }
        System.out.println(); // Переход на новую строку
        
        // Поиск максимального значения 
        int max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            int current = list.get(i);
            if (current > max) {
                max = current;
            }
        }
        System.out.println("Максимальное значение: " + max); 
        System.out.println(); // Переход на новую строку


        // Поиск минимального значения
        int min = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            int current = list.get(i);
            if (current < min) {
                min = current;
            }
        }
        System.out.println("Минимальное значение: " + min); // Переход на новую строку
        System.out.println(); // Переход на новую строку
        
        double sum = 0;
        for (int i = 1; i < list.size(); i++) {
            sum = sum + list.get(i);
        }
        System.out.println("Сумма элементов равна: " + sum);
        sum = sum/list.size();
        System.out.println("Среднее значение равно: " + sum);

    }
}
