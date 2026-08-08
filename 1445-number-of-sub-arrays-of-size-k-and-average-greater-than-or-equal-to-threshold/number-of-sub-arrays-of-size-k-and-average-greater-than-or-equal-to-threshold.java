class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count=0;
        long windSum=0;
        for(int i=0;i<k;i++){
            windSum+=arr[i];
        }
        if(windSum/k>=threshold)count++;
        for(int i=k;i<arr.length;i++){
            windSum=windSum+arr[i]-arr[i-k];
            if(windSum/k>=threshold)count++;
        }
        return count;
    }
}