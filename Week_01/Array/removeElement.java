Given an array nums and a value val, remove all instances of that value in-place and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

The order of elements can be changed. It doesnt matter what you leave beyond the new length.

Clarification:

Confused why the returned value is an integer but your answer is an array?

Note that the input array is passed in by reference, which means a modification to the input array will be known to the caller as well.

Internally you can think of this:

// nums is passed in by reference. (i.e., without making a copy)
int len = removeElement(nums, val);

// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
for (int i = 0; i < len; i++) {
    print(nums[i]);
}
 

Example 1:

Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2]
Explanation: Your function should return length = 2, with the first two elements of nums being 2. It doesn't matter what you leave beyond the returned length. For example if you return 2 with nums = [2,2,3,3] or nums = [2,2,0,0], your answer will be accepted.

Example 2:
Input: nums = [0,1,2,2,3,0,4,2], val = 2
Output: 5, nums = [0,1,4,0,3]
Explanation: Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4. Note that the order of those five elements can be arbitrary. It doesn't matter what values are set beyond the returned length.
 

Constraints:

0 <= nums.length <= 100
0 <= nums[i] <= 50
0 <= val <= 100


// ----------- Code ------------------


class Solution {
    public int removeElement(int[] nums, int val) {

        // 1.  O(N), O(1)
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) 
                count++;    // 算前面有多少個要刪得元素
            else 
                nums[i-count] = nums[i];   // nums[i-count] 相當於把要的元素移到正確位置. 減去前面已刪除元素個數 往前移
        }
        return nums.length - count;

        // Solution 2-1:  O(N), O(1) --- Two Pointers
        int ans = 0;
        for(int num: nums) {
            if(num != val) {
                nums[ans] = num;
                ans++;
            }
        }
        return ans;

        int index = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }   
        return index;

        // Solution 2-2:  O(N), O(1) --- Two Pointers
        int count = 0;  // 紀錄有多少要留下來(也當index)
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {    // 只 care 要留下來的element
                nums[count++] = nums[i];
            }
        }
        return count;


        // int slowIndex = 0;
        // for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
        //     if (val != nums[fastIndex]) {
        //         nums[slowIndex++] = nums[fastIndex];
        //     }
        // }
        // return slowIndex;
    }
     
}