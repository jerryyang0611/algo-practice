Given the head of a singly linked list, return true if it is a palindrome.

Example 1:
Input: head = [1,2,2,1]
Output: true

Example 2:
Input: head = [1,2]
Output: false
 
Constraints:

The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9

Follow up: Could you do it in O(n) time and O(1) space?


// ------------------ Code ----------------------
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
    public boolean isPalindrome(ListNode head) {
        // 1. Store in an array and reverse the array and compare. O(N), O(N)
        //这里需要用动态数组，因为我们不知道链表的长度
        List<Integer> arr = new ArrayList<Integer>();
        ListNode copynode = head;
        //将链表的值复制到数组中
        while (copynode != null) {
            arr.add(copynode.val);
            copynode = copynode.next;
        }
        // 双指针遍历数组
        int back = 0;
        int pro = arr.size() - 1;
        while (back < pro) {
            //判断两个指针的值是否相等
            if (!arr.get(pro).equals(arr.get(back))) {
                return false;
            }
            //移动指针
            back++;
            pro--;
        }
        return true;

        // 2. Recursion....

        

        // 3. slow, fast pointer. reversed the second half of the linkedlist and compare each node through iteration.
        if (head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 此時slow 就是 middle node....
        // Here we need to assign two head pointers for separated linkedlist
        // 3.1 split the half by the slow pointer and reversed it
        ListNode firstHalfHead = head;
        ListNode secondHalfHead = reverseNode(slow.next);

        while(firstHalfHead != null && secondHalfHead != null) {
            if (firstHalfHead.val != secondHalfHead.val) return false;
            firstHalfHead = firstHalfHead.next;
            secondHalfHead = secondHalfHead.next;
        }
        // 还原链表并返回结果,这一步是需要注意的，我们不可以破坏初始结构，我们只是判断是否为回文，
        //当然如果没有这一步也是可以AC，但是面试的时候题目要求可能会有这一条。
        firstHalfHead.next = reverseNode(secondHalfHead);
        return true;
    }


    public ListNode reverseNode(ListNode head){
        ListNode prev = null;
        while (head != null) {   // if head != null !!!! 記得別寫錯。
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}