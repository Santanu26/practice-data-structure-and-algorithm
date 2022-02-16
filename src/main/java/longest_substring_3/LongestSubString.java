package longest_substring_3;

import java.util.HashSet;

public class LongestSubString {
    public static void main(String[] args) {
        String str = "abca";
        System.out.println(longestUniqueSubString("Abca"));
        System.out.println(longestUniqueSubString("abcabcbb"));
        System.out.println(longestUniqueSubString("bbbbb"));
        System.out.println(longestUniqueSubString("pwwkew"));
    }
    public static int longestUniqueSubString(String str) {

        int aPointer = 0;
        int bPointer = 0;
        int max = 0;

        HashSet<Character> hashSet = new HashSet<>();

        while (bPointer< str.length()) {
            if (!hashSet.contains(str.charAt(bPointer))) {
                hashSet.add(str.charAt(bPointer));
                max = Math.max(hashSet.size(), max);
                bPointer++;
            } else {
                hashSet.remove(str.charAt(aPointer));
                    aPointer++;
            }
        }
        return max;
    }


}
