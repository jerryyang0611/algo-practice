Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.
The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.
You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Example 3:

Input: digits = [0]
Output: [1]
 

Constraints:

1 <= digits.length <= 100
0 <= digits[i] <= 9


// Code 

class Solution {
    public int[] plusOne(int[] digits) {
        // Option 1.
        // for (int i = digits.length-1; i >= 0; i--) {
        //     if (digits[i]!= 9) {
        //         digits[i]++;
        //         break;
        //     } else {        // digit is 9 (e.g. 9, 19, 99)
        //         digits[i] = 0;
        //         if (i==0) digits = new int[digits.length+1];
        //         digits[0] = 1;       
        //     }
        // }
        // return digits;

        // Option 2.
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;   // 看看是不是9
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1]; // 能到這說明整個digits全是9 所以要進位 直接重新new一個 並把第一位改成1
        digits[0] = 1;
        return digits;
    }
}