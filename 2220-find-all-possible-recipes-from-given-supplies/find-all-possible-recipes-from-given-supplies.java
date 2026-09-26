class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String,List<String>> graph = new HashMap<>();
        Map<String,Integer> indegree = new HashMap<>();
        for(int i=0;i<recipes.length;i++){
            indegree.put(recipes[i],ingredients.get(i).size());
            for(String ing : ingredients.get(i)){
                graph.computeIfAbsent(ing,k->new ArrayList<>()).add(recipes[i]);
            }
        }
        List<String> ans = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        for(String supply:supplies){
            q.add(supply);
            while (!q.isEmpty()) {
                String item = q.poll();
                for(String recipe : graph.getOrDefault(item,new ArrayList<>())){
                    indegree.put(recipe,indegree.get(recipe)-1);
                    if(indegree.get(recipe)==0){
                        ans.add(recipe);
                        q.add(recipe);
                    }
                }
            }
        }
        return ans;
    }
}