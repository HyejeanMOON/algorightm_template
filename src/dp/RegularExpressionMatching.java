package dp;

import java.util.HashMap;

public class RegularExpressionMatching {
    private HashMap<String, Boolean> map = new HashMap<>();

    public boolean match(String s, String pattern) {
        map.clear();
        return match(s, 0, pattern, 0);
    }

    private boolean match(String s, int sIndex, String p, int pIndex) {
        int sLen = s.length(), pLen = p.length();

        // 递归终止的条件
        if (pIndex == pLen) {
            // 当pattern已经走到尾的时候如果s也走到底了，则说明完全匹配
            return sIndex == sLen;
        }

        if (sIndex == sLen) {
            // 当s完全走完时，我们需要分情况进行讨论
            if ((pLen - pIndex) % 2 == 1) {
                // 当pattern还剩下时，只有存在*才可以。
                // 但是*是不能单独存在的，所以如果剩下的pattern字符串如果是奇数则应该返回false
                return false;
            } else {
                // 当pattern剩下的字符串为偶数是，我们则要判断各个偶数位的字符是否为*，
                // 如果不是则应该返回分false
                for (; pIndex + 1 < pLen; pIndex = pIndex + 2) {
                    if (p.charAt(pIndex + 1) != '*') {
                        return false;
                    }
                }
                return true;
            }
        }

        // 该算法中有很多重叠子问题，我们利用map来记录答案，防止重复计算。
        String key = sIndex + "," + pIndex;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        boolean res;

        if (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '.') {
            // 当两个字符相等或pattern是通配符时
            if (pIndex + 1 < pLen && p.charAt(pIndex + 1) == '*') {
                // 如果下一个字符为*通配符
                // 此时通配符代表一个或者多个
                res = match(s, sIndex, p, pIndex + 2) || match(s, sIndex + 1, p, pIndex);
            } else {

                res = match(s, sIndex + 1, p, pIndex + 1);
            }
        } else {
            // 当两个字符不想等时
            if (pIndex + 1 < pLen && p.charAt(pIndex + 1) == '*') {
                // 如果下一个字符为*通配符
                // 此时的通配符代表为0个个数
                res = match(s, sIndex, p, pIndex + 2);
            } else {
                // 要是不是通配符，则说明完全没有匹配上
                res = false;
            }
        }

        map.put(key, res);

        return res;
    }
}
