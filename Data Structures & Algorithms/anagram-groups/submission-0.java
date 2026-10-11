class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String i:strs){
            char[] str = i.toCharArray();
            Arrays.sort(str);
            String key = new String(str);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(i);
            
        }
        return new ArrayList<>(map.values());
        
    }
}
