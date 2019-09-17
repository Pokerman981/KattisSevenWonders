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

        int control = 0;
        char last;

        for (int i = 0; i < s.length(); i++) {
            integerStringHashMap.put(s.charAt(i), integerStringHashMap.get(s.charAt(i))+1);
            last = s.charAt(i);
            if (last != s.charAt(i)) {
                control++;
            }

            if (control > 7) {
                total += 7;
                control = 0;
            }
        }


        integerStringHashMap.forEach((character, integer) -> {
            integerStringHashMap.put(character, (int) Math.pow(integerStringHashMap.get(character), 2));
        });


        integerStringHashMap.forEach((character, integer) -> total =+ integer);
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
