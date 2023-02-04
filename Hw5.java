import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.TreeMap;

public class Hw5 {
    public static void main(String[] args) {
        // HashMap

        HashMap<Integer, String> hashMap = new HashMap<>();
        Random rnd = new Random();
        hashMap.put(rnd.nextInt(1000), "Red");
        hashMap.put(rnd.nextInt(1000), "Green");
        hashMap.put(rnd.nextInt(1000), "Blue");
        System.out.println(hashMap);
        hashMap.putIfAbsent(595, "Yellow");
        System.out.println(hashMap);
        Iterator<Integer> iterator = hashMap.keySet().iterator();
        while(iterator.hasNext()) {
            int tmp = iterator.next();
            hashMap.put(tmp, hashMap.get(tmp) + "!");
        }
        System.out.println(hashMap);

        // TreeMap

        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(rnd.nextInt(1000,1200), "Red");
        treeMap.put(rnd.nextInt(1000, 1200), "Green");
        treeMap.put(rnd.nextInt(1000, 1200), "Blue");
        System.out.println(treeMap);

        // 1000

        for (int i = 1; i < 1000; i++) {
            treeMap.put(i, "Example");
        }

        // Time

        long begin1 = System.currentTimeMillis();
        System.out.println(treeMap);
        long end1 = System.currentTimeMillis();

        long begin2 = System.currentTimeMillis();
        treeMap.forEach((k, v) -> System.out.printf("%d %s, ", k, v));
        long end2 = System.currentTimeMillis();

        System.out.println();
        System.out.println(end1 - begin1);
        System.out.println(end2 - begin2);
    }
}
