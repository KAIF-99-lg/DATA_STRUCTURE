class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstPos = firstIndex(nums,target);
        int lastPos = lastIndex(nums,target);
        if(firstPos == Integer.MAX_VALUE && lastPos == Integer.MIN_VALUE) return new int[]{-1,-1};
        return  new int[]{firstPos,lastPos};
    }

    public int firstIndex(int[]nums,int target){
        int left = 0;
        int right = nums.length-1;

        int firstPos = Integer.MAX_VALUE;
        while(left<=right){
            int mid = (left+right)/2;

            if(nums[mid]==target){
                firstPos = Math.min(firstPos,mid);
                right = mid-1;
            }else if(nums[mid]<target){
                left = mid+1;
            }else if(nums[mid]>target){
                right = mid-1;
            }
        }
        return firstPos;
    }

    public int lastIndex(int[]nums,int target){
        int left = 0;
        int right = nums.length-1;

        int lastPos = Integer.MIN_VALUE;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target){
                lastPos = Math.max(lastPos,mid);
                left=mid+1;
            }else if(nums[mid]<target){
                left = mid+1;
            }else if(nums[mid]>target){
                right = mid-1;
            }
        }
        return lastPos;
    }
}