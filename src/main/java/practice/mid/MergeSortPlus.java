package practice.mid;

public class MergeSortPlus {
    public static int SELF_CALL_COUNT = 0;

    public static void main(String[] args) {
        int[] arr = {6, 2, 8, 4, 1, 5, 8, 9, 3, 0, -5, 2, 4, 5, 3, 1, 2, 11, 4, 7, 8, 9, 7, 8, 6, 5, 4, 3, 2, 4, 6, 7, 5, 3, 3, 47, 5, 45, 32, 12, 32};
        print(arr);

        print(mergeSort(arr));
        System.out.println(SELF_CALL_COUNT);

    }

    /**
     * In the first case I am only using mergeSort algorithm for any number of arrays
     * With the above input the number of Self calls in this case is: 81
     *
     * In the second case I am using insertionSort for arrays that have 20 or fewer elements
     * With the above input the number of Self calls in this case is: 3
     *
     * */
    public static int[] mergeSort(int[] arr) {
        SELF_CALL_COUNT++;
        if (arr.length == 1) return arr;

        int[] left = new int[arr.length / 2];
        int[] right = new int[arr.length - arr.length / 2];

        System.arraycopy(arr, 0, left, 0, arr.length / 2);
        System.arraycopy(arr, arr.length / 2, right, 0, arr.length - arr.length / 2);

//        left = left.length < 20 ? insertionSort(left) : mergeSort(left);
//        right = right.length < 20 ? insertionSort(right) : mergeSort(right);

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    public static int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];

        int i = 0;
        int j = 0;
        int counter = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                c[counter++] = a[i++];
            } else {
                c[counter++] = b[j++];
            }
        }

        while (i < a.length) {
            c[counter++] = a[i++];
        }

        while (j < b.length) {
            c[counter++] = b[j++];
        }

        return c;
    }


    public static int[] insertionSort(int[] arr) {
        for (int firstUnsortedIndex = 1; firstUnsortedIndex < arr.length; firstUnsortedIndex++) {
            int newElement = arr[firstUnsortedIndex];
            int i;
            for (i = firstUnsortedIndex; i > 0 && arr[i - 1] > newElement; i--) {
                arr[i] = arr[i - 1];
            }
            arr[i] = newElement;
        }
        return arr;
    }


    public static void print(int[] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
        System.out.println();
    }
}
