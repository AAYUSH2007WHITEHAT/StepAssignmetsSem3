import java.util.HashMap;
import java.util.Map;

public class q4 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCounts = new HashMap<>();
        
        prefixSumCounts.put(0, 1);

        int currentPrefixSum = 0;
        int totalSubarrays = 0;

        for (int num : nums) {
            currentPrefixSum += num;
            int requiredPrefix = currentPrefixSum - k;
            if (prefixSumCounts.containsKey(requiredPrefix)) {
                totalSubarrays += prefixSumCounts.get(requiredPrefix);
            }
            prefixSumCounts.put(currentPrefixSum, prefixSumCounts.getOrDefault(currentPrefixSum, 0) + 1);
        }

        return totalSubarrays;
    }
}