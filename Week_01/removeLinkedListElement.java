Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.

Input: head = [1,2,6,3,4,5,6], val = 6
Output: [1,2,3,4,5]

Input: head = [], val = 1
Output: []

Input: head = [7,7,7,7], val = 7
Output: []

Constraints:

The number of nodes in the list is in the range [0, 104].
1 <= Node.val <= 50
0 <= k <= 50

// ------------- Code Below ----------------

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
    public ListNode removeElements(ListNode head, int val) {

        // 1. Iteration  O(N), O(1)
        if (head == null) return head;
        ListNode pre = new ListNode(-1,head);
        ListNode cur = pre;
        while (cur.next != null) {
            // check the value 
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;   
            }
        }
        return pre.next;

        // 2. Recursion.
        // 2.1 : Succinct Style
        // base case and edge case.
        if (head == null) return head;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;  // either return the already removedList or itself.
        
        // 2.2 : Clear Style
        if (head == null) return head; // 考虑问题规模最小的情况（递归退出条件）
        ListNode res = removeElements3(head.next, val);  // 减小问题规模，获得处理后的链表（不一定与 head 连在一起）
        // 判断 head 节点是否需要删除
        if (head.val == val) {
            return res;
        } else {
            head.next = res;
            return head;
        }
    }
}