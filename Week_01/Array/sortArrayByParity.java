905. Sort Array By Parity
Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.

Return any array that satisfies this condition.

Example 1:

Input: nums = [3,1,2,4]
Output: [2,4,3,1]
Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
Example 2:

Input: nums = [0]
Output: [0]
 

Constraints:

1 <= nums.length <= 5000
0 <= nums[i] <= 5000


class Solution {
    public int[] sortArrayByParity(int[] nums) {
        // 四種情況: odd odd, even even, odd even, even odd
        if (nums.length == 1) return nums;
        for (int i = 0, j = nums.length-1; i < j;){
            if (nums[i] % 2 == 1 && nums[j] % 2 == 1) j--;
            if (nums[i] % 2 == 0 && nums[j] % 2 == 0) i++; 
            if (nums[i] % 2 > nums[j] % 2) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            } 
            if (nums[i] % 2 < nums[j] % 2) {
                i++;
                j--;
            }
        }
        return nums;

        // Solution 2: New an array Extra Space
        // Iterate through the nums array. If it's even put it in front via i pointer, otherwise put in the back via j pointer
        int[] res = new int[nums.length];
        for (int i = 0, j = nums.length-1, k = 0; i < nums.length;i++){
            if (nums[i] % 2 == 0){
                res[k++] = nums[i];
            } else {
                res[j--] = nums[i];
            }
        }
        return res;
        
        // 簡化 for 寫法 
        // Solution 2-2:

        int[] res = new int[nums.length];
        int i = 0, j = nums.length -1;
        for (int num: nums){
            if (num % 2 == 0){
                res[i++] = num;
            } else {
                res[j--] = num;
            }
        }
        return res;

        // Solution3: Two Pointers: 把正確的移要的位置上, only cares about even number
        int j = 0;
        for (int i = 0; i < nums.length; ++ i) {
            if (nums[i] % 2 == 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
        return nums;
    }
}   