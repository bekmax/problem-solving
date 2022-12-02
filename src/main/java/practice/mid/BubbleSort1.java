package practice.mid;

public class BubbleSort1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        print(arr);
        bubbleSort1(arr);
        print(arr);
    }

    /**
     * Problem N2
     * This algorithm's run time is O(n) for already sorted array
     * We achieve that using an already sorted flag by setting it to true initially
     * Then we check if there is any time, where we need to swap two elements
     * If we never swap the elements in the first iteration of an inner loop, it means
     * that an array is already sorted, So the time complexity is O(n)
     */
    public static void bubbleSort1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean isSorted = true;
            for (int j = 1; j < arr.length; j++) {
                if (arr[j] < arr[j - 1]) {
                    isSorted = false;
                    swap(arr, j, j - 1);
                }
            }
            if (isSorted) break;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
