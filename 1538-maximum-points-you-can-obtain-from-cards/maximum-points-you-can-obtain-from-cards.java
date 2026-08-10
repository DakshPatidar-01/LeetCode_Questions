class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int totalSum=0;
        int windowSize=cardPoints.length-k;
        for(int x:cardPoints)totalSum+=x;
        if(windowSize==0)return totalSum;
        int windowSum=0;
        for(int i=0;i<windowSize;i++){
            windowSum+=cardPoints[i];
        }

        int miniSum=windowSum;
        for(int i=windowSize;i<cardPoints.length;i++){
            windowSum= windowSum+cardPoints[i]-cardPoints[i-windowSize];
            miniSum=Math.min(windowSum, miniSum);
        }

        return totalSum-miniSum;
    }
    
}