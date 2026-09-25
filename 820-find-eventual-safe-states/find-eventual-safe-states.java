class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        List<List<Integer>> rev=new ArrayList<>();
        int[] out=new int[n];
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++) rev.add(new ArrayList<>());
        for(int i=0;i<n;i++){
            out[i]=graph[i].length;
            for(int next:graph[i])rev.get(next).add(i);
        }
        for(int i=0;i<n;i++)if(out[i]==0) q.add(i);
        boolean[] safe=new boolean[n];
        while(!q.isEmpty()){
            int node=q.poll();
            safe[node]=true;
            for(int prev:rev.get(node)){
                if(--out[prev]==0)q.add(prev);
            }
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++)
            if(safe[i]) ans.add(i);
        return ans;
    }
}