import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        // Count frequency of each number
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int maxLength = 0;

        // Find the longest harmonious subsequence
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                maxLength = Math.max(maxLength, map.get(key) + map.get(key + 1));
            }
        }

        return maxLength;
    }
}
