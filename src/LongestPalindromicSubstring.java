public class LongestPalindromicSubstring {
    public static void main(String args[]){
        Solution s = new Solution();
        String result = s.longestPalindrome("aabbcccbb");
        System.out.println(result);
    }

    static class Solution {

        public String longestPalindrome(String s) {
            int len = s.length();
            boolean[][] table = new boolean[len][len];
            int locationx = 0, locationy = 0;
            //check for len of 1
            for (int i = 0; i < len; i++) {
                table[i][i] = true;
            }
            //check for len of 2
            for (int i = 0; i < len - 1; i++) {
                int x = i, y = i + 1;
                if (s.charAt(x) == s.charAt(y)) {
                    table[x][y] = true;
                    locationx = x;
                    locationy = y;
                } else {
                    table[x][y] = false;
                }
            }

            //check for rest of string
            for (int i = 0; i < len - 2; i++) {
                for (int j = 0; j < len - 2 - i; j++) {
                    int x = j, y = i + 2 + j;
                    if (s.charAt(x) == s.charAt(y) && table[x + 1][y - 1] == true) {
                        table[x][y] = true;
                        if (y - x > locationy - locationx) {
                            locationx = x;
                            locationy = y;
                        }
                    } else {
                        table[x][y] = false;
                    }
                }
            }
            return s.substring(locationx, locationy + 1);
        }
    }
}
//
//        public String fillTruthTable(boolean[][] table, String s){
//            int len = table.length;
//            //location hold the maximum palindromic substring indexes
//            int locationx=0,locationy=0;
//            //check for len of 1
//            for(int i=0;i<len;i++){
//                table[i][i] = true;
//            }
//            //check for len of 2
//            for(int i=0;i<len-1;i++){
//                int x=i,y=i+1;
//                if(s.charAt(x) == s.charAt(y)){
//                    table[x][y] = true;
//                    locationx=x;
//                    locationy=y;
//                }
//                else{
//                    table[x][y] = false;
//                }
//            }
//            //check for rest of string
//
//            for(int i=0;i<len-2;i++){
//                for(int j=0;j<len-2-i;j++){
//                    int x=j,y=i+2+j;
//                    if(s.charAt(x) == s.charAt(y) && table[x+1][y-1] == true){
//                        table[x][y] = true;
//                        if(y-x > locationy-locationx){
//                            locationx = x;
//                            locationy = y;
//                        }
//                    }
//                    else{
//                        table[x][y] = false;
//                    }
//                }
//            }
//            return s.substring(locationx, locationy+1);
//        }
//    }

