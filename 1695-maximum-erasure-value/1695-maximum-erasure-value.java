class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum =0;
        int left =0;
        int max =0;
        for(int right=0; right<nums.length; right++){
            int current = nums[right];
            while(map.containsKey(current)){
                int leftValue = nums[left];
                sum-=leftValue;
                map.remove(leftValue);
                left++;
            }
            map.put(current, 1);
            sum+=current;
            max = Math.max(max, sum);
        }
        return max;
    }
}