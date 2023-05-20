import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите первое число:");
        int firstNumber = new Scanner(System.in).nextInt();
        System.out.println("Введите второе число:");
        int secondNumber = new Scanner(System.in).nextInt();
        //Сумма чисел
        int sum = firstNumber + secondNumber;
        System.out.println("Сумма: " + sum);
        //Разность чисел
        int difference = firstNumber - secondNumber;
        System.out.println("Разность: " + difference);
        //Произведение чисел
        int multiplication = firstNumber * secondNumber;
        System.out.println("Произведение: " + multiplication);
        //Частное чисел
        double quotient = (double) firstNumber / secondNumber;
        System.out.println("Частное: " + quotient);

    }
}
