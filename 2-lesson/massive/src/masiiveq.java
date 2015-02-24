import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Kubish on 22.02.2015.
 */
public class masiiveq {

    public static int Input() {          // vvod znacheniy
        int n = 0;
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            n = sc.nextInt();
        } else System.out.println("Р’С‹ РІРІРµР»Рё РЅРµ С†РµР»РѕРµ С‡РёСЃР»Рѕ");

        if (n < 0) {
            System.out.println("Р’С‹ РІРІРµР»Рё РѕС‚СЂРёС†Р°С‚РµР»СЊРЅРѕРµ С‡РёСЃР»Рѕ! Р§РёСЃР»Рѕ Р±СѓРґРµС‚ РґРѕРјРЅРѕР¶РµРЅРѕ РЅР° -1");
            n = n * -1;
        }

        return n;

    }


    public static void main(String argc[]) {

        int[] intmas = {2, 5, 3, 8, 6};
        int temp;
        int trigger = 0;
        int q;
        System.out.println(Arrays.toString(intmas));
        System.out.print("Input q:");
        q = Input();


        for (int j = 0; j < intmas.length; j++) {   // от наибольшего значения отнимаем поочередно ментшие значения и ищем в массиве
            temp = q - intmas[j];

            for (int k = 0; k < intmas.length; k++) {  // поиск элемента в массиве
                if (k == j) continue;
                if (intmas[k] == temp) {
                    System.out.println("Элемент найден:" + q + "=" + intmas[j] + "+" + temp);
                    trigger = 1;
                    break;

                }

            }
            if (trigger == 1) break;
        }


    }
}
