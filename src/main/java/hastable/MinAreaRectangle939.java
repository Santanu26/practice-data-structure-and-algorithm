package hastable;

import java.util.*;

public class MinAreaRectangle939 {
    public static void main(String[] args) {

        int[][] points = {{1, 1}, {1, 3}, {3, 1}, {3, 3}, {2, 2}};
        //[[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]
        int[][] points2 = {{1,1},{1,3},{3,1},{3,3},{4,1},{4,3}};
        System.out.println(minAreaRect(points));
        System.out.println(minAreaRect(points2));

        System.out.println(minAreaUsingHashMap(points));
        System.out.println(minAreaUsingHashMap(points2));

    }

    public static int minAreaUsingHashMap(int[][] points) {
        Map<Integer,Set<Integer>> map = new HashMap<>();
        for (int[] p: points) {
            if (!map.containsKey(p[0])) {
                map.put(p[0], new HashSet<>());
            }
            map.get(p[0]).add(p[1]);
        }
        int min = Integer.MAX_VALUE;

        for (int[] p1: points) {
            for (int[] p2: points) {
                int x1 = p1[0];
                int y1 = p1[1];
                int x2 = p2[0];
                int y2 = p2[1];
                if (x1 == x2 || y1 ==y2) {
                    continue;
                }
                if (map.get(x1).contains(y2) && map.get(x2).contains(y1)) {
                    int area = Math.abs(x1-x2) * Math.abs(y1-y2);
                    min = Math.min(min, area);
                }
            }
        }
        return min == Integer.MAX_VALUE? 0: min;
    }
 // Using HashSet
    public static int minAreaRect(int[][] points) {
        Set<List<Integer>> set = new HashSet<>();

        for (int[] point : points) {
            List<Integer> list = new ArrayList<>(Arrays.asList(point[0], point[1]));
            set.add(list);
        }
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int[] a = points[i];
                int[] b = points[j];

                if ((a[0] == b[0]) || (a[1] == b[1])) continue;

                List<Integer> list1 = new ArrayList<>(Arrays.asList(a[0], b[1]));
                List<Integer> list2 = new ArrayList<>(Arrays.asList(b[0], a[1]));

                if (set.contains(list1) && set.contains(list2)) {
                    int area = Math.abs(a[0] - b[0]) * Math.abs(b[1] - a[1]);
                    min = Math.min(min, area);
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
