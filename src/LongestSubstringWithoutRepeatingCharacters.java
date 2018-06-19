import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.slidingWindowOptimizedLengthOfLongestSubstring("asjrgabcde"));
    }

    static class Solution{
        public int lengthOfLongestSubstring(String s){
            HashSet set = new HashSet();
            int left=0,right=0,len=s.length();
            int max = 0;
            while(right < len){
                System.out.println(left+ " "+ right);
                if(!set.contains(s.charAt(right))){
                    set.add(s.charAt(right));
                    right += 1;
                    max = Math.max(max, right-left);
                }
                else{
                    set.remove(s.charAt(left));
                    left += 1;
                }
            }

            return max;
        }

//        The above solution requires at most 2n steps. In fact, it could be optimized to require only n steps. Instead of using a set to tell if a character exists or not, we could define a mapping of the characters to its index. Then we can skip the characters immediately when we found a repeated character.
//
//        The reason is that if s[j]s[j] have a duplicate in the range [i, j)[i,j) with index j'j
//                ​′
//       ​​ , we don't need to increase i little by little. We can skip all the elements in the range [i, j'][i,j
//​′
//        ​​ ] and let ii to be j' +1 directly.

        public int slidingWindowOptimizedLengthOfLongestSubstring(String s){
            int length = s.length(), ans = 0;
            Map<Character, Integer> map = new HashMap<>();
            //try to extend the range [i,j]
            for(int j=0,i=0;j<length;j++){
                if(map.containsKey(s.charAt(j))){
                    i = Math.max(map.get(s.charAt(j)), i);
                }
                ans = Math.max(ans, j-i+1);
                map.put(s.charAt(j), j+1);
            }
            return ans;
        }
    }
}
