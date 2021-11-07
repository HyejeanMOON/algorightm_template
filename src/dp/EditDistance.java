package dp;

import com.sun.tools.javac.Main;

public class EditDistance {
    // 编辑距离问题：要求我们通过删除，增加，替换的方式使两个字符串相同，求出最少实现的步骤数

    public int getEditDistance(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        int[][] dp = new int[len1+1][len2+1];

        for (int i = 1; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= len2; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    // 如果两个字符串相同，则跳过
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 如果两个字符串不相同，选择多种情况中最小的一个
                    // 一共有删除，添加，替换，
                    // 替换其实和跳过是一样的感觉
                    dp[i][j] = min(dp[i - 1][j]+1, dp[i - 1][j - 1]+1, dp[i][j - 1]+1);
                }
            }
        }
        return dp[len1][len2];
    }

    private int min(int i1, int i2, int i3) {
        return Math.min(i1, Math.min(i2, i3));
    }
}
