class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        for(int i=0; i<s.length(); i++){
            HashSet<Character> set= new HashSet<>();
            for(int j=i; j<s.length(); j++){
                char ch = s.charAt(j);
                if(set.contains(ch)){
                    break;
                }

                set.add(ch);
                maxLength = Math.max(maxLength, j-i+1);
            } 
        }
        return maxLength;
    }
}