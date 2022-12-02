package leetcode.twopointers;

import java.util.Arrays;

/**
 * N1089 Duplicate Zeros
 * Given a fixed-length integer array arr, duplicate each occurrence of zero, shifting the remaining elements to the right.
 * Note that elements beyond the length of the original array are not written.
 * Do the above modifications to the input array in place and do not return anything.
 */
public class EasyDuplicateZeros {
    public static void main(String[] args) {
        int[] arr = {0,1,2,0,5,0,0,7};
        duplicateZeros(arr);
    }

    public static void duplicateZeros(int[] arr) {

        for(int i = arr.length - 2; i >= 0; i--){
            if(arr[i] == 0){
                for(int j = arr.length-1; j > i; j--){
                    arr[j] = arr[j-1];
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
