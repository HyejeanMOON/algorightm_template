package dp;

public class PackageProblem {
    // 背包问题，要求我们在给定的背包重量下，放下最大价值的物品
    // 时间复杂度O(count*weight), 空间复杂度O(count*weight)
    // weight: 目标重量， count: 物品的个数， packages: 每个物品的重量， values: 每个物品的价值

    public int getValue(int weight, int count, int[] packages, int[] values){

        if(count==1 && weight>=packages[0]) return 1;
        else if(count == 1) return 0;
        if(count == 0) return 0;

        int[][] dp = new int[count+1][weight+1];

        for(int i=1; i<=count; i++){
            for(int j=1; j<=weight; j++){
                if(j-packages[i-1]<0){
                    // 如果当前的可放入重量小于当前物品的重量，则不能被放入，
                    // 赋值给前一个物品的价值即可
                    dp[i][j] = dp[i-1][j];
                }else{
                    // 如果当前的可放入重量大于当前物品的重量，则可以放入，
                    // 这时候需要进行判断，放入和不放入哪一个价值更大
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-packages[i-1]]+values[i-1]);
                }
            }
        }

        return dp[count][weight];
    }
}
