### 219. Contains Duplicate II ### 

Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

 

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false
 

Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109
0 <= k <= 105



class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // 1. Brute Force. O(N^2), overtime...
        // for (int i = 0; i < nums.length -1; i++) {
        //     for (int j = i + 1; j < nums.length; j++) {
        //         if (nums[i] == nums[j] && j-i <= k){
        //             return true;
        //         }
        //     }
        // }
        // return false;

        // 2-1. HashSet O(N) O(N)
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if(set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;

        // 2-2. HashSet 
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;



        // 3. HashMap O(N), O(N)
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(nums[i]);
            if (index != null && (i - index <= k)) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;

     	// 3-1: Hashmap 
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k ) return true;
            map.put(nums[i], i );
        }
        return false; 
    }
}