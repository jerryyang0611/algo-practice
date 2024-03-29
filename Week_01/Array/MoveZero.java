// Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

// Example:
// Input: [0,1,0,3,12]
// Output: [1,3,12,0,0]
// Note:
// You must do this in-place without making a copy of the array.
// Minimize the total number of operations.

## Constraints:
*  1 <= nums.length <= 104
* -231 <= nums[i] <= 231 - 1


// Option 1: Two Pointer
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
    }
}

// 其实优化的地方就是#1处。它避免了数组开头是非零元素的交换也就是阻止（i==j）时交换。
// 当i > j 时，只需要把 i 的值赋值给j 并把原位置的值置0。同时这里也把交换操作换成了赋值操作，减少了一条操作语句，理论上能更节省时间。
1. j记录要填入的非零元素位置，遇到非0元素就挪动到j位置上；
2. 遍历整个数组，遇到nums[i]==0 时候不处理；如果非0的时候，则把nums[i]的非0元素和nums[j]上的0元素互换，调换位置；
3. j始终指向的是下一个非0元素；



// Option 2 (更簡潔)
class Solution {
    public void moveZeroes(int[] nums) {
        int zeronums = 0;
        int i = 0;
        for(i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                zeronums++;
            } 
            else if(zeronums != 0) {
                nums[i - zeronums] = nums[i];
                nums[i] = 0;
            }
        }
    }
}


// Solution 3: 把全部飛0元素往前挪 然後後面補0                  
class Solution {
    public void moveZeroes(int[] nums) {        

        int start = 0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[start] = nums[i];
                start++;
            }
        }

        // 后面的元素全变成 0
        for (int i = start; i < nums.length; i++) {
            nums[i] = 0;
        }

    }
}
    
