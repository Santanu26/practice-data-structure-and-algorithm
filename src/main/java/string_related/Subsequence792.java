package string_related;

// N^2 solution
public class Subsequence792 {
    public static void main(String[] args) {
        String s = "abcde";
        String[] words = new String[]{"a", "bb", "acd", "ace"};

        System.out.println(matching(s, words));
       // System.out.println(numMatchingSubseq(s, words));

    }

    public static int matching(String s, String[] words) {

        int count = 0;

        for (String word : words) {
            if (checkSubSequence(word, s)) {
                count += 1;
            }
        }
        return count;
    }

    private static boolean checkSubSequence(String word, String s) {
        int prevCharIndex = 0;

        for (char ch : word.toCharArray()) {
            int index = s.indexOf(ch, prevCharIndex);

            if (index == -1) {
                return false;
            }
            prevCharIndex = index + 1;
        }
        return true;
    }

}
