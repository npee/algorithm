package etc.sort.merge;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = new int[]{1, 9, 8, 5, 4, 2, 3, 7, 6};

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        mergeSort(array, 0, array.length - 1);

    }
    public static void mergeSort(int[] src, int from, int to) {
        int[] temp = new int[src.length];
        if (from < to) {
            int mid = (from + to) / 2;

            mergeSort(src, from, mid);
            mergeSort(src, mid + 1, to);

            int l = from;
            int r = mid + 1;
            int index = l;

            while (l <= mid || r <= to) {
                if (r > to || (src[l] < src[r] && l <= mid)) {
                    temp[index++] = src[l++];
                }

                else { // else if (r <= to && (src[l] >= src[r] || l > mid))
                    temp[index++] = src[r++];
                }
            }

            for (int i = from; i <= to; i++) {
                src[i] = temp[i];
            }

            for (int i = 0; i < temp.length; i++) {
                System.out.print(temp[i] + " ");
            }
            System.out.println();
        }
    }
}
