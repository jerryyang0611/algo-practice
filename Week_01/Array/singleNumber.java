Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
Follow up: Could you implement a solution with a linear runtime complexity and without using extra memory?


Example 1:

Input: nums = [2,2,1]
Output: 1
Example 2:

Input: nums = [4,1,2,1,2]
Output: 4
Example 3:

Input: nums = [1]
Output: 1
 
Constraints:
1 <= nums.length <= 3 * 104
-3 * 104 <= nums[i] <= 3 * 104

Each element in the array appears twice except for one element which appears only once.

// ------------ Code -------------------
class Solution {
    public int singleNumber(int[] nums) {
        // 1. Set -- But, doesnt meet space complexity O(1)
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i]))
                set.remove(nums[i]);
        }
        return set.iterator().next();

        // 2. XOR operator O(N), O(1) 
        // 交换律：a ^ b ^ c <=> a ^ c ^ b
        // 任何数于0异或为任何数 0 ^ n => n
        // 相同的数异或为0: n ^ n => 0
        // var a = [2,3,2,4,4]
        // 2 ^ 3 ^ 2 ^ 4 ^ 4 等价于 2 ^ 2 ^ 4 ^ 4 ^ 3 => 0 ^ 0 ^3 => 3
        int result = nums[0];
        for(int i = 1;i < nums.length;i++){
            result ^= nums[i];  // XOR operation
        }
        return result;

    }
}
