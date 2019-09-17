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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (containsWrong(s)) return;
        for (int i = 0; i < s.length(); i++) {
            integerStringHashMap.put(s.charAt(i), integerStringHashMap.get(s.charAt(i))+1);
        }

        integerStringHashMap.forEach((character, integer) -> {
            integerStringHashMap.put(character, (int) Math.pow(integerStringHashMap.get(character), 2));
        });

        integerStringHashMap.forEach((character, integer) -> {
            if (integer > 3) {
                integerStringHashMap.put(character, integerStringHashMap.get(character)+7);
            }
        });

        integerStringHashMap.forEach((character, integer) -> total = total + integer);
        System.out.println(total);






        }

    static boolean containsWrong(String s) {
        for (int i = 0; i > s.length(); i++) {
            char c = Character.toUpperCase(s.charAt(i));
            if (!chars.contains(c)) return true;
        }
        return false;
    }

}
