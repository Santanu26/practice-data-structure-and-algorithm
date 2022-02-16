package string_related;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GroupShift249 {
    public static void main(String[] args) {
        String[] str = new String[]{"acd", "dfg", "wyz", "yab", "mop", "bdfh", "x", "moqs"};
        System.out.println("Input is: "+ Arrays.toString(str));
        System.out.println(groupShifted(str));
    }

    public static ArrayList<ArrayList<String>> groupShifted(String[] strs) {
        Map<String, ArrayList<String>> map = new HashMap<>();

        for (String str : strs) {
            String key = getKey(str);
            if (!map.containsKey(key)) {
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                map.put(str, list);
            } else {
                ArrayList<String> list = map.get(key);
                list.add(str);
                map.put(str, list);
            }
        }
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        res.addAll(map.values());
        return res;
    }

    public static String getKey(String str) {

        String key = "";

        for (int i = 1; i < str.length(); i++) {
            char curr = str.charAt(i);
            char prev = str.charAt(i - 1);
            int diff = curr - prev;
            if (diff < 0) {
                diff += 26;
            }
            key += diff + "#";
        }
        key += ".";
        return key;
    }
}
