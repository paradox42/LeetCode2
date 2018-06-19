
import java.util.HashMap;

public class RomanToInteger {
    public static void main(String[] args){
        Solution s = new Solution();
        IntegerToRoman.Solution s2 = new IntegerToRoman.Solution();
        for(int i=1;i<3999;i++){
            String testStr = s2.intToRoman(i);
            int ans = s.romanToInt(testStr);
            if(i != ans){
                System.out.println("wrong case: "+ i);
                break;
            }
        }
    }

    public static class Solution{
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        public Solution(){
            map.put('I', 1);
            map.put('V', 5);
            map.put('X', 10);
            map.put('L', 50);
            map.put('C', 100);
            map.put('D', 500);
            map.put('M', 1000);
        }

        public int romanToInt(String s) {
            int ans=0;
            for(int i=0;i<s.length();i++){
                if(i != s.length()-1){
                    char currChar = s.charAt(i);
                    char nextChar = s.charAt(i+1);
                    int curr = map.get(currChar);
                    int next = map.get(nextChar);
                    if(curr < next){
                        ans -= curr;
                    }
                    else{
                        ans += curr;
                    }
                }
                else{
                    char c = s.charAt(i);
                    int val = map.get(c);
                    ans += val;
                }
            }
            return ans;
        }
    }
}
