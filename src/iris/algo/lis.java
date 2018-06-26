package iris.algo;

import java.util.Arrays;

public class lis {
    /**
     * 产生dp数组
     * @param arr
     * @return
     */
    public static int[] getdp1(int[] arr) {
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        return dp;
    }

    public static int[] generateLIS(int[] arr, int[] dp) {
        int max = 0, maxIndex = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > max) {
                max = dp[i];
                maxIndex = i;
            }
        }

        int[] lis = new int[max];
        lis[--max] = arr[maxIndex];
        for (int i = maxIndex-1; i >= 0; i--) {
            if (arr[i] < arr[maxIndex] && dp[i] == dp[maxIndex]-1) {
                lis[--max] = arr[i];
                maxIndex = i;
            }
        }
        return lis;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,5,3,6,4,8,9,7};
        int[] res = generateLIS(arr, getdp1(arr));
        System.out.println(Arrays.toString(res));
    }
}
