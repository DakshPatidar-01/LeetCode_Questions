class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Boolean> map =new HashMap<>();
        for(int x:nums)map.put(x, false);
        int maxLength=0;
        for(int x:nums){
            map.put(x, true);
            int currLength=1;
            int nextNum = x+1;
            while(map.containsKey(nextNum)&&map.get(nextNum)==false){
                currLength++;
                map.put(nextNum, true);
                nextNum++;
            }
            int preNum=x-1;
            while(map.containsKey(preNum)&&map.get(preNum)==false){
                currLength++;
                map.put(preNum, true);
                preNum--;
            }
            maxLength=Math.max(maxLength, currLength);
        }
        return maxLength;
    }
}