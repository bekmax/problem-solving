package leetcode.linkedlist;

import java.util.List;

/**
 * N19. Remove Nth Node From End of List
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */
public class MediumRemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode newHead = solution.removeNthFromEnd(head, 1);

        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }

    }

    static class Solution {
        int num;

        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head == null) {
                return head;
            }
            ListNode beforeHead = new ListNode(0);
            beforeHead.next = head;
            ListNode first = beforeHead;
            ListNode second = beforeHead;

            while (n > 0 && second != null) {
                second = second.next;
                n--;
            }

            while (second.next != null) {
                second = second.next;
                first = first.next;
            }

            first.next = first.next.next;
            return beforeHead.next;
        }
    }

    public static class ListNode {
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
