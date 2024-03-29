import dp.*;
import dp.eggdrop.EggDrop;
import dp.eggdrop.EggDropByBinarySearch;

public class Main {

    public static void main(String[] args) {
        testRegularExpressionMatching();
    }

    public static void testRegularExpressionMatching() {
        String s = "mississippi", pattern = "mis*is*p*.";
        boolean result = new RegularExpressionMatching().match(s, pattern);
        System.out.println("RegularExpressionMatching result: " + result);
    }

    public static void testLongestCommonSubsequence() {
        String s = "abcde", p = "ace";
        int result = new LongestCommonSubsequence().getLongestCommonSubsequence(s, p);
        System.out.println("LongestCommonSubsequence result: " + result);
    }

    public static void testLongestIncreasingSubsequence() {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        int result = new LongestIncreasingSubsequence().getLongestIncreasingSubsequence(nums);
        System.out.println("LongestIncreasingSubsequence result: " + result);
    }

    public static void testEditDistance() {
        String s1 = "intention", s2 = "execution";
        int result = new EditDistance().getEditDistance(s1, s2);
        System.out.println("testEditDistance result: " + result);
    }

    public static void testPackageProblem() {
        int[] packages = new int[]{2, 1, 3};
        int[] values = new int[]{4, 2, 3};
        int result = new PackageProblem().getValue(4, 3, packages, values);
        System.out.println("testPackageProblem result: " + result);
    }

    public static void testEggDrop() {
        int eggCount = 4;
        int n = 100;
        int result = new EggDrop().getEggDrop(n, eggCount);
        System.out.println("testEggDrop/getEggDrop result: " + result);
        int resultByBinarySearch = new EggDropByBinarySearch().getEggDropByBinarySearch(n, eggCount);
        System.out.println("testEggDrop/getEggDropByBinarySearch result: " + resultByBinarySearch);
    }
}
