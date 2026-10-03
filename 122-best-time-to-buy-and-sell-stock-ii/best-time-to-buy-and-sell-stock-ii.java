class Solution {
    public int maxProfit(int[] prices) {
        int minP=prices[0],sumP=0;
        for(int price:prices){
            minP=Math.min(minP, price);
            if(price-minP>0){
                sumP+=price-minP;
                minP=price;
            }
        }
        return sumP;
    }
}