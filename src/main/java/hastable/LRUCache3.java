package hastable;

import java.util.LinkedHashMap;

public class LRUCache3 {

    LinkedHashMap<Integer, Integer> cache;
    int capacity;

    LRUCache3(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<>();
    }

    int get(int key) {
        if (cache.containsKey(key)) {
            int value = cache.get(key);
            cache.remove(key);
            cache.put(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.remove(key);
            cache.put(key, value);
        } else {
            cache.put(key, value);
            int size = cache.size();

            if (size > capacity) {
                int oldest = cache.keySet().iterator().next();
                cache.remove(oldest);
            }
        }
    }
}
