import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;

public class Hw3 {
    public static void main(String[] args) {

        // Задача 1

        ArrayList<String> colorsList = new ArrayList<>();
        colorsList.add("Green");
        colorsList.add("Red");
        colorsList.add("White");
        colorsList.add("Black");
        colorsList.add("Yellow");
        colorsList.add("Blue");
        colorsList.add("Orange");
        System.out.println("Task 1: " + colorsList);

        // Задача 2

        System.out.printf("Task 2: ");
        ListIterator<String> listiterator = colorsList.listIterator();
        while (listiterator.hasNext()) {
            String str = listiterator.next();
            System.out.printf("%s! ", str);
        }
        System.out.println();

        // Задача 3

        colorsList.add(0, "Magenta");
        System.out.println("Task 3: " + colorsList);

        // Задача 4

        System.out.println("Task 4: " + colorsList.get(5));

        // Задача 5

        colorsList.set(4, "Grey");
        System.out.println("Task 5: " + colorsList);

        // Задача 6

        colorsList.remove(3);
        System.out.println("Task 6: " + colorsList);

        // Задача 7

        int findIndex = colorsList.indexOf("Blue");
        System.out.println("Task 7: " + findIndex);

        // Задача 8

        ArrayList<String> newList = new ArrayList<>();
        for (int i = 0; i < colorsList.size(); i++) {
            if (colorsList.get(i).length() > 4) {
                newList.add(colorsList.get(i));
            }
        }
        System.out.printf("Task 8: ");
        newList.forEach( (k) -> System.out.printf("%s ", k) );
        System.out.println();

        // Задача 9 (почему-то элемент "Grey" все равно остается в первом списке, хотя его нет во втором)

        for (int i = 0; i < colorsList.size(); i++) {
            if (newList.contains(colorsList.get(i)) == false) {
                colorsList.remove(i);
            }
        }
        System.out.println("Task 9: " + colorsList);

        // Задача 10

        colorsList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        System.out.println("Task 10: " + colorsList);
    }
}
