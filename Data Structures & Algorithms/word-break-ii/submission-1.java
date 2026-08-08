class Solution{
    HashSet<String> set = new HashSet<>();
    public List<String> wordBreak(String s, List<String> wordDict){
        set.addAll(wordDict);
        return solve(s);
    }
    public  List<String> solve(String s){
        if(s.isEmpty()){
            return Arrays.asList("");
        }
        List<String> result = new ArrayList<>();

        for(int i=1; i<=s.length();i++){
            String currword = s.substring(0,i);
            if(set.contains(currword)){
                String remainword = s.substring(i);
                List<String> remainres = solve(remainword);

                for(String word: remainres){
                    String sentence = currword + (word.isEmpty() ? "" : " ") + word;

                    result.add(sentence);
                }
            }
        }
        return result;
    }
}