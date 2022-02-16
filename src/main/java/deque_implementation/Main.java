package deque_implementation;

import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();

        deque.add("Element 0");
        deque.add("Element 1");
        deque.add("Element 2");
        deque.add("Element 3");
        System.out.println("Existing deque: " + deque);
        getFirstDequeCall(deque);
        getLastDequeCall(deque);
        removeFirstElement(deque);
        removeLastElement(deque);
        addNewElementFromBeginning(deque);
        removeElementFromBeginning(deque);
    }

    private static void getFirstDequeCall(Deque<String> deque) {
        System.out.println("Get getFirst call: " + deque.getFirst());
    }

    private static void getLastDequeCall(Deque<String> deque) {
        System.out.println("Get getLast call: " + deque.getLast());
    }

    private static void removeElementFromBeginning(Deque<String> deque) {
        deque.poll();
        deque.poll();
        deque.poll();
        deque.poll();
        System.out.println("After Pop call: " + deque);
    }

    private static void addNewElementFromBeginning(Deque<String> deque) {
        deque.push("Element 4");
        System.out.println("After push call: " + deque);
    }

    private static void removeLastElement(Deque<String> deque) {
        deque.pollLast();
        // deque.removeLast();
        System.out.println("After removing Last element: " + deque);
    }

    private static void removeFirstElement(Deque<String> deque) {
        deque.pollFirst();
        System.out.println("After removing first element: " + deque);
    }
}
