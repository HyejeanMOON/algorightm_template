package eggdrop;

import java.util.HashMap;

public class EggDropByBinarySearch {
    private HashMap<String, Integer> map = new HashMap<>();

    public int getEggDropByBinarySearch(int n, int eggCount) {

        if (eggCount == 1) return n;
        if (n == 0) return 0;

        String key = n + "," + eggCount;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        int res = Integer.MAX_VALUE;

        int low = 1, high = n;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int broken = getEggDropByBinarySearch(mid - 1, eggCount - 1);
            int noBroken = getEggDropByBinarySearch(n - mid, eggCount);
            if (broken > noBroken) {
                high = mid - 1;
                res = Math.min(res, broken+1);
            } else {
                low = mid + 1;
                res = Math.min(res, noBroken+1);
            }
        }

        map.put(key, res);
        return res;
    }
}
