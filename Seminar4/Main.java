import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> humansSurName = new ArrayList<>(); // Фамилия
        ArrayList<String> humansName = new ArrayList<>(); // Имя
        ArrayList<String> humansFatherland = new ArrayList<>(); // Отечество
        ArrayList<Integer> humansOld = new ArrayList<>(); // Возраст
        ArrayList<String> humansGender = new ArrayList<>(); // Пол

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные в формате ФИО возраст пол. Для завершения введите 'q'.");
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("q"))
                break;
            String[] data = input.split(" ");

            humansSurName.add(data[0]);
            humansName.add(data[1]);
            humansFatherland.add(data[2]);
            humansOld.add(Integer.parseInt(data[3]));
            humansGender.add(data[4]);
        }

        System.out.println("Выберите гендер для сортировки (М/Ж):");
        String genderInput = scanner.nextLine();
        if (genderInput.equalsIgnoreCase("М") || genderInput.equalsIgnoreCase("Ж")) {
            sortAndPrintByGender(humansSurName, humansName, humansFatherland, humansOld, humansGender, genderInput);
        } else {
            System.out.println("Некорректный выбор гендера.");
        }
    }

    public static void sortAndPrintByGender(ArrayList<String> surNames, ArrayList<String> names,
                                            ArrayList<String> fatherlands, ArrayList<Integer> ages,
                                            ArrayList<String> genders, String inputGender) {
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0; i < genders.size(); i++) {
            if (genders.get(i).equalsIgnoreCase(inputGender)) {
                indices.add(i);
            }
        }

        indices.sort(Comparator.comparingInt(ages::get));
        ArrayList<Integer> remainingindices = new ArrayList<>();
        for (int i = 0; i < surNames.size(); i++) {
            if (!indices.contains(i)) {
                remainingindices.add(i);
            }
        }
        System.out.println();
        System.out.println("Отсортированный список по возрасту (гендер: " + inputGender + "):");
            for (int index : indices) {
                System.out.printf("%s %s. %s. %d %s\n", surNames.get(index), names.get(index).charAt(0),
                        fatherlands.get(index).charAt(0), ages.get(index), genders.get(index));
            }
            for (int index : remainingindices) {
                System.out.printf("%s %s. %s. %d %s\n", surNames.get(index), names.get(index).charAt(0),
                        fatherlands.get(index).charAt(0), ages.get(index), genders.get(index));
            }
        }
    }



/*
     * Петров Петр Петрович 24 М
     * Сергеева Мария Владимировна 22 Ж
     * Иванов Иван Иванович 29 М
     * Сергеев Евгений Павлович 25 М
     * Мкртычан Юлия Анатольевна 32 Ж
     */

