/**
 * Created by Kubish on 20.02.2015.
 */
public class ReplaceString {
    public static String ReplaceText(String InputString, String OnReplace, String ToReplace) {
        String StringResult = null;
        char[] charIn = InputString.toCharArray();
        char[] charOnRep = OnReplace.toCharArray();   // Часть которую меням
        char[] charToRep = ToReplace.toCharArray();   // Часть на которую меняем

        char[] charResult = new char[(charIn.length + charToRep.length) * 3];
        int sovpad = 0;
        int schres = 0;

        for (int i = 0; i < charIn.length; i++) {      //Перебор начальной строки

            if (charIn[i] != charOnRep[0]) {              //Если не найдена часть совпадения строк. разные символы
                charResult[schres] = charIn[i];
                schres++;

            } else {
                int k = i;
                sovpad = 0;               // начало совпадения
                for (int j = 0; j < charOnRep.length; j++) {    //проверка совпадения всех символов
                    if (charIn[k] == charOnRep[j]) {
                        sovpad++;
                        k++;

                    }
                }

                if (sovpad == charOnRep.length)  //Если все символы совпали
                {
                    for (int z = 0; z < charToRep.length; z++) {
                        charResult[schres] = charToRep[z];   // Записываем в строку результат замены
                        schres++;


                    }
                    i = i + charOnRep.length - 1; // Компенсация символов найденной части

                } else {
                    charResult[schres] = charIn[i];   //Не все символы совпали.
                    schres++;

                }

            }

        }


        return StringResult = new String(charResult); // Вывод строки
    }


    public static void main(String argc[]) {
        System.out.println("Source text:");
        String InputString = "A message is encrypted by representing it as a number M";
        System.out.println(InputString);
        String OnReplace = "es";
        String ToReplace = "hello";
        String Result = null;
        Result = ReplaceText(InputString, OnReplace, ToReplace);
        System.out.println("\nReplaced text (" + OnReplace + " replaced " + ToReplace + "):");
        System.out.println(Result);

    }
}






