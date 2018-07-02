import java.util.Arrays;
import java.util.Collections;

public class ThreeSumClosest {
    public static void main(String[] args){
        Solution s = new Solution();
        int ans = s.threeSumClosest(new int[]{1,1,1,0},-100);
        System.out.println(ans);
    }

    public static class Solution{
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int closestSum = nums[0]+nums[1]+nums[2], minDiff = Math.abs(closestSum-target);
            for(int i=0;i<=nums.length-3;i++){
                if(i==0||nums[i]>nums[i-1]){
                    int left=i+1,right=nums.length-1;
                    while(left<right) {
                        int sum = nums[i] + nums[left] + nums[right];
                        if (sum == target) {
                            return sum;
                        }
                        if (sum < target) {
                            int currLeft = left;
                            while (nums[currLeft] == nums[left] && left<right) {
                                left++;
                            }
                        }
                        else {
                            int currRight = right;
                            while(nums[currRight] == nums[right] && left<right){
                                right --;
                            }
                        }
                        if(minDiff > Math.abs(sum-target)){
                            minDiff = Math.abs(sum-target);
                            closestSum = sum;
                        }
                    }
                }
            }
            return closestSum;
        }
    }
}
