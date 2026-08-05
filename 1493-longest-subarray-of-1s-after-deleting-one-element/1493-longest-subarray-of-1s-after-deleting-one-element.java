class Solution {
    public int longestSubarray(int[] nums) {
        int max =0;
        for(int i=0; i<nums.length; i++){
            int count=0;
            for(int j=i; j<nums.length; j++){
            if(nums[j]==0){
                count++;
            }
            if(count>1){
                break;
            }
             max= Math.max(max, j-i);
            }
        }
        return max;
    }
}