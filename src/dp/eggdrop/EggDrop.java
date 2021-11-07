package dp.eggdrop;

import java.util.HashMap;

public class EggDrop {
    // 鸡蛋掉落问题：给定鸡蛋个数和楼层n，问需要扔多少次鸡蛋才能知道鸡蛋会在第几层摔坏。
    // n: 楼层高度, eggCount: 鸡蛋个数

    private HashMap<String, Integer> map = new HashMap<>();

    public int getEggDrop(int n, int eggCount) {
        if (eggCount == 1) return n;
        if (n == 0) return 0;

        String key = n + "," + eggCount;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        int res = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            res = Math.min(
                    res,
                    Math.max(
                            getEggDrop(i - 1, eggCount - 1),
                            getEggDrop(n - i, eggCount)
                    ) + 1
            );
        }
        map.put(key, res);
        return res;
    }
}