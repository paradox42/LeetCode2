public class PalindromeNumber {
    public static void main(String args[]){
        Solution s = new Solution();
        boolean ans = s.isPalindrome(10);
        System.out.println(ans);
    }

    public static class Solution{
        public boolean isPalindrome(int x) {
            if(x < 0 ||(x%10==0&&x!=0)){
                return false;
            }

            int newNum = 0;
            while(newNum < x){
                int digit = x % 10;
                newNum = newNum*10 + digit;
                x = x/10;
            }
            return x == newNum || x == newNum/10;
        }
    }
}
