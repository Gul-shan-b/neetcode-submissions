class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1,n,k,result, new ArrayList<>());

        return result;

        
    }
    private void backtrack(int index,int n, int k, List<List<Integer>> result, List<Integer> cur){
       if(cur.size()==k){
        result.add(new ArrayList<>(cur));
        return;
       }

       for(int i=index; i<=n; i++){
        cur.add(i);
        backtrack(i+1,n,k,result,cur);
        cur.remove(cur.size()-1);

       }

    }
}