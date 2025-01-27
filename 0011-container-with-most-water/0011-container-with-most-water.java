class Solution {
    public int maxArea(int[] height) {
        int maxArea =0;
        int low = 0;
        int right = height.length-1;

        while(low<right){
            if(height[low]<height[right]){
                maxArea = Math.max(maxArea,(right-low)*height[low]);
                low++;
            }else{
                maxArea = Math.max(maxArea,(right-low)*height[right]);
                right--;
            }
        }
        return maxArea;
    }
}