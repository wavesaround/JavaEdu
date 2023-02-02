import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Hw4 {
    public static void main(String[] args) throws IOException {

        // #1: Сохранить в файл строку и загрузить из файла строку с выводом в консоль используя классы FileWriter и FileReader

        FileWriter fileWriter = new FileWriter("file.txt");
        fileWriter.append("Привет, Мир!");
        fileWriter.flush();

        String text = "";
        FileReader reader = new FileReader("file.txt");
        while (reader.ready()) {
            text += (char) reader.read();
        }
        System.out.println(text);

        // #2: Загрузить из файла многострочный текст формата ФИО возраст и пол через пробелы.
        // Разбить по строкам и вывести в консоль в формате "Иванов И.И. 32 М"

        reader = new FileReader("db.sql");

        String fileText = "";
        while (reader.ready()) {
            fileText += (char) reader.read();
        }

        List<String> stringList = List.of(fileText.split("\n"));

        for (int i = 0; i < stringList.size(); i++) {
            List<String> item = List.of(stringList.get(i).split(" "));
            printCards(item);
        }
        System.out.println("--------");

        // #3: Загруженный и разбитый по строкам текст загрузить в подготовленные списки.
        // Фамилии, имена, отчества, возрас и пол в отдельных списках.

        LinkedList<String> surname = new LinkedList<>();
        LinkedList<String> name = new LinkedList<>();
        LinkedList<String> secName = new LinkedList<>();
        LinkedList<Integer> age = new LinkedList<>();
        LinkedList<String> sex = new LinkedList<>();
        LinkedList<Integer> id = new LinkedList<>();
        String[] tempString;

        for (int i = 0; i < stringList.size(); i++) {
            tempString = stringList.get(i).split(" ");
            id.add(i);
            surname.add(tempString[0]);
            name.add(tempString[1]);
            secName.add(tempString[2]);
            age.add(Integer.parseInt(tempString[3]));
            sex.add(tempString[4]);
        }

        // #4: Отсортировать по возрасту используя дополнительный список индексов

        sortingID(age, id);

        ListIterator<Integer> idx = id.listIterator();
        while (idx.hasNext()) {
            List<String> item = List.of(stringList.get(idx.next()).split(" "));
            printCards(item);
        }
    }


    public static void printCards(List<String> item){
        System.out.printf("%s %s. %s. %s %s \n",
                item.get(0),
                item.get(1).charAt(0),
                item.get(2).charAt(0),
                item.get(3),
                item.get(4).toUpperCase().charAt(0));
    }


    public static void sortingID(LinkedList<Integer> lst, LinkedList<Integer> ids) {
        ArrayList<Integer> remote = new ArrayList<>(lst);
        int temp;
        int temp2;
        int count = 0;
        while (count != remote.size()) {
            for (int i = 0; i < remote.size() - count - 1; i++) {
                if(remote.get(i) > remote.get(i+1)) {
                    temp = ids.get(i);
                    ids.set(i, ids.get(i+1));
                    ids.set(i+1, temp);
                    temp2 = remote.get(i);
                    remote.set(i, remote.get(i+1));
                    remote.set(i+1, temp2);
                }
            }
            count++;
        }
    }
}