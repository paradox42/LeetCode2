import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args){
        Solution s = new Solution();
        int[] test = new int[]{3,2,4};
        int[] ans = s.twoSum(test,6);
        for(int i: ans){
            System.out.print(i+" ");
        }
    }

    public static class Solution{
        public int[] twoSum(int[] nums, int target){

            HashMap<Integer,Integer> map = new HashMap<>();
            for(int i=0;i<nums.length;i++){
                map.put(nums[i],i);
            }

            for(int i=0;i<nums.length;i++){
                int otherNum = target - nums[i];
                if(map.get(otherNum) != null && map.get(otherNum) != i){
                    return new int[]{map.get(otherNum),i};
                }
            }
            return new int[]{};
        }
    }
}
