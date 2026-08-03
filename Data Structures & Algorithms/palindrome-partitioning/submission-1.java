class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtracking(0, s,result, new ArrayList<>());

        return result;
        
    }
    public void backtracking(int index, String s, List<List<String>> result, List<String> cur){
        if(index==s.length()){
            result.add(new ArrayList<>(cur));
            return;
        }
        for(int i =index; i<s.length(); i++){
            if(ispalindrome(s,index, i)){
                cur.add(s.substring(index, i+1));
                backtracking(i+1, s, result,cur);
                cur.remove(cur.size()-1);
            }
        }
    }

    public boolean ispalindrome(String s, int start, int end){
        while(start<= end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}
