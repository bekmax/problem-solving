package practice.mid;

public class Merge {
    public static void main(String[] args) {
        int[] arr2 = {1, 3, 5, 7, 9};
        int[] arr1 = {2, 4, 6, 8, 10, 13, 15};

        int[] result = merge(arr1, arr2);
        print(result);
    }

    static int[] merge(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int lastIndex = result.length - 1;
        int m = arr1.length - 1;
        int n = arr2.length - 1;

        while (lastIndex >= 0) {
            if (n < 0 || (m >= 0 && arr1[m] >= arr2[n])) {
                result[lastIndex] = arr1[m--];
            } else {
                result[lastIndex] = arr2[n--];
            }
            lastIndex--;
        }
        return result;
    }

    static void print(int[] nums) {
        for (int n : nums) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
