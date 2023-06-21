import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class Main {
        public static void main(String[] args) {
        // Создаем HashMap для хранения имени и списка телефонов
        HashMap<String, List<String>> phoneBook = new HashMap<>();

        // Ввод данных
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные в формате Имя Телефон. Для завершения введите 'q'.");
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("q"))
                break;
            String[] data = input.split(" ");
            String name = data[0];
            String phone = data[1];

            // Проверяем, есть ли уже такое имя в телефонной книге
            if (phoneBook.containsKey(name)) {
                // Если есть, добавляем телефон к списку
                List<String> phones = phoneBook.get(name);
                phones.add(phone);
            } else {
                // Если нет, создаем новый список с текущим телефоном и добавляем его в книгу
                List<String> phones = new ArrayList<>();
                phones.add(phone);
                phoneBook.put(name, phones);
            }
        }

        // Сортировка по убыванию числа телефонов
        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(phoneBook.entrySet());
        entries.sort(Comparator.comparingInt(entry -> entry.getValue().size()));
        Collections.reverse(entries);

        // Вывод отсортированного списка
        System.out.println("Телефонная книга:");
        for (Map.Entry<String, List<String>> entry : entries) {
            String name = entry.getKey();
            List<String> phones = entry.getValue();
            System.out.printf("%s: %s%n", name, phones);
        }
        
    }
}
