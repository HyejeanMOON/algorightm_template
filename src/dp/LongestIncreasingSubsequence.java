package dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    // 最长递增子序列：
    // 子序列：不需要连续 subsequence
    // 子串：需要连续 substring
    // 时间复杂度O(nums.length^2), 空间复杂度O(nums.length)

    public int getLongestIncreasingSubsequence(int[] nums) {
        if (nums.length == 0) return 0;

        int[] dp = new int[nums.length];

        // 因为只有它自身的时候也算是递增子序列，所以默认都应该是1
        Arrays.fill(dp, 1);
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            // 遍历i之前的所有的数，如果比i小的数的话，进行大小比较，选出最大的
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            result = Math.max(result, dp[i]);
        }

        return result;
    }
}
