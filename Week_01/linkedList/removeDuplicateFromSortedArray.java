
// ----------------- Code -------------------

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // 1. Hash table  // O(N) and O(N) space complexity in worst case.
        if (head == null || head.next == null) return head;
        HashSet<Integer> hash = new HashSet<Integer>();
        ListNode preHead = new ListNode(-1,head);
        ListNode cur = preHead;
        while (cur.next != null) {
            if (hash.contains(cur.next.val)) {
                cur.next = cur.next.next;
            } else {
                hash.add(cur.next.val);
                cur = cur.next;
            }
        }
        return head;

        // 2. Two pointers (USE THIS!)
        // if (head == null || head.next == null) return head;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val)
                cur.next = cur.next.next;
            else 
                cur = cur.next;
        }
        return head;
    }
}