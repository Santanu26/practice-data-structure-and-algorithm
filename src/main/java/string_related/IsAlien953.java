package string_related;

import java.util.HashMap;
import java.util.Map;

public class IsAlien953 {
    public static void main(String[] args) {

        String[] words1 = new String[]{"hello", "leetcode"};
        String order1 = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(isAlienSorted(words1, order1));
        System.out.println(method(words1, order1));

        System.out.println("-----------------------------------------");

        String[] words2 = new String[]{"word", "world", "row"};
        String order2 = "worldabcefghijkmnpqstuvxyz";
        System.out.println(isAlienSorted(words2, order2));
        System.out.println(method(words2, order2));
        System.out.println("-----------------------------------------");


        String[] words3 = new String[]{"apple", "app"};
        String order3 = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(isAlienSorted(words3, order3));
        System.out.println(method(words3, order3));
    }

    public static boolean method(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        for (int i = 1; i < words.length; i++) {
            if (!words[i - 1].equals(words[i]) && !isSmaller(words[i - 1], words[i], map)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isSmaller(String curr, String next, Map<Character, Integer> mapp) {
        int len = Math.min(curr.length(), next.length());

        for (int i = 0; i < len; i++) {
            if (curr.charAt(i) != next.charAt(i)) {
                return mapp.get(curr.charAt(i)) < mapp.get(next.charAt(i));
            }
        }
        return curr.length() < next.length();
    }

    public static boolean isAlienSorted(String[] words, String order) {

        int[] alienOrderedAlphabet = new int[26];

        mapAlienCharWithOrder(alienOrderedAlphabet, order);

        for (int i = 0; i < words.length - 1; i++) {
            String currWord = words[i];
            String nxtWord = words[i + 1];
            int minLength = Math.min(currWord.length(), nxtWord.length());

            // minLength(current) == minLength(next) --> true
            // minLength(current) < minLength(next) ---> true
            // minLength(current>minLength(next) ---> false

            if (minLength != currWord.length() && currWord.startsWith(nxtWord)) {
                return false;
            }

            for (int start = 0; start < minLength; start++) {
                if (alienOrderedAlphabet[currWord.charAt(start) - 'a'] > alienOrderedAlphabet[nxtWord.charAt(start) - 'a']) {
                    return false;
                }

                if (alienOrderedAlphabet[currWord.charAt(start) - 'a'] < alienOrderedAlphabet[nxtWord.charAt(start) - 'a']) {
                    break;
                }
            }
        }
        return true;
    }

    public static void mapAlienCharWithOrder(int[] mapp, String order) {
        int seq = 0;
        for (char ch : order.toCharArray()) {
            mapp[ch - 'a'] = seq++;
        }
    }
}
