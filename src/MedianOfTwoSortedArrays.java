import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args){
        Solution s = new Solution();
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3,4};
        double ans = s.findMedianSortedArrays(nums1, nums2);
        System.out.println(ans);
    }

    static class Solution{
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int i = 0, j = 0,k = 0, len1 = nums1.length, len2 = nums2.length;
            int len3 = len1 + len2;
            int[] merged = new int[len3];

            while(i+j < len3){
                if(i < len1 && j < len2){
                    if(nums1[i] < nums2[j]){
                        merged[i+j] = nums1[i];
                        i++;
                    }
                    else{
                        merged[i+j] = nums2[j];
                        j++;
                    }
                }
                else if(i >= len1){
                    merged[i+j] = nums2[j];
                    j++;
                }
                else{
                    merged[i+j] = nums1[i];
                    i++;
                }
            }
            System.out.println(Arrays.toString(merged));
            if(len3 % 2 != 0){
                return merged[len3/2];
            }
            else{
                System.out.println(merged[len3/2]+ " " + merged[len3/2-1]);
                return (merged[len3/2]+merged[len3/2-1])/2.0;
            }
        }
    }
}
