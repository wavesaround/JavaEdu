import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Cw4 {
    public static void main(String[] args) throws IOException {

//        FileWriter fileWriter = new FileWriter("db.sql");
//        fileWriter.append("Привет Мир!");
//        fileWriter.flush();
//
//        String text = "";
//        reader = new FileReader("db.sql");
//
//        while (reader.ready()) {
//            text += (char) reader.read();
//        }
//
//        System.out.println(text);

//        Текст в формате ФИО + возраст + пол
//        5-6 человкек
//        считать и разделить по строкам и словам
//        создать списки отдельно для фамилий, имён отчеств возраста и пола
//        заполнить данными для каждого человека из файла

        FileReader reader = new FileReader("db.sql");

        String fileText = "";
        while (reader.ready()) {
            fileText += (char) reader.read();
        }

        List<String> stringList = List.of(fileText.split("\n"));

        String[] tempString;

        LinkedList<String> surname = new LinkedList<>();
        LinkedList<String> name = new LinkedList<>();
        LinkedList<String> secName = new LinkedList<>();
        LinkedList<Integer> age = new LinkedList<>();
        LinkedList<Boolean> sex = new LinkedList<>();
        LinkedList<Integer> id = new LinkedList<>();

        for (int i = 0; i < stringList.size(); i++) {
            tempString = stringList.get(i).split(" ");
            surname.add(tempString[0]);
            name.add(tempString[1]);
            secName.add(tempString[2]);
            int ageInt = Integer.parseInt(tempString[3]);
            age.add(ageInt);
            sex.add(toBoolean(tempString[4]));
            id.add(i);
        }

        sortId(age, id);


        System.out.println(surname);
        System.out.println(name);
        System.out.println(secName);
        System.out.println(age);
        System.out.println(sex);
        System.out.println(id);
    }

    public static boolean toBoolean(String sexFrom) {
        if (sexFrom.equals("муж")) return true;
        else return false;
    }

    public static void sortId(LinkedList<Integer> ages, LinkedList<Integer> ids) {
        int temp;
        int temp2;
        int count = 0;
        for (int i = 0; i < ages.size() - count; i++) {
            if (ages.get(i) > ages.get(i+1)) {
                temp = ages.get(i + 1);
                temp2 = ids.get(i + 1);
                ages.set(i + 1, temp);
                ids.set(i + 1, temp2);
                count++;
            }
        }

    }
}
