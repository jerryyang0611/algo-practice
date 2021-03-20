Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.

Input: l1 = [1,2,4], l2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: l1 = [], l2 = []
Output: []
Example 3:

Input: l1 = [], l2 = [0]
Output: [0]

Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both l1 and l2 are sorted in non-decreasing order.



// Code 
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Option 1: Iteration
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = new ListNode(0);  // initialise one prev head
        ListNode curr = head;            // copy another node from the prev head for l1 l2 choosing during each iteration.
        while (l1!= null && l2 != null) { 
            if (l1.val > l2.val) {
                curr.next = l2;
                l2 = l2.next;
            }
            else {
                curr.next = l1;
                l1 = l1.next;
            }
            curr = curr.next;
        }
        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        curr.next = (l1 == null) ? l2 : l1;    // either of listnode is null
        return head.next;

        // Option 2: Recursion...
        // if(l1 == null || l2 == null)
        //    return l1 == null ? l2 : l1;

        // if (l1.val <= l2.val) {
        //     l1.next = mergeTwoLists(l1.next, l2);
        //     return l1;
        // } else {
        //     l2.next = mergeTwoLists(l1, l2.next);
        //     return l2;
        // }
    }
}