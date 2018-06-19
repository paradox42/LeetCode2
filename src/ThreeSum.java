import java.lang.reflect.Array;
import java.util.*;

public class ThreeSum {
    public static void main(String args[]){
        Solution s = new Solution();
        List<List<Integer>> ans = s.threeSum(new int[]{0,0,0});
        for(List<Integer> l: ans){
            for(Integer i : l){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public static class Solution{
        public List<List<Integer>> threeSum(int[] nums){
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList<>();
            for(int i=0;i<=nums.length-3;i++){
                if(i==0||nums[i]>nums[i-1]){
                    int left = i+1, right = nums.length-1;
                    while(left < right){
                        if(nums[i]+nums[left]+nums[right] == 0){
                            ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                        }
                        if (nums[i] + nums[left]+nums[right] < 0){
                            int currLeft = left;
                            while(nums[left] == nums[currLeft] && left < right){
                                left++;
                            }
                        }
                        else {
                            int currRight = right;
                            while(nums[right] == nums[currRight] && left < right){
                                right --;
                            }
                        }
                    }
                }
            }
            return ans;
        }
    }
}
