class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int pro = 1;
        int maxPro = nums[0];

        for(int i=0;i<n;i++){
            pro*=nums[i];
            if(pro>maxPro){
                maxPro=pro;
            }
            if(pro==0){
                pro=1;
            }
        }

        pro=1;
        for(int i=n-1;i>=0;i--){
            pro*=nums[i];
            if(pro>maxPro){
                maxPro=pro;
            }
            if(pro==0){
                pro=1;
            }
        }
        return maxPro;
    }
}