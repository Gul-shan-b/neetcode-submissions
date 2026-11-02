class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
        char[] ch1 = s1.toCharArray();
        Arrays.sort(ch1);
        int n = s1.length();
        for(int i = 0; i <= s2.length() - n; i++){
             String s22 = s2.substring(i, i+n);
             char[] ch2 = s22.toCharArray();
             Arrays.sort(ch2); 
             if(Arrays.equals(ch1,ch2)){
                return true;
            }
            
        } 
        return false;  
    }
}
