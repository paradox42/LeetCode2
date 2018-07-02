import java.util.List;
import java.util.ArrayList;


public class LetterCombinationOfAPhoneNumber {
    public static void main(String[] args){
        Solution s = new Solution();
        List<String> ans = s.letterCombinations("23456789");
        for(String str :ans){
            System.out.println(str);
        }
    }

    public static class Solution{
        final int ASCII_OF_2 = 50;
        final int ASCII_OF_7 = 55;
        final int ASCII_OF_8 = 56;
        final int ASCII_OF_9 = 57;
        final int ASCII_OF_a = 97;
        List<String> ans = new ArrayList<>();
        public List<String> letterCombinations(String digits){
            if(digits.length() == 0){
                return ans;
            }
            else{
                char currDigit = digits.charAt(0);
                List<String> charSet = new ArrayList<>();
                if((int)currDigit != ASCII_OF_7 && (int)currDigit != ASCII_OF_9){
                    int offSet;
                    if((int)currDigit == ASCII_OF_8){
                        offSet = 3*((int)currDigit-ASCII_OF_2)+1;
                    }
                    else{
                        offSet = 3*((int)currDigit-ASCII_OF_2);
                    }
                    for(int i=0;i<3;i++){
                        charSet.add(Character.toString((char)(offSet+ASCII_OF_a+i)));
                    }
                }
                else {
                    int offSet;
                    if((int)currDigit == ASCII_OF_7){
                        offSet = 3*((int)currDigit-ASCII_OF_2);
                    }
                    else{
                        offSet = 3*((int)currDigit-ASCII_OF_2)+1;
                    }
                    for(int i=0;i<4;i++){
                        charSet.add(Character.toString((char)(offSet+ASCII_OF_a+i)));
                    }
                }
                if(ans.size() == 0){
                    ans = charSet;
                }
                else{
                    List<String> newAns = new ArrayList<>();
                    for(int i=0;i<ans.size();i++){
                        for(int j=0;j<charSet.size();j++){
                            newAns.add(ans.get(i)+charSet.get(j));
                        }
                    }
                    ans = newAns;
                }
                return letterCombinations(digits.substring(1,digits.length()));
            }
        }

    }

//        public List<String> letterComboHelper(List<String> ans, String digits){
//            if(digits.length() == 0){
//                return ans;
//            }
//            else{
//                char currDigit = digits.charAt(0);
//                List<String> charSet = new ArrayList<>();
//                if((int)currDigit != ASCII_OF_7 && (int)currDigit != ASCII_OF_9){
//                    int offSet;
//                    if((int)currDigit == ASCII_OF_8){
//                        offSet = 3*((int)currDigit-ASCII_OF_2)+1;
//                    }
//                    else{
//                        offSet = 3*((int)currDigit-ASCII_OF_2);
//                    }
//                    for(int i=0;i<3;i++){
//                        charSet.add(Character.toString((char)(offSet+ASCII_OF_a+i)));
//                    }
//                }
//                else {
//                    int offSet;
//                    if((int)currDigit == ASCII_OF_7){
//                        offSet = 3*((int)currDigit-ASCII_OF_2);
//                    }
//                    else{
//                        offSet = 3*((int)currDigit-ASCII_OF_2)+1;
//                    }
//                    for(int i=0;i<4;i++){
//                        charSet.add(Character.toString((char)(offSet+ASCII_OF_a+i)));
//                    }
//                }
//                if(ans.size() == 0){
//                    ans = charSet;
//                }
//                else{
//                    List<String> newAns = new ArrayList<>();
//                    for(int i=0;i<ans.size();i++){
//                        for(int j=0;j<charSet.size();j++){
//                            newAns.add(ans.get(i)+charSet.get(j));
//                        }
//                    }
//                    ans = newAns;
//                }
//                return letterComboHelper(ans, digits.substring(1,digits.length()));
//            }
//        }
//    }
}
