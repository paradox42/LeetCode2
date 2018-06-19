public class StringToInteger {
    public static void main(String args[]){
        Solution s = new Solution();
        int result = s.myAtoi(" 321");
        System.out.println(result);
    }

    public static class Solution{
        int result = 0;
        boolean isChanged = false;
        public int myAtoi(String str){
            if(str.length() == 0){
                return result;
            }

            char c = str.charAt(0);

            if(c == ' ' && !isChanged){
                skipSpace(str);
            }
            else if(Character.isDigit(c)){
                onlyReadPositiveDigits(str);
            }
            else if(c == '+' && !isChanged){
                onlyReadPositiveDigits(str.substring(1));
            }
            else if(c == '-' && !isChanged){
                onlyReadNegativeDigits(str.substring(1));
            }

            return result;
        }

        public void skipSpace(String s){
            if(s.length() == 0)
                return;

            char c = s.charAt(0);
            if(c == ' '){
                skipSpace(s.substring(1));
            }
            else if(Character.isDigit(c)){
                onlyReadPositiveDigits(s);
            }
            else if(c == '+'){
                onlyReadPositiveDigits(s.substring(1));
            }
            else if(c == '-'){
                onlyReadNegativeDigits(s.substring(1));
            }

        }

        public void onlyReadPositiveDigits(String s){
            if(s.length()==0)
                return;

            char c = s.charAt(0);
            if(Character.isDigit(c)){
                isChanged = true;
                int plus = Character.getNumericValue(c);
                int next = result*10 + plus;
                int reCalc = (next-plus)/10;
                if(result != reCalc || next < result){
                    result = Integer.MAX_VALUE;
                    return;
                }
                result = next;
                onlyReadPositiveDigits(s.substring(1));
            }
            else{
                return;
            }
        }

        public void onlyReadNegativeDigits(String s){
            if(s.length()==0){
                result = result *-1;
                return;
            }

            char c = s.charAt(0);
            if(Character.isDigit(c)){
                isChanged = true;
                int plus = Character.getNumericValue(c);
                int next = result*10 + plus;
                int reCalc = (next-plus)/10;
                if(result != reCalc ||  next < result){
                    result = Integer.MIN_VALUE;
                    return;
                }
                result = next;
                onlyReadNegativeDigits(s.substring(1));
            }
            else{
                result = result * -1;
                return;
            }
        }
    }
}
