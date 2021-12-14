Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Clarification:

Confused why the returned value is an integer but your answer is an array?

Note that the input array is passed in by reference, which means a modification to the input array will be known to the caller as well.

Internally you can think of this:

// nums is passed in by reference. (i.e., without making a copy)
int len = removeDuplicates(nums);

// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
for (int i = 0; i < len; i++) {
    print(nums[i]);
}
 
Example 1:

Input: nums = [1,1,2]
Output: 2, nums = [1,2]
Explanation: Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It desn't matter what you leave beyond the returned length. 

Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4]
Explanation: Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively. It doesn't matter what values are set beyond the returned length.



// Code 
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int slow = 0; // slow pointer 区间[0,slow]中的元素都是排序数组中只出现一次的元素
        for (int fast = 1; fast < nums.length; fast++) {  
            // fast pointer 快指针fast的初始值为1，因为数组是排好序的因此数组中的第一个元素是一定存在于返回数组中的。
            if (nums[fast] != nums[slow]) {      // 当前考察的元素nums[fast]和nums[slow]不相等时说明nums[fast]是需要放入区间[0,slow]中的
                // slow++是因为区间[0,slow]是左闭右闭的
                // 因此，在slow加1之后，在将nums[fast]的值赋予nums[slow]
                slow++;
                nums[slow] = nums[fast];  // j指向的是新数组中末尾的元素，即新数组最后的索引    
            }
        }
        return slow+1;  // 而索引从0开始，题目要求返回新数组的长度，因此返回slow+1

        // 1-2
        if (nums.length == 0) return 0;
        int j = 0;
        // i is the fast pointer, j is the slow pointer to record which position to put at. 
        for (int i = 1; i < nums.length; i++){
            if (nums[i] != nums[j]) nums[++j] = nums[i];
        }
        return j+1;

        // 1-3
        int count = 0; // 用來記錄有多少duplicates
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1]==nums[i]) {
                count++;
            }else {
                nums[i-count] = nums[i];  // 扣掉前面有幾個duplicated 過的 移到正確位置上
            }
        }
        return nums.length-count;  // 扣掉總共的duplicate數量
    }
}