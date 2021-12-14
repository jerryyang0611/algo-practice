Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 

Constraints:

2 <= nums.length <= 103
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.



class Solution {
    public int[] twoSum(int[] nums, int target) {

        // Option 1: for loop iterate through
        int [] index = new int [2];
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    index[0] = i;
                    index[1] = j;
                    return index;
                }
            }
        }

        // Option 1 Plus: simplified version of option 1 (no need to declare another array "index")
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] {i,j}; // directly new & assign one and return 
                }
            }
        }

        // throw new IllegalArgumentException("No such solution..");
        return new int[0];

        // Option 2: HashMap..
        // 1. put the first element and its index 0 into the hash set 
        // 2. iterate through the array element
        // --> if (target - nums[i]) is not in the set, put the nums[i] and its element into the set.

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {     // 直接找互補數
                return new int[] { i, map.get(complement)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");

    }
}