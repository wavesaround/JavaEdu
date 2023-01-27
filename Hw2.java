public class Hw2 {
    // 1 задача
    public static String matchStr(String original, String substring) {
        if (original.toLowerCase()
                    .contains(substring.toLowerCase())) return "Содержит подстроку";
        else return "Подстрока не найдена";
    }

    // 2 задача
    public static String matchReverse(String original, String substring) {
        StringBuilder strRev = new StringBuilder();
        strRev.append(substring.toLowerCase()).reverse();
        if (original.toLowerCase()
                    .contains(strRev)) return "Является вращением";
        else return "Подстрока не найдена";
    }

    // 3 задача
    public static String reverseStr(StringBuilder origin, int count) {
        char temp = origin.charAt(count);
        int len = origin.length();
        if (count == len/2) return origin.toString();
        else {
            origin.setCharAt(count, origin.charAt(len-1-count));
            origin.setCharAt(len-1-count, temp);
            count++;
            return reverseStr(origin, count);
        }
    }

    // 4 задача
    public static StringBuilder twoNumbers(int one, int two) {
        StringBuilder finalStr = new StringBuilder();
        finalStr.append(one + " + " + two + " = " + (one + two))
                .append("   ")
                .append(one + " - " + two + " = " + (one - two))
                .append("   ")
                .append(one + " * " + two + " = " + (one * two));
        return finalStr;
    }

    // 5 задача
    public static StringBuilder insertDelete(StringBuilder str, String from, String to) {
        int idx = 0;
        while (str.indexOf(from) != -1) {
            idx = str.indexOf(from, idx);
            str.insert(idx, to);
            // специально удаляю во вторую очередь, чтобы не пытаться вставить строку в уже удаленный индекс
            str.deleteCharAt(idx + to.length());
        }
        return str;
    }

    // 6 задача
    public static StringBuilder replace(StringBuilder str, String from, String to) {
        int idx = 0;
        while (str.indexOf(from) != -1) {
            idx = str.indexOf(from, idx);
            str.replace(idx, idx + from.length(), to);
        }
        return str;
    }

    // String для 7 задачи
    public static String replaceString(String str, String from, String to) {
        str.replace(from, to);
        return str;
    }


    public static void main(String[] args) {
        String s1 = new String("public static void");
        String s2 = new String("void");
        String s3 = new String("diov citats cilbup");
        StringBuilder sb1 = new StringBuilder("public static void");
        StringBuilder sb2 = twoNumbers(3, 56);
        StringBuilder sb3 = new StringBuilder("=".repeat(10000));

        System.out.println("Результат задачи 1: " + matchStr(s1, s2));
        System.out.println("Результат задачи 2: " + matchReverse(s1,s3));
        System.out.println("Результат задачи 3*: " + reverseStr(sb1, 0));
        System.out.println("Результат задачи 4: " + twoNumbers(3, 56));
        System.out.println("Результат задачи 5: " + insertDelete(sb2, "=", "равно"));
        System.out.println("Результат задачи 6: " + replace(sb2, "=", "равно"));

        long begin1 = System.currentTimeMillis();
        replace(sb3, "=", "равно");
        long end1 = System.currentTimeMillis();

        long begin2 = System.currentTimeMillis();
        replaceString(sb3.toString(), "=", "равно");
        long end2 = System.currentTimeMillis();

        System.out.println("Результат задачи 7: StringBuilder: " + (end1 - begin1) + " String: " + (end2 - begin2));
    }
}
