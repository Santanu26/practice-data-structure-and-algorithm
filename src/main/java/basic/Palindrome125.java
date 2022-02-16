package basic;

public class Palindrome125 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome(String s) {


        if (s.length() == 0) {
            return false;
        }
        if (s.length() == 1) {
            return false;
        }
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int first = 0;
        int second = s.length() - 1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(first++) != s.charAt(second--)) {
                return false;
            }
        }
        return true;
    }
}
