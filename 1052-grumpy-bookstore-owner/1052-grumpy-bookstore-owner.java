class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
         int notgrumpy = 0;
         for(int i=0; i<customers.length; i++){
            if(grumpy[i]==0){
                notgrumpy+=customers[i];
            }
         }
         int max = 0;
         for(int i=0; i<minutes; i++){
            if(grumpy[i]==1){
                max+=customers[i];
            }
         }

         int maxUnsatisfied = max;

         for(int i=minutes; i<customers.length; i++){
            if(grumpy[i-minutes]==1){
                max-=customers[i-minutes];
            }

            if(grumpy[i]==1){
                max+=customers[i];
            }
            maxUnsatisfied = Math.max(maxUnsatisfied, max);
         }
         return notgrumpy + maxUnsatisfied;
    }
}