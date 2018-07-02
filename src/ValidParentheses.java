import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args){
        Solution s = new Solution();
        boolean ans = s.isValid("]");
        System.out.println(ans);
    }

    public static class Solution{
        public boolean isValid(String s){
            Stack<Character> stack = new Stack<>();
            for(int i=0;i<s.length();i++){
                char curr = s.charAt(i);
                if(curr=='(' || curr=='[' || curr=='{'){
                    stack.push(curr);
                }
                else if(curr==')' || curr==']' || curr=='}'){
                    if(stack.isEmpty()){
                        return false;
                    }
                    int diff = curr - stack.pop();
                    if(diff != 1 && diff != 2){
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
    }
}
