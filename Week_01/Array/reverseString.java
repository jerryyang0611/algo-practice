Write a function that reverses a string. The input string is given as an array of characters s.

Example 1:

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: s = ["H",n"a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
 
Constraints:

1 <= s.length <= 105
s[i] is a printable ascii character.
 
Follow up: Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

// Code (Two pointer)
class Solution {
    public void reverseString(char[] s) {
	    int n = s.length;
	    for(int left = 0, right = n - 1; left < right; left++,right--){
	        char temp = s[left];
	        s[left] = s[right];
	        s[right] = temp;
		}
    }
}
