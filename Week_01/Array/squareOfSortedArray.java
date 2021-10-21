Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

 

Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.




class Solution {
    public int[] sortedSquares(int[] nums) {

    	// Brute Force Time: O(NlogN) Space: O(logN)
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            ans[i] = nums[i] * nums[i];
        }
        Arrays.sort(ans);
        return ans;

        for (int i = 0; i < nums.length; i++){
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;

    	// Two Pointers
		// 时间复杂度：O(n)，其中 nn 是数组 nums 的长度
		// 空间复杂度：O(1)。除了存储答案的数组以外，我们只需要维护常量空间

        int[] arr = new int[nums.length];
        int k = nums.length-1;
        for (int i = 0, j = nums.length-1; i<=j;) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                arr[k--] = nums[i] * nums[i];
                i++;
            }else {
                arr[k--] = nums[j] * nums[j];
                j--;
            }
        }
        return arr;
    }
}


