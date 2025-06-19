package Task_SimpleCalc;

import java.util.Scanner;

public class SimpleCalc {

    public static void main(String[] args) {
        int N = inputNumber();

        if (checkingNumber(N)) {
            System.out.println("Число N является простым");
            numberSum(N);
        } else {
            System.out.println("Число N не является простым");
        }
    }

    public static int inputNumber() {
        Scanner scanner = new Scanner((System.in));
        System.out.print("Введите число: ");

        while (true) {
            if (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                if (num > 1) {
                    return num;
                } else {
                    System.out.println("Ошибка ввода");
                }
            } else {
                System.out.print("Введено не целое число. Повторите ввод: ");
                scanner.next();
            }
        }
    }

    public static boolean checkingNumber(int N) {
        if (N == 2 || N == 3) {
            return true;
        }
        if (N % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= N; i += 2) {
            if (N % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void numberSum(int N) {
        int sum = 0;

        for (int i = 2; i < N; i++) {
            boolean simple = true;

            if (i == 2 || i == 3) {
                sum += i;
                continue;
            }

            if (i % 2 == 0) {
                continue;
            }

            for (int x = 3; x * x <= i; x += 2) {
                if (i % x == 0) {
                    simple = false;
                    break;
                }
            }

            if (simple){
                sum += i;
            }
        }
        System.out.println("Сумма всех простых чисел, меньших " + N + ", равна " + sum);
    }
}
