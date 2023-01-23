import java.util.Arrays;
import java.util.Random;

public class Hw1 {
    public static void main(String[] args) {

//      Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i

        Random rnd = new Random();
        int i = rnd.nextInt(2000);
        System.out.println(String.format("Random int: %d ", i));

//      Посчитать и сохранить в n номер старшего значащего бита выпавшего числа

        int n = 0;
        for (int j = 1, t = 0; t < i; j++) {
            n = j - 1;
            t = (int) Math.pow(2, j);
        }
        System.out.println(String.format("MSB: %d ", n));

//      Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1

        int firstNumber = findFirst(i, n);

        String[] m1 = findMultiples(firstNumber, n, "max");
        System.out.println(String.format("To Max Value: %s" ,Arrays.toString(m1)));

//      Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2

        String[] m2 = findMultiples(firstNumber, n, "min");
        System.out.println(String.format("To Min Value: %s" ,Arrays.toString(m2)));


    }
    static int findFirst(int input, int number) {
        if(input % number == 0) return input;
        else {
            int result = 0;
            while(result == 0) {
                if(input % number != 0) input++;
                else result = input;
            }
            return result;
        }

    }

    static String[] findMultiples(int start, int number, String arg) {
        String str = new String();
        if(arg == "max") {
            for (int i = start; i < Short.MAX_VALUE; i += number) {
                str += String.format("%d ", i);
            }
        }
        if (arg == "min"){
            for (int i = start - number; i > Short.MIN_VALUE; i -= number) {
                str += String.format("%d ", i);
            }
        }
        return str.split(" ");
    }
}

