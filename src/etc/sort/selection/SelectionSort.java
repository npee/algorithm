package etc.sort.selection;

public class SelectionSort {
    public static void main(String[] args) {

        int[] arr = new int[]{5, 1, 9, 0, 4, 2, 3, 7, 8, 6};

        toString(arr);
        for (int i = 0; i < arr.length; i++) {
            swap(i, min_idx(i, arr), arr);
            toString(arr);
        }
    }

    public static void toString(int[] array) {
        System.out.print("arr: [");
        for (int j = 0; j < array.length - 1; j++) {
            System.out.print(array[j] + "], [");
        }
        System.out.println(array[array.length - 1] + "]");
    }

    public static int min_idx(int start, int[] array) {
        int min = array[start];
        int idx = start;
        for (int i = start; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                idx = i;
            }
        }
        System.out.println("min_value: " + min + " , Swap arr[" + idx + "] with arr[" + start + "]");
        return idx;
    }

    public static void swap(int start, int target, int[] array) {
        int temp;
        temp = array[start];
        array[start] = array[target];
        array[target] = temp;
    }
}

