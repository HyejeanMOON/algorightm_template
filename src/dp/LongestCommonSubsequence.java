package dp;

public class LongestCommonSubsequence {
    // 最长公共子序列， Longest Common Subsequence
    // 时间复杂度O(s.length*p.length), 空间复杂度O(s.length*p.length)

    public int getLongestCommonSubsequence(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        int[][] dp = new int[sLen + 1][pLen + 1];

        char[] sChar = s.toCharArray();
        char[] pChar = p.toCharArray();

        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                if (sChar[i-1] == pChar[j-1]) {
                    // 当s和p中的字符相匹配时
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 当s和p中的字符不匹配时，我们需要进行选择其中的最大值。
                    // 这里其实还需要加一个dp[i-1][j-1],但是这个明显比其他两个选项小，所以可以忽略
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[sLen][pLen];
    }
}
