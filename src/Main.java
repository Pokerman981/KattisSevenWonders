import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    static int total = 0;
    static List<Character> chars = Arrays.asList('T','G','C');
    static HashMap<Character, Integer> integerStringHashMap = new HashMap<Character, Integer>(){
        {
            chars.forEach(character -> put(character, 0));
        }
    };

    static HashMap<Character, Integer> bonusTracker = new HashMap<>();


        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (containsWrong(s)) return;

        char index;

        for (int i = 0; i < s.length(); i++) {
            integerStringHashMap.put(s.charAt(i), integerStringHashMap.get(s.charAt(i))+1);
            index = s.charAt(i);

            boolean containsValue = false;
            for (char c : bonusTracker.keySet()) {
                if (c == index) containsValue = true;
            }

            if (!containsValue) {
                bonusTracker.put(index, 1);

            } else {
                bonusTracker.put(index, bonusTracker.get(index) + 1);
            }
        }


        int loop = 0;

        loop2: for (int i = 0; i < bonusTracker.size(); i++) {
            if (bonusTracker.size() < 3) break loop2;
            for (char key : bonusTracker.keySet()) {
                int x = bonusTracker.get(key);
                if (x == 0) break loop2;
                bonusTracker.put(key, x-1);
            }

            loop++;

        }

        integerStringHashMap.forEach((character, integer) -> {
            integerStringHashMap.put(character, (int) Math.pow(integerStringHashMap.get(character), 2));
        });
        integerStringHashMap.forEach((character, integer) -> total = total + integer);

        System.out.println(total + loop*7);






        }

    static boolean containsWrong(String s) {
        for (int i = 0; i > s.length(); i++) {
            char c = Character.toUpperCase(s.charAt(i));
            if (!chars.contains(c)) return true;
        }
        return false;
    }

}
