package practice.mid;

import java.util.Arrays;

public class ZerosAndOnes {
    public static void main(String[] args) {
        int[] array = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(countZerosAndOnes(array)));
    }

    public static int[] countZerosAndOnes(int[] input) {
        int[] result = new int[2];
        if (input.length == 0) return new int[]{0, 0};
        else if (input[0] == 1) return new int[]{0, input.length};
        else if (input[input.length - 1] == 0) return new int[]{input.length, 0};
        else return binarySearch(input, 0, input.length - 1);
    }

    private static int[] binarySearch(int[] arr, int left, int right) {
        int[] result = new int[2];
        int mid = (left + right) / 2;
        if (arr[mid] == 0 && arr[mid + 1] == 1) {
            result[0] = mid + 1;
            result[1] = arr.length - (mid + 1);
            return result;
        }
        if (arr[mid] == 0 && arr[mid + 1] == 0) {
            return binarySearch(arr, mid + 1, right);
        }
        if (arr[mid] == 1) {
            return binarySearch(arr, left, mid - 1);
        }
        return null;
    }
}
