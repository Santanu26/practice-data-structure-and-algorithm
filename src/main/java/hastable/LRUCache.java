package hastable;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    int capacity;
    Map<Integer, Integer> map;
    Deque<Integer> deque;

    LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        deque = new ArrayDeque<>(capacity);
    }

    public void put(int key, int value) {
        deque.remove(key);
        deque.addFirst(key);
        if (!map.containsKey(key) && map.size() == capacity) {
            map.remove(deque.pollLast());
        }
        map.put(key, value);
    }

    public int get(int key) {
        int result = map.getOrDefault(key, -1);

        if (result != -1) {
            deque.remove(key);
            deque.addFirst(key);
        }
        return result;
    }
}
