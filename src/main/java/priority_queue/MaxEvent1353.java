package priority_queue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MaxEvent1353 {
    public static void main(String[] args) {

        int[][] events = new int[][]{
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 2}
        };

        System.out.println(maxEvent(events));

    }

    public static int maxEvent(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(e-> e[0]));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int event = 0;
        int attended = 0;
        for (int day = 1; event <events.length || !minHeap.isEmpty(); day++) {
            while (!minHeap.isEmpty() && minHeap.peek() < day) {
                minHeap.poll();
            }

            if (event < events.length && minHeap.isEmpty()) { // Optimization: Jump to next event
                day = Math.max(day, events[event][0]);
            }
            // Add todays event
            while( event < events.length  && events[event][0] == day) {
                minHeap.add(events[event][1]);
                event++;
            }
            if (!minHeap.isEmpty()) {
                ++attended;
                minHeap.poll();
            }
        }
        return attended;
    }
}
