import java.util.HashMap;
import java.util.Map;

class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store the value and its index
        Map<Integer, Integer> numMap = new HashMap<>();

        // Iterate over the array
        for (int i = 0; i < nums.length; i++) {
            // Calculate the complement of the current element
            int complement = target - nums[i];

            // Check if the complement is already in the map
            if (numMap.containsKey(complement)) {
                // If complement is found, return the current index and the index of the complement
                return new int[] { numMap.get(complement), i };
            }

            // Store the current value and its index in the map
            numMap.put(nums[i], i);
        }

        // In case no solution is found (though the problem statement guarantees one)
        throw new IllegalArgumentException("No two sum solution");
    }
}


public class TwoSum {
    public static void main(String[] args) throws Exception {
        int[] nums = {3,2,4};
        int target = 6;
        Solution1 newsol = new Solution1();
        int[] result = newsol.twoSum(nums, target);
        System.out.println("["+result[0]+","+result[1]+"]");
    }
}