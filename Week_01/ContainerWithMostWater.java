class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        
        // 1.  enumerate every left bar, right bar, (right-left)* min_height
        for (int i = 0; i < height.length -1; i++) {
            for (int j = i+1; j< height.length; j++) {
                int area = (j-i) * Math.min(height[i],height[j]);
                max = Math.max(max,area);
            }
        }

        // // 2.  O(N), left & right boundary, converge towards center, 左右夾逼
        // for (int i = 0, j = height.length - 1; i < j;) {
        //     // System.out.println("height[i]:" + height[i]);
        //     int minHeight = height[i] < height[j] ? height[i++] : height[j--];
        //     // System.out.println("minHeight: "+ minHeight);
        //     int area = (j-i+1) * minHeight;
        //     max = Math.max(max,area);
        // }
        return max;
    }
}
