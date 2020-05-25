package baekjoon.n15596;

public class Test {
    static long sum(int[] a) {
        if (a.length > 3000000 || a.length < 1) {
            return -1;
        }
        long ans = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 1000000 || a[i] < 0) {
                return -1;
            }
            ans += a[i];
        }
        return ans;
    }
}