class Solution {
    public int maxProfit(int[] prices) {
        int minP=prices[0],maxp=0;
        for(int price:prices){
            minP=Math.min(minP, price);
            maxp=Math.max(maxp, price-minP);
        }
        return maxp;
    }
}