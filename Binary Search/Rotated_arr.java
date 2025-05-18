class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
            else {
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
public class Rotated_arr {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[] {6,7,8,0,1,2,3,4,5};
        System.out.println(s.search(nums, 4));
    }
  }