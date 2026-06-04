class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1) return 0;
        int ws=0,pro=1,c=0;
        for(int we=0;we<nums.length;we++){
            pro*=nums[we];
            while(pro>=k){
                pro=pro/nums[ws];
                   ws++;
            }
            c+=(we-ws+1);
        }
        return c;
    }
}