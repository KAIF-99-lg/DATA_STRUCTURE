class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1); // Ensure nums1 is smaller
        }
        
        int m = nums1.length, n = nums2.length;
        int low = 0, high = m;
        
        while (low <= high) {
            int i = (low + high) / 2;  // Partition for nums1
            int j = (m + n + 1) / 2 - i; // Partition for nums2

            int left1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int left2 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int right1 = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int right2 = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if (left1 <= right2 && left2 <= right1) {
                // Correct partition
                if ((m + n) % 2 == 0) {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                } else {
                    return Math.max(left1, left2);
                }
            } else if (left1 > right2) {
                high = i - 1; // Move left
            } else {
                low = i + 1; // Move right
            }
        }
        return 0.0; // Should never reach here
    }
}
