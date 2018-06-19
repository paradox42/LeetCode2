public class LongestCommonPrefix {
    public static void main(String args[]){
        Solution s = new Solution();
        String ans = s.longsetCOmmonPrefix(new String[]{
                "b",
                "cb",
                "cab"
        });
        System.out.println(ans);
    }

    public static class Solution{
        public String longsetCOmmonPrefix(String[] strs){
            String ans = "";
            try{
                boolean flag = true;
                int charIndex = 0;
                while(charIndex >= 0){
                    for(int i=0;i<strs.length;i++){
                        if(i != strs.length-1){
                            char currChar = strs[i].charAt(charIndex);
                            char nextChar = strs[i+1].charAt(charIndex);
                            flag = currChar == nextChar;
                        }
                        if(!flag){
                            return ans;
                        }
                    }
                    if(flag){
                        ans += strs[0].charAt(charIndex);
                    }
                    else{
                        return ans;
                    }
                    charIndex ++;
                }
            }
            catch (NullPointerException|ArrayIndexOutOfBoundsException|StringIndexOutOfBoundsException e){
                return ans;
            }
            return ans;
        }

        public String binarySearch(String[] strs){
            return "";
        }
    }
}

