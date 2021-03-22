Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? 
Find all unique triplets in the array which gives the sum of zero.
Notice that the solution set must not contain duplicate triplets.
 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Example 2:

Input: nums = []
Output: []
Example 3:

Input: nums = [0]
Output: []
 

Constraints:

0 <= nums.length <= 3000
-105 <= nums[i] <= 105

// Answer... 

import java.util.Arrays;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Thoughts: // a + b + c = 0; --> a + b = -c (target) think it as a twoSum question..

        // 1. Brute Force.. three for loop + one Set to remove duplicates...
        

        // 2. two for loop + one HashMap
        // for (int i = 0; i < nums.length-1; i++) {
        //     for (int j = i + 1; j < nums.length; j++) {
                
        //     }
        // }
 

        // 3. 雙指針: sort first, then two pointer / 左右夾逼
        // 簡潔版代碼
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>(); 
        
        for (int t = 0; t < nums.length-2; t++) {    // iterate til length -2 (cuz two pointers.)
            if (nums[t] > 0) break; // break the 
            if (t > 0 && nums[t] == nums[t-1]) continue;  // jump to next iteration (target 算過了)
            int L = t+1, R = nums.length-1;   // starting index for two pointers. L for left, R for right.
            while (L < R) {
                int sum = nums[t] + nums[L] + nums[R];
                if (sum < 0) 
                    while(L < R && nums[L] == nums[++L]);  // 索引移至下一个不同值的位置 - 去重
                else if (sum > 0) 
                    while(L < R && nums[R] == nums[--R]);  // 索引移至下一个不同值的位置 - 去重
                else {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[t], nums[L], nums[R])));
                    while (L < R && nums[L]==nums[++L]);  // 索引移至下一个不同值的位置 - 去重
                    while (L < R && nums[R]==nums[--R]);  // 索引移至下一个不同值的位置 - 去重
                }
             }
        }
        return res;

        // Clearer Code
        // Arrays.sort(nums);
        // List<List<Integer>> res = new ArrayList<>(); 
        // for (int i = 0; i < nums.length-2; i++) {
        //     if (nums[i] > 0) {
        //         break;
        //     }
        //     if (i > 0 && nums[i] == nums[i - 1]) {
        //         continue;
        //     }
        //     int left = i + 1;
        //     int right = nums.length - 1;
        //     while (left < right) {
        //         int threeSum = nums[i] + nums[left] + nums[right];
        //         if (threeSum < 0) {
        //             left++;
        //         } else if (threeSum > 0) {
        //             right--;
        //         } else {
        //             res.add(new ArrayList<Integer>(Arrays.asList(nums[i],nums[left],nums[right])));
        //             while (left < right && nums[left] == nums[left + 1]) {
        //                 left++;
        //             }
        //             while (left < right && nums[right] == nums[right - 1]) {
        //                 right--;
        //             }
        //             right--;
        //             left++;
        //         }
        //     }
        // }
        // return res;
        
    }
}