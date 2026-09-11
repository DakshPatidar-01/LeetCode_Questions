class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(n<=2)return ans;
        find(1,k,n,new ArrayList<>(),n);
        return ans;
    }

    private void find(int idx,int k,int n,ArrayList<Integer> curr,int remaining){
        if(curr.size()==k && remaining==0){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i=idx;i<=9;i++){
            curr.add(i);
            remaining-=i;
            find(i+1, k, n, curr,remaining);
            curr.remove(curr.size()-1);
            remaining+=i;
        }
    }
}