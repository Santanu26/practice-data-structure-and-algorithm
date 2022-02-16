package hastable;

public class LRUCacheMain {
    public static void main(String[] args) {
        /*LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
       // System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));*/

        System.out.println("____________________");

       /* LRUCache2 lruCache2 = new LRUCache2(2);
        lruCache2.put(1, 1);
        lruCache2.put(2, 2);
        // System.out.println(lruCache.get(1));
        lruCache2.put(3, 3);
        System.out.println(lruCache2.get(2));
        lruCache2.put(4, 4);
        System.out.println(lruCache2.get(1));
        System.out.println(lruCache2.get(3));
        System.out.println(lruCache2.get(4));*/


        LRUCache3 lruCache3 = new LRUCache3(2);
        lruCache3.put(1, 1);
        lruCache3.put(2, 2);
        // System.out.println(lruCache.get(1));
        lruCache3.put(3, 3);
        System.out.println(lruCache3.get(2));
        lruCache3.put(4, 4);
        System.out.println(lruCache3.get(1));
        System.out.println(lruCache3.get(3));
        System.out.println(lruCache3.get(4));
    }
}
