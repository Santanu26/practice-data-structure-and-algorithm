package brute_force.substring;

public class SubStringMain {
    public static void main(String[] args) {
        String str = "abc";

        //subString(str);
        listingBySize(str);
    }

    public static void subString(String str) {
        for (int start = 0; start < str.length(); ++start) {
            for (int end = start + 1; end <= str.length(); ++end) {
                System.out.println(str.substring(start, end));
            }
        }
    }

    public static void listingBySize(String str) {
        for (int sz = 1; sz <= str.length(); ++sz) {
            for (int start = 0; start + sz <= str.length(); ++start) {
                System.out.println(str.substring(start, sz));
            }
        }
    }
}
