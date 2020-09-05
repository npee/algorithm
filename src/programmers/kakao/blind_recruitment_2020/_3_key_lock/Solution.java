package programmers.kakao.blind_recruitment_2020._3_key_lock;

public class Solution {
    public static int count = 0;

    public static void main(String[] args) {
        int[][] key = new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        System.out.println(solution(key, lock));
    }

    public static boolean solution(int[][] key, int[][] lock) {
        int[][] extendedLock = extendLock(key, lock);

        if (unlock(key, lock, extendedLock)) return true;
        for (int i = 0; i < 3; i++) {
            key = rotate(key);
            if (unlock(key, lock, extendedLock)) {
                return true;
            }
        }
        count = 0;
        return false;
    }

    public static int[][] rotate(int[][] src) {
        int[][] dst = new int[src.length][src[0].length];

        for (int row = 0; row < src.length; row++) {
            for (int col = 0; col < src[0].length; col++) {
                dst[col][src.length - 1 - row] = src[row][col];
            }
        }

        return dst;
    }

    public static boolean unlock(int[][] key, int[][] lock, int[][] extendLock) {

        int[][] tempLock = new int[extendLock.length][extendLock[0].length];
        for (int i = 0; i < extendLock.length; i++) {
            tempLock[i] = extendLock[i].clone();
        }

        for (int i = 0; i < tempLock.length - key.length + 1; i++) {
            for (int j = 0; j < tempLock[0].length - key[0].length + 1; j++) {
                for (int k = 0; k < key.length; k++) {
                    for (int l = 0; l < key[0].length; l++) {
                        tempLock[i + k][j + l] += key[k][l];
                    }
                }
                if (checkUnlock(key, lock, tempLock)) {
                    return true;
                }
                for (int m = 0; m < extendLock.length; m++) {
                    tempLock[m] = extendLock[m].clone();
                }
            }
        }

        return false;
    }

    public static int[][] extendLock(int[][] key, int[][] lock) {
        int[][] tempLock = new int[lock.length + (key.length - 1) * 2][lock[0].length + (key[0].length -1) * 2];
        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock[0].length; j++) {
                tempLock[i + key.length - 1][j + key[0].length - 1] = lock[i][j];
            }
        }
        return tempLock;
    }

    public static boolean checkUnlock(int[][] key, int[][] lock, int[][] extendLock) {
        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock[0].length; j++) {
                if (!(extendLock[i + key.length - 1][j + key[0].length - 1] == 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void _2dPrint(int[][] src) {
        for (int row = 0; row < src.length; row++) {
            System.out.print("[");
            for (int col = 0; col < src[0].length; col++) {
                System.out.print(src[row][col] + " ");
            }
            System.out.println("]");
        }
        System.out.println();
    }

}
