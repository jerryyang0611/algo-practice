Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

The number of elements initialized in nums1 and nums2 are m and n respectively. You may assume that nums1 has a size equal to m + n such that it has enough space to hold additional elements from nums2.

 

Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
 

Constraints:

nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-109 <= nums1[i], nums2[i] <= 109


// Code 	
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 1. Iterate through and swap with minimum value - Bad Time Complexity..O(N^2) ***Don't Use this***
        // merge the nums2 into nums1 first
        // for (int i = m, j = 0; i < nums1.length; i++) {
        //     nums1[i] = nums2[j++];
        // }
        
        // Arrays.sort(nums1);
        // int min = nums1[0];
        // for (int i = 0; i < nums1.length-1; i++) {
        //     for (int j = i + 1; j < nums1.length; j++) {
        //         if (nums1[j] < min) {
        //             int tmp = nums1[j];
        //             nums1[j] = min;
        //             min = tmp;
        //         }
        //     }
        // }

        // 2. Two pointers (from back to iterate) => time: O(m+n) space: O(1)
        // p1: nums1 pointer index, p2: nums2 pointer index, p: placing index
        // 三指针 指针一p1、nums1有效元素尾部；指针二p2、nums2尾部；指针三p、最终数组尾部
        // 1.当，p1>=0时，nums[p1],nums[p2]对比
        // 1.1 nums[p1]大，将nums[p1]放入p3位置。p1--,p3--
        // 1.2 nums[p2]大于等于nums[p1]，将nums[p2]放入p3位置。p2--,p3--
        // 2.当，p1<0时，将nums[p2]放入p3位置。p2--,p3-- (p1<0 => nums1 前m個都比nums2 前n個大時)
        // 循环结束条件：p2<0 (nums2 原本都比nums1大 全部塞完了就退出，因為nums1原本就是sorted array.)
        
        // int p1=m-1,p2=n-1,p3=m+n-1;
        // while(p2 >= 0){
        //     if(p1 >= 0 && nums1[p1] > nums2[p2]){
        //         nums1[p3--] = nums1[p1--];
        //     } else {
        //         nums1[p3--] = nums2[p2--];
        //     }
        // Conditional Operator
        //     nums1[p--] = (p1 >= 0 && nums1[p1] > nums2[p2]) ? nums2[p1--] : nums1[p2--];
        // }

        int p1 = m-1, p2 = n-1, p = m+n-1;  
        while (p2 >= 0) {
            // if (p1 < 0 || nums1[p1] < nums2[p2]) {
            //     nums1[p--] = nums2[p2--];
            // } else {
            //     nums1[p--] = nums1[p1--];
            // }
            // Conditional Operator
            nums1[p--] = (p1 < 0 || nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
        }  

        // Option 2: use for loop 簡潔版 
        // for( int i = m - 1, j = n - 1, k = m + n - 1; j >= 0; k--){
        //     nums1[k] = i < 0 || nums2[j] > nums1[i] ? nums2[j--] : nums1[i--];
        // }
    }
}
