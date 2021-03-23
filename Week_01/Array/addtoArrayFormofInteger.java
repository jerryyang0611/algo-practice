For a non-negative integer X, the array-form of X is an array of its digits in left to right order.  For example, if X = 1231, then the array form is [1,2,3,1].

Given the array-form A of a non-negative integer X, return the array-form of the integer X+K.

 

Example 1:

Input: A = [1,2,0,0], K = 34
Output: [1,2,3,4]
Explanation: 1200 + 34 = 1234
Example 2:

Input: A = [2,7,4], K = 181
Output: [4,5,5]
Explanation: 274 + 181 = 455
Example 3:

Input: A = [2,1,5], K = 806
Output: [1,0,2,1]
Explanation: 215 + 806 = 1021
Example 4:

Input: A = [9,9,9,9,9,9,9,9,9,9], K = 1
Output: [1,0,0,0,0,0,0,0,0,0,0]
Explanation: 9999999999 + 1 = 10000000000
 
Note：

1 <= A.length <= 10000
0 <= A[i] <= 9
0 <= K <= 10000
If A.length > 1, then A[0] != 0

// ------------- Code ---------------

class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        // Use LinkedList (becuz we may regularly insert, remove items in the list)
        // 模擬手動加法
        LinkedList<Integer> result = new LinkedList<>();
        int carry = 0; // 進位值
        
        // iterate from right to left 
        for (int i = A.length-1; i >=0 ; i--) {
            int remainder = K % 10;
            int total = remainder + A[i] + carry;
            carry = total / 10;
            K /= 10;    // K 代表著每一輪當前要加的 K 的（個十百..) 等的值 -> e.g. 999 => 9 > 9 > 9
            result.addFirst(total % 10);
        }
        K = K + carry;
        // 有可能 num 還有一位沒加 (e.g. 99 + 1 => 100 ) or K 長度 >> A (e.g. 0 + 233 => 233, 19 + 999)  
        while (K != 0) {
            result.addFirst(K % 10);
            K = K / 10;
        }
        return result;
    }
}
