class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++)graph.add(new ArrayList<>());
        int indegree[] =new int[n];
        for(int e[]:prerequisites){
            graph.get(e[1]).add(e[0]);
            indegree[e[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0)q.add(i);
        }

        int ans[]= new int[n];
        int idx=0;
        while (!q.isEmpty()) {
            int node = q.poll();
            ans[idx++]=node;
            for(int next:graph.get(node)){
                indegree[next]--;
                if(indegree[next]==0)q.add(next);
            }
        }
        if(idx!=n)return new int[0];
        return ans;
    }
}