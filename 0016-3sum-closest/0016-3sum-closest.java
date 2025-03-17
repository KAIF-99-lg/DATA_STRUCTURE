class Solution {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums); // Step 1: Sort the array
        int closestSum = nums[0] + nums[1] + nums[2]; // Initialize closest sum

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                
                // If current sum is closer to the target, update closestSum
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }

                // Move pointers based on comparison with target
                if (currentSum < target) {
                    left++;
                } else if (currentSum > target) {
                    right--;
                } else {
                    return currentSum; // Exact match found
                }
            }
        }

        return closestSum; // Return the closest sum found
    }
}