class Solution {
    public int maxArea(int[] heights) {
        int n =heights.length;
        int i =0;
        int j = n-1;
        int max =0; 
        while(i<j){
            int w = j-i;
            int h = Math.min(heights[j],heights[i]);
            int area = w*h;
            max = Math.max(max, area);

            if(heights[i]>heights[j]){
                j--;
            }
            else{
                i++;
            }
        }
        return max;
        
    }
}
