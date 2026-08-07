class Solution {
    public int maxArea(int[] height) {
        int left=0,right=height.length-1;
        int max=Integer.MIN_VALUE;
        while(left<right){
            int width = right-left;
            int length = Math.min(height[left], height[right]);
            int area = width*length;
            if(area>max)max=area;
            if(height[left]<=height[right])left++;
            else right--;
        }
        return max;
    }
}
