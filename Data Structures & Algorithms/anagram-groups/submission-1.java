class Solution{
    public List<List<String>> groupAnagrams(String[] strs){
        Map<String, List<String>> anagram = new HashMap<>();
        for(String str : strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedkey = new String(charArray);
            anagram.putIfAbsent(sortedkey, new ArrayList<>());
            anagram.get(sortedkey).add(str);
        }
        return new ArrayList<>(anagram.values());
    }
}