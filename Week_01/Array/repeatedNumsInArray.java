找出数组中重复的数字。

在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

示例 1：

输入：
[2, 3, 1, 0, 2, 5, 3]
输出：2 或 3 

限制：
2 <= n <= 100000

// ----------- Code -----------

class Solution {
    public int findRepeatNumber(int[] nums) {
        // 0. Brute Force...

        // 1. 排序，时间O(nlogn)，空间O(1)，修改了原数据
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[i+1]) 
                return nums[i];
        }
        return -1;

        // 2. HashSet: O(N), O(N)
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums){
            if(set.contains(num)) 
                return num;
            set.add(num);
        }
        return -1;

        // 方法3：利用辅助数组，与方法2类似，时间O(n)，空间O(n)，不修改原数据
        // 3.1 O(N), O(N)
        int[] arr = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            arr[nums[i]]++;
            if(arr[nums[i]] > 1) return nums[i];
        }
        return -1;
        
        // 3.2 O(N), O(N)
        boolean[] isExist = new boolean[nums.length];
        for(int num : nums){
            if(isExist[num]) return num;
            isExist[num] = true;
        }
        return -1;

        // Optimal Solution: in-place change array:  O(N), O(1)  ==> 此solution 只適用於 array 中值都介於 0 ~ n-1 之間..
        // 考慮到題目有 0, 先全部加一避免*(-1) 失效，最後再-1返回原值
        for (int i = 0; i < nums.length; i++) {
            nums[i]++;
        }

        
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i])-1] < 0) 
                return Math.abs(nums[i])-1;
            nums[Math.abs(nums[i])-1] *= -1;
        }
        return -1;

    }
}