class Solution {
    public int[][] swapArrays(int[] a, int[] b) {
            return new int[][] {b, a};
        }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length) {
            int[][] swappedArr = swapArrays(nums1, nums2);
            nums1 = swappedArr[0];
            nums2 = swappedArr[1];
        }
        int Alen = nums1.length, Blen = nums2.length;
        int total = Alen + Blen;
        int half = (total + 1) / 2;
        int left = 0, right = Alen;
        while (left <= right) {
            int i = (left + right) / 2;
            int j = half - i;

            int Aleft = (i == 0) ? Integer.MIN_VALUE : nums1[i-1];
            int Aright = (i >= Alen) ? Integer.MAX_VALUE : nums1[i];

            int Bleft = (j == 0) ? Integer.MIN_VALUE : nums2[j-1];
            int Bright = (j >= Blen) ? Integer.MAX_VALUE : nums2[j];

            if (Aleft <= Bright && Bleft <= Aright) {
                if (total % 2 == 0) {
                    return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
                }
                else {
                    return (Math.max(Aleft, Bleft));
                }
            }
            else if (Aleft > Bright) {
                right = i - 1;
            }
            else {
                left = i + 1;
            }
        }
        throw new IllegalArgumentException("Input arrays are not sorted.");
    }
}

class MedianOfTwoSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        Solution s = new Solution();
        double median = s.findMedianSortedArrays(nums1, nums2);
        System.out.println("The median of the two arrays is: " + median);
    }
}