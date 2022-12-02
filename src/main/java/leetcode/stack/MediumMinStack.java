package leetcode.stack;

/**
 * N155 Min Stack
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * Implement the MinStack class:
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * You must implement a solution with O(1) time complexity for each function.
 */
public class MediumMinStack {
    public static void main(String[] args) {
        MinStack ms = new MinStack();

        ms.push(4);
        ms.push(6);
        ms.push(2);
        ms.push(7);
        ms.pop();
        ms.pop();

        System.out.println(ms.getMin());
    }

    public static class MinStack {
        private static class Node {
            private int data;
            private int min;
            private Node next;

            public Node(int data) {
                this.data = data;
            }

        }

        Node head;

        public MinStack() {

        }

        public void push(int val) {
            Node node = new Node(val);
            if (head == null) {
                node.min = val;
            } else {
                node.min = Math.min(head.min, val);
            }
            node.next = head;
            head = node;
        }

        public void pop() {
            if (head == null) return;
            head = head.next;
        }

        public int top() {
            if (head == null) return 0;
            return head.data;
        }

        public int getMin() {
            if (head == null) return 0;
            return head.min;
        }
    }
}
