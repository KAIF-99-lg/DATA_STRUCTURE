import java.util.*;

public class Solution {
    public String largestNumber(int[] nums) {
        // Convert the numbers to strings for easier comparison
        String[] numStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStrs[i] = String.valueOf(nums[i]);
        }
        
        // Sort the numbers using a custom comparator
        Arrays.sort(numStrs, (a, b) -> (b + a).compareTo(a + b));
        
        // If the largest number is "0", return "0"
        if (numStrs[0].equals("0")) {
            return "0";
        }
        
        // Concatenate the sorted numbers
        StringBuilder result = new StringBuilder();
        for (String numStr : numStrs) {
            result.append(numStr);
        }
        
        return result.toString();
    }
}
