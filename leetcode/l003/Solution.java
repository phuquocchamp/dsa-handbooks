package l003;
import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> container = new HashSet<>();
        int left = 0, result = 0;

        for(int right = 0; right < s.length(); right++){
            if(!container.contains(s.charAt(right))){
                container.add(s.charAt(right));
                result = Math.max(result, right - left + 1);
            }else{
                while(container.contains(s.charAt(right))){
                    container.remove(s.charAt(left));
                    left++;
                }
                container.add(s.charAt(right));
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";

        Solution sol = new Solution();
        System.out.println(sol.lengthOfLongestSubstring(s));
    }
}