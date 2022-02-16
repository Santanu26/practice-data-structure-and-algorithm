package cracking_the_coding_interview_book.chap_01;

public class IsUniqueCharacter {
    public static void main(String[] args) {

        String str = "shantanu";
        String str1 = "abcdef";
        System.out.println(isUniqueChar(str));
        System.out.println(isUniqueChar(str1));

    }
    public static boolean isUniqueChar(String str) {

        if (str.length()>128) {return false;}

        boolean[] char_set = new boolean[128];

        for (int i = 0;i < str.length();i++) {
            int val = str.charAt(i);
            if (char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }

    public static boolean method(String str) {

        if (str.length() >128) {
            return false;
        }

        boolean[] char_set = new boolean[128];

        for (int i = 0;i< str.length();i++) {
            int val = str.charAt(i);

            if (char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }

        return true;
    }
}
