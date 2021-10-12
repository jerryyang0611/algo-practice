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
根据题意加一，没错就是加一这很重要，因为它是只加一的所以有可能的情况就只有两种：

1. 除 9 之外的数字加一；
2. 数字 9。
加一得十进一位个位数为 00 加法运算如不出现进位就运算结束了且进位只会是一。

所以只需要判断有没有进位并模拟出它的进位方式，如十位数加 11 个位数置为 00，如此循环直到判断没有再进位就退出循环返回结果。
然后还有一些特殊情况就是当出现 9999、999999 之类的数字时，循环到最后也需要进位，出现这种情况时需要手动将它进一位。



class Solution {
    public int[] plusOne(int[] digits) {
        // Solution 1.
        int n = digits.length;
        for (int i = n-1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            } 
            
            digits[i] = 0;        // digit is 9 (e.g. 9, 19, 99)
        }
        // if the code execute here -> it means all numbers are 9 (9,99,999,999)
        digits = new int[n+1];
        digits[0] = 1;
        return digits;


        // Solution 2.
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