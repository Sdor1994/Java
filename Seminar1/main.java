package Seminar.HomeWork1;

import java.util.Random;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        // Задача 1: Генерация случайного числа
        generateRandomNumber();

        // Задача 2: Определение номера старшего значащего бита числа
        findMSBPosition();

        // Задача 3: Создание массива кратных чисел
        createMultipleArray();

        // Задача 4: Создание массива некратных чисел
        createNonMultipleArray();
    }

    // Задача 1: Генерация случайного числа
    public static void generateRandomNumber() {
        Random random = new Random();
        int randomNum = random.nextInt(2001);
        System.out.println("Случайное число: " + randomNum);
    }

    // Задача 2: Определение номера старшего значащего бита числа
    public static void findMSBPosition() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число: ");
        int number = scanner.nextInt();

        int msbPosition = Integer.SIZE - Integer.numberOfLeadingZeros(number);

        System.out.println("Номер старшего значащего бита: " + msbPosition);
    }

    // Задача 3: Создание массива кратных чисел
    public static void createMultipleArray() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число: ");
        int n = scanner.nextInt();
        int i = 0;

        int count = (Short.MAX_VALUE - i) / n + 1;
        short[] m1 = new short[count];
        for (int j = 0; j < count; j++) {
            m1[j] = (short) (i + j * n);
        }

        System.out.println("Массив кратных чисел:");
        for (short num : m1) {
            System.out.println(num);
        }
    }

    // Задача 4: Создание массива некратных чисел
    public static void createNonMultipleArray() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число: ");
        int n = scanner.nextInt();
        int i = 0;

        int count = 0;
        short currentNum = Short.MIN_VALUE;
        while (currentNum <= i) {
            if (currentNum % n != 0) {
                count++;
            }
            currentNum++;
        }

        short[] m2 = new short[count];
        int index = 0;
        currentNum = Short.MIN_VALUE;
        while (currentNum <= i) {
            if (currentNum % n != 0) {
                m2[index] = currentNum;
                index++;
            }
            currentNum++;
        }

        System.out.println("Массив некратных чисел:");
        for (short num : m2) {
            System.out.println(num);
        }
    }
}
