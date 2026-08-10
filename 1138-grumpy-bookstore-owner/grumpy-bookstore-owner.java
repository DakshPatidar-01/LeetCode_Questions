class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int nonGrumptSum=0;
        int n=customers.length;
        for(int i=0;i<n;i++){
            if(grumpy[i]==0)nonGrumptSum+=customers[i];
        }

        int windowSum=0;
        for(int i=0;i<minutes;i++){
            if(grumpy[i]==1)windowSum+=customers[i];
        }

        int maxGrumpySum =windowSum;
        for(int i=minutes;i<n;i++){
            if(grumpy[i] == 1)
                windowSum += customers[i];

            if(grumpy[i-minutes] == 1)
                windowSum -= customers[i-minutes];
            maxGrumpySum=Math.max(maxGrumpySum, windowSum);
        }
        return nonGrumptSum+maxGrumpySum;
    }
}