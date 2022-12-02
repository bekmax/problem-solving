package leetcode.linkedlist;

import java.util.List;

/**
 * N21 Merge Two Sorted Lists
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists in a one sorted list.
 * The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 */
public class EasyMergeTwoSortedLists {
    public static void main(String[] args) {

    }

    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode head = null;
            ListNode current = null;

            while (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    if (head == null) {
                        head = new ListNode(list1.val);
                        current = head;
                    } else {
                        current.next = new ListNode(list1.val);
                        current = current.next;
                    }
                    list1 = list1.next;
                } else {
                    if (head == null) {
                        head = new ListNode(list2.val);
                        current = head;
                    } else {
                        current.next = new ListNode(list2.val);
                        current = current.next;
                    }
                    list2 = list2.next;
                }
            }

            while (list1 != null) {
                if (head == null) {
                    head = new ListNode(list1.val);
                    current = head;
                } else {
                    current.next = new ListNode(list1.val);
                    current = current.next;
                }
                list1 = list1.next;
            }

            while (list2 != null) {
                if (head == null) {
                    head = new ListNode(list2.val);
                    current = head;
                } else {
                    current.next = new ListNode(list2.val);
                    current = current.next;
                }
                list2 = list2.next;
            }

            return head;
        }
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
