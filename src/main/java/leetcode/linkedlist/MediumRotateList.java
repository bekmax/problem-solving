package leetcode.linkedlist;

/**
 * N61. Rotate List
 * Given the head of a linked list, rotate the list to the right by k places.
 */
public class MediumRotateList {
    public static void main(String[] args) {

    }

    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (k == 0 || head == null || head.next == null) {
                return head;
            }

            int size = 1;
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
                size++;
            }
            current.next = head;
            int rotations = k % size;
            int skip = size - rotations;
            ListNode newHead = head;
            for (int i = 0; i < skip - 1; i++) {
                newHead = newHead.next;
            }
            head = newHead.next;
            newHead.next = null;
            return head;
        }

        public class ListNode {
            int val;
            ListNode next;

            ListNode() {
            }

            ListNode(int val) {
                this.val = val;
            }

            ListNode(int val, ListNode next) {
                this.val = val;
                this.next = next;
            }
        }
    }
}
