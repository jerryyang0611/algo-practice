// Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

// Example:
// Input: [0,1,0,3,12]
// Output: [1,3,12,0,0]
// Note:
// You must do this in-place without making a copy of the array.
// Minimize the total number of operations.


class Solution {
    public void moveZeroes(int[] nums) {
       
        if (nums == null || nums.length == 0){
            return ;
        }

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {  
                if (i > j) {  // #1
                    nums[j] = nums[i];
                    nums[i] = 0; 
                }
                j++;
            }
        }

// 其实优化的地方就是#1处。它避免了数组开头是非零元素的交换也就是阻止（i==j）时交换。
// 当i > j 时，只需要把 i 的值赋值给j 并把原位置的值置0。同时这里也把交换操作换成了赋值操作，减少了一条操作语句，理论上能更节省时间。

    }
}
