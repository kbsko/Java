import java.util.Random;
import java.util.Scanner;

/**
 * Created by Kubish on 19.02.2015.
 */
public class FindinMassive {
    public static int find(int[] mas, int zn, int N) {
        int left = 0;
        int right = N;
        int finded;   // элемент поиска или средний элемент
        while (left <= right) {
            finded = left + (right - left) / 2;
            if (zn < mas[finded]) right = finded - 1;   //определяем правую границу
            else if (zn > mas[finded]) left = finded + 1; //опредялякм левую границу
            else return finded;

        }

        return -1; // если значение не найдено
    }

    public static int vvod() {          // vvod znacheniy
        int n = 0;
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            n = sc.nextInt();
        } else System.out.println("Вы ввели не целое число");

        if (n < 0) {
            System.out.println("Вы ввели отрицательное число! Число будет домножено на -1");
            n = n * -1;
        }

        return n;

    }

    public static void outputmas(int[] mas) {   //vivod massiva
        for (int i = 0; i < mas.length; i++) {
            System.out.print(mas[i] + " ");
        }

    }


    public static void findnotsort(int[] mas, int find) {  // Find Not Sorted Massive
        boolean trigger = false;

        for (int i = 0; i < mas.length; i++) {     //poisk v massive
            if (find == mas[i]) {
                System.out.print("Элемент найден в позиции " + (i + 1));
                trigger = true;
                break;

            }
        }
        if (!trigger) System.out.print("Элемент  не найден");

    }


    public static int[] bubblesort(int[] mas) {  //Sortirovka bubble
        for (int i = mas.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (mas[j] > mas[j + 1]) {
                    int tmp = mas[j];
                    mas[j] = mas[j + 1];
                    mas[j + 1] = tmp;
                }
            }
        }
        return mas;
    }


    public static void main(String argc[]) {
        System.out.println("Прогрмма находит значение в массиве");
        int n = 0;
        System.out.print("Задайте случайный массив из N элементов. Введите N: ");
        n = vvod();  //Vvod N
        Random random = new Random();
        int[] intmas = new int[n];
        for (int i = 0; i < intmas.length; i++) {     //zapolnyaem massiv  random
            intmas[i] = Math.abs(random.nextInt() % 100);
        }
        outputmas(intmas); //vivod massiva
        int find = 0;
        System.out.print("\nВведите значение для поиска: ");
        find = vvod();  //Vvod znachinia poiska

        long start = System.nanoTime();

        findnotsort(intmas, find);  // Find Not Sort massive
        long finish = System.nanoTime();
        long timeConsumedMillis = finish - start;
        System.out.println("\nВремя выполнения кода: " + timeConsumedMillis + " наносекунд");
        intmas = bubblesort(intmas);
        outputmas(intmas); //vivod massiva
        start = System.nanoTime();
        find = find(intmas, find, intmas.length);  // Find Sort Massive
        finish = System.nanoTime();
        if (find == -1) {
            System.out.print("\nЭлемент  не найден");
        } else System.out.print("\nЭлемент найден в позиции " + (find + 1));
        timeConsumedMillis = finish - start;
        System.out.println("\nВремя выполнения кода: " + timeConsumedMillis + " наносекунд");
    }
}
