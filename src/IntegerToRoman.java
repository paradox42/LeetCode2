import java.util.HashMap;

public class IntegerToRoman {
    public static void main(String[] args){
        Solution s = new Solution();
        for(int i=1;i<=3999;i++){
            System.out.println(i);
            System.out.println(s.intToRoman(i));
       }
    }

    public static class Solution{
        HashMap<Integer, String> map = new HashMap<Integer,String>();
        String ans = new String();

        public String intToRoman(int num){
            int[] digits = getDigits(num);
            HashMap<Integer, String[]> map= initMap();
            String ans = new String();
            for(int i: digits){
                ans = ans + singleDigit(i,map);
            }
            return ans;
        }

        public int[] getDigits(int num){
            int[] result = new int[4];
            for(int i=0;i<result.length;i++){
                if(num/1000 != 0){
                    result[0] = num/1000*1000;
                    num = num%1000;
                }
                if(num/100 != 0){
                    result[1] = num/100*100;
                    num = num%100;
                }
                if(num/10 != 0){
                    result[2] = num/10*10;
                    num = num%10;
                }
                if(num != 0){
                    result[3] = num;
                }
            }
            return result;
        }

        public String singleDigit(int num, HashMap<Integer, String[]> map){
            if(num == 0){
                return "";
            }
            String s = new String();
            int firstDigit = Integer.parseInt(String.valueOf(num).substring(0,1));
            int place = num/firstDigit;
            if(firstDigit > 0 && firstDigit < 4){
                for(int i=0;i<firstDigit;i++){
                    s = s + map.get(place)[0];
                }
            }
            else if(firstDigit == 4){
                s = s + map.get(place)[1];
            }
            else if(firstDigit == 5){
                s = s + map.get(place)[2];
            }
            else if(firstDigit > 5 && firstDigit <9){
                s = s + singleDigit(5*place,map)+singleDigit(num-(5*place), map);
            }
            else if(firstDigit == 9){
                s = s + map.get(place)[3];
            }
            return s;
        }

        public HashMap<Integer, String[]> initMap(){
            HashMap m = new HashMap<Integer, String[]>();
            m.put(1,new String[]{"I","IV","V","IX"});
            m.put(10, new String[]{"X","XL","L","XC"});
            m.put(100, new String[]{"C","CD","D","CM"});
            m.put(1000, new String[]{"M"});
            return m;
        }
    }
}
