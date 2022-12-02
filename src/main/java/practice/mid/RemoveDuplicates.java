package practice.mid;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] A = {7,9,2,2,0};

        int[] result = removeDuplicates(A);
        print(result);

    }

    public static int[] removeDuplicates(int[] A) {
        int[] W = new int[A.length * 2];
        int[] B = new int[A.length];

        int index = 0;

        for (int i = 0; i < A.length; i++) {
            int u = A[i];
            W[u] = W[u] + 1;

            if (W[u] == 1) {
                B[index] = A[i];
                index++;
            }
        }

        int[] C = new int[index];
        for (int i = 0; i < index; i++) {
            C[i] = B[i];
        }

        return C;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}




