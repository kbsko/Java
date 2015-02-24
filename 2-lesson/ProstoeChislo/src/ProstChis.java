import java.util.Scanner;

/**
 * Created by Kubish on 19.02.2015.
 */
public class ProstChis {
    public static void main(String argc[]) {
        System.out.println("Прогрмма находит простые числа от 0 до N");
        int n = 0;
        Scanner sc = new Scanner(System.in); // vvod znacheniy
        System.out.print("Введите N: ");
        if (sc.hasNextInt()) {
            n = sc.nextInt();
        } else System.out.println("Вы ввели не целое число");

        if (n < 0) {
            System.out.println("Вы ввели отрицательное число! Число будет домножено на -1");
            n = n * -1;
        }

        boolean[] triggerprime = new boolean[n + 1];         // n+1 dla proverka krainego chisla
        for (int i = 2; i < triggerprime.length; i++) {     //zapolnyaem massiv (vse chisla prostie)
            triggerprime[i] = true;
        }

        for (int i = 2; i < triggerprime.length; i++) {
            if (triggerprime[i]) {                               // proverka na prostatu
                for (int j = 2; i * j < triggerprime.length; j++) {   // vicherkivaem kratnie chisla
                    triggerprime[i * j] = false;
                }
            }
        }


        System.out.println("Простые числа от 0 до " + n);
        for (int i = 0; i < triggerprime.length; i++) {  // vivod rusultata
            if (triggerprime[i]) {
                System.out.print(i + " ");

            }


        }
    }
}
