import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(n<=2)return ans;
        find(1,k,n,new ArrayList<>());
        return ans;
    }

    private void find(int idx,int k,int n,ArrayList<Integer> curr){
        if(curr.size()==k){
            if(isValid(curr,n))ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i=idx;i<=9;i++){
            curr.add(i);
            find(i+1, k, n, curr);
            curr.remove(curr.size()-1);
        }
    }

    private boolean isValid(ArrayList<Integer> curr,int n){
        int sum=0;
        for(int i=0;i<curr.size();i++)sum+=curr.get(i);
        return sum==n;
    }
}