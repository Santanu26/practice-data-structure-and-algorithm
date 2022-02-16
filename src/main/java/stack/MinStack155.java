package stack;

class MinStack155 {

    private Node head;

    private class Node {
        int min;
        int val;
        Node next;

        Node (int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    public MinStack155() {
    }

    public void push(int val) {
        if (this.head == null) {
            this.head = new Node(val, val, null);
        } else {
            this.head = new Node(val, Math.min(val, head.min), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return this.head.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
