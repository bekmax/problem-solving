package practice.mid;

public class BubbleSort2 {
    public static void main(String[] args) {
        int[] arr = {23, 24, 35, 46, 7, 3, 2, 33, 67, 68, 3, 442, 4, 676, 8};
        print(arr);
        bubbleSort1(arr);
        print(arr);
    }

    /**
     * Problem N3
     * To reduce the time complexity in Bubble Sort we can reduce the number of iterations in inner loop.
     * We define lastUnsortedIndex to be the last element index.
     * As we move the element with the largest value to the end of the array we can reduce the
     * lastUnsortedIndex by one. By doing that we reduce the inner loop iteration count.
     */
    public static void bubbleSort1(int[] arr) {
        for (int lastUnsortedIndex = arr.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            boolean isSorted = true;
            for (int i = 0; i < lastUnsortedIndex; i++) {
                if (arr[i] > arr[i + 1]) {
                    isSorted = false;
                    swap(arr, i, i + 1);
                }
            }
            if (isSorted) break;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[i + 1];
        arr[i + 1] = temp;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
