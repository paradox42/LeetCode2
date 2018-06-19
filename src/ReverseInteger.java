public class ReverseInteger {
    public static void main(String args[]){
        Solution s = new Solution();
        int result = s.reverse(1534236469);
        System.out.println(result);
//        System.out.println(2&1);

    }

    public static class Solution{
        public int reverse(int x) {
            int result = 0;
            while(x != 0){
                result = result *10;
                result = result + x%10;
                if(result%10 != x%10){
                    return 0;
                }
                x = x/10;
            }

            return result;
        }
    }
}
