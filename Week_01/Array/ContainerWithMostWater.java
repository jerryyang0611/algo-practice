class Solution {
    public int maxArea(int[] height) {
        
        // 1.  enumerate every left bar, right bar, (right-left)* min_height  ==> overtime (超時)... O(N^2)
        // for (int i = 0; i < height.length -1; i++) {
        //     for (int j = i+1; j< height.length; j++) {
        //         int area = (j-i) * Math.min(height[i],height[j]);
        //         max = Math.max(max,area);
        //     }
        // }

        // 2.  O(N), left & right boundary i, j , converge towards center, 左右夾逼
        int max = 0;
        for (int i = 0, j = height.length - 1; i < j;) {
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            int area = (j-i+1) * minHeight;
            max = Math.max(max,area);
        }
        return max;

        // 2-2. 
        int max = 0, minHeight = 0;
        for (int i = 0, j = height.length - 1; i < j;) {
            max = height[i] < height[j] ? 
                Math.max(max, (j - i) * height[i++]): 
                Math.max(max, (j - i) * height[j--]); 
        }
        return max;

        // 2-3. 
        int i = 0, j = height.length - 1, max = 0;
        while(i < j) {
            max = Math.max((j-i) * (Math.min(height[i],height[j])), max);
            if (height[i]<height[j]) i++;
            else j--;
        }
        return max;
    }
}
