//Given n non-negative integers a1, a2, ..., an, where each represents a
//point at coordinate (i, ai). n vertical lines are drawn such that the
//two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together
//with x-axis forms a container, such that the container contains the most water.
//Note: You may not slant the container and n is at least 2.
import java.io.*;
import java.nio.charset.Charset;
import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class ContainerWIthMostWater {
    public static void main(String[] args) throws IOException{
        Solution s = new Solution();
        int[] input = readFile();

        float start = System.nanoTime();
        int ans = s.maxArea(input);
        float end = System.nanoTime();

        System.out.println(ans);
        System.out.println(end - start);
    }

    public static int[] readFile() throws IOException {
        ArrayList<Integer> list = new ArrayList<Integer>();
        String fileName = "input.txt";
        String line = "null";
        Charset encoding = Charset.defaultCharset();
        File file = new File(fileName);

        try (InputStream in = new FileInputStream(file);
            Reader reader = new InputStreamReader(in, encoding);
            Reader buffer = new BufferedReader(reader)){
            int r;
            String singleNum = new String();
            while((r = reader.read()) != -1){
                char ch = (char) r;
                if(Character.isDigit(ch)){
                    singleNum += Character.toString(ch);
                }
                else if(ch == ','){
                    list.add(Integer.valueOf(singleNum));
                    singleNum = new String();
                }
            }
            list.add(Integer.valueOf(singleNum));
            reader.close();
            buffer.close();
        }

        int[] result = new int[list.size()];
        for(int i=0;i<list.size();i++){
            result[i] = list.get(i);
        }
        return result;
    }

    public static class Solution{
        public int maxArea(int[] height){
            int max = 0;
            int left = 0, right = height.length-1;

            while(left < right){
                int w=right-left, h=Math.min(height[left],height[right]);
                max = Math.max(max, w*h);
                if (height[left] < height[right]){
                        left ++;
                }
                else{
                    right --;
                }
            }

            return max;
        }
    }
}
