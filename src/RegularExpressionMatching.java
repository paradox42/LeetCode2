public class RegularExpressionMatching {
    public static void main(String[] args){
        Solution s = new Solution();
        s.isMatch("aa","a*");
    }

    public static class Solution{
        public boolean isMatch(String s, String p) {
            if(s.isEmpty() && p.isEmpty()){
                return true;
            }
            int sLen=s.length(),pLen=p.length();
            boolean table[][] = new boolean[sLen+1][pLen+1];

            //init the table

            table[0][0] = true;
            for(int i=1;i<pLen;i++){
                if(p.charAt(i-1)=='*'){
                    table[0][i]=table[0][i-2];
                }
            }

            for(int i=1;i<table.length;i++){
                for(int j=1;j<table[0].length;j++){
                    if(p.charAt(j-1)=='.'||p.charAt(j-1)==s.charAt(i-1)){
                        table[i][j] = table[i-1][j-1];
                    }
                    else if(p.charAt(j-1)=='*'){
                        table[i][j] = table[i][j-2];
                        if(p.charAt(j-2)=='.'||p.charAt(j-2)==s.charAt(i-1)){
                            table[i][j]=table[i][j] | table[i-1][j];
                        }
                    }
                    else{
                        table[i][j] =false;
                    }
                }
            }

            for(boolean[] l: table){
                for(boolean b: l){
                    if(b){
                        System.out.print("1 ");
                    }
                    else{
                        System.out.print("0 ");
                    }
                }
                System.out.println();
            }
            return table[sLen][pLen];
        }
    }
}
