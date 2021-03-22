输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

示例 1：

输入：head = [1,3,2]
输出：[2,3,1]


// Code 
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public int[] reversePrint(ListNode head) {
        ListNode prev = null, curr = head;
        int count = 0;
        while(curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
            count++;
        }
        int[] arr = new int [count];
        int i = 0;
        while (prev!=null) {
            arr[i++] = prev.val;
            prev = prev.next;
        }
        return arr;


        // Option 2
        // //先获取链表长度，创建对应长度数组
        // ListNode currNode = head;
        // int len = 0;
        // while(currNode != null){
        //     len ++;
        //     currNode = currNode.next;
        // }
        // int[] result = new int[len];
        
        // //再次遍历链表，将值倒序填充至结果数组
        // currNode = head;
        // while(currNode != null){
        //     result[len - 1] = currNode.val;
        //     len --;
        //     currNode = currNode.next;
        // }
        // return result;
    }
}