package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TimeInterval636 {
    public static void main(String[] args) {
        int n = 2;
        List<String> logs =
                new ArrayList<>(
                        Arrays.asList(
                                "0:start:0",
                                "0:start:2",
                                "0:end:5",
                                "1:start:6",
                                "1:end:6",
                                "0:end:7"
                        ));

        List<String> logs1 = new ArrayList<>(
                Arrays.asList("0:start:0",
                        "1:start:5",
                        "2:start:7",
                        "2:end:9",
                        "1:end:15",
                        "3:start:20",
                        "4:start:25",
                        "4:end:30",
                        "3:end:37",
                        "0:end:40")
        );

        //System.out.println(Arrays.toString(timeInterval(5, logs1)));
        //System.out.println(Arrays.toString(timeInterValWithDetail(5, logs1)));
        //System.out.println(Arrays.toString(timeIntervals(5, logs1)));

        //System.out.println(Arrays.toString(timeInterval(n, logs)));
        //System.out.println(Arrays.toString(timeInterValWithDetail(n, logs)));
        System.out.println(Arrays.toString(timeIntervals(n, logs)));

    }

    public static int[] timeIntervals(int n, List<String> logs) {

        int[] result = new int[n];
        Stack<Entry> stack = new Stack<>();
        int prevTime = 0;

        for (String log : logs) {
            String[] parts = log.split(":");
            int id = Integer.parseInt(parts[0]);
            String type = parts[1];
            int time = Integer.parseInt(parts[2]);

            if (type.equals("start")) {
                if (!stack.isEmpty()) {
                    Entry p = stack.peek();
                    result[p.id] += time - prevTime;
                }
                prevTime = time;
                stack.push(new Entry(id, time));
            } else {
                result[id] += time - prevTime + 1;
                prevTime = time + 1;
                stack.pop();
            }
        }
        return result;
    }

    public static int[] timeInterValWithDetail(int n, List<String> logs) {

        Stack<Pair> stack = new Stack<>();
        int[] result = new int[n];
        for (String log : logs) {
            String[] parts = log.split(":");

            int id = Integer.parseInt(parts[0]);
            int time = Integer.parseInt(parts[2]);

            if (parts[1].equals("start")) {
                Pair p = new Pair();
                p.id = id;
                p.startTime = time;
                p.childTime = 0;
                stack.push(p);
            } else {
                Pair p = stack.pop();
                int interval = time - p.startTime + 1;
                int total = interval - p.childTime;
                result[p.id] += total;
                if (stack.size() > 0) {
                    stack.peek().childTime += interval;
                }
            }
        }
        return result;

    }

    public static int[] timeInterval(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        int time = 0;

        for (String log : logs) {
            String[] parts = log.split(":");

            if (parts[1].equals("start")) {
                if (!stack.isEmpty()) {
                    result[stack.peek()] += Integer.parseInt(parts[2]) - time;
                }
                stack.push(Integer.parseInt(parts[0]));
                time = Integer.parseInt(parts[2]);
            } else {
                result[stack.pop()] += Integer.parseInt(parts[2]) - time + 1;
                time = Integer.parseInt(parts[2]) + 1;
            }
        }
        return result;
    }

    public static class Entry {
        int id;
        int time;

        public Entry() {
        }

        public Entry(int id, int time) {
            this.id = id;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "id=" + id +
                    ", time=" + time +
                    '}';
        }
    }

    public static class Pair {
        int id;
        int startTime;
        int childTime;

        public Pair() {
        }

        public Pair(int id, int startTime) {
            this.id = id;
            this.startTime = startTime;
            this.childTime = 0;
        }
    }
}
