Given the head of a singly linked list, reverse the list, and return the reversed list.

Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

Input: head = [1,2]
Output: [2,1]

Input: head = []
Output: []

Constraints:

The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000

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

// Option 1: Iteration
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;   //前指针节点, //当前指针节点
        while (curr != null) {   //每次循环，都将当前节点指向它前面的节点，然后当前节点和前节点后移
            ListNode tmp = curr.next; //临时节点，暂存当前节点的下一节点，用于后移
            curr.next = prev; //将当前节点指向它前面的节点
            prev = curr; //前指针后移
            curr = tmp; //当前指针后移
        }
        return prev;
    }
}


// Option 2: Recursion
// 对于递归算法，最重要的就是明确递归函数的定义。具体来说，我们的reverse函数定义是这样的：
//输入一个节点head，将「以head为起点」的链表反转，并返回反转之后的头结点。

class Solution {
    public ListNode reverseList(ListNode head) {
        // Recursion
        if (head == null || head.next == null) return head; // base case: 意思是如果链表只有一个节点的时候反转也是它自己，直接返回即可。
        ListNode last = reverseList(head.next);  // input: 2->3->4->5, return 2<-3<-4<-5
        head.next.next = head; // 1, 2<-3<-4<-5  => 1 <- 2<-3<-4<-5
        head.next = null; // null <- 1
        return last;  // so the whole list: null<-1<-2<-3<-4<-5 , and return the last node which is the head of the reversed list.
    }
}
