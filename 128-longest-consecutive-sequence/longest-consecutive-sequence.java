class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length<=1)return nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int x:nums)pq.add(x);
        int count=1,last=pq.poll(),max=count;
        while (!pq.isEmpty()){
            int curr =pq.poll();
            if(last==curr)continue;
            if(curr==last+1)count++;
            else {
                count=1;
            }
            last=curr;
            max=Math.max(max, count);
        }
        return max;
    }
}