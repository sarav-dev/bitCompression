import java.util.*;

class bitCompression {
    /* There is an array A of N integers. Perform certain operations on the elements.
In any one operation, two indices i and j (i < j) are chosen, and A[i] is replaced with A[i] & A[j],
and A[j] is replaced with A[i] | A[j], where & represents the Bitwise AND operation and | represents the Bitwise OR operation.
This operation is performed over all the pairs of integers in the array.

Find the Bitwise XOR of all the elements after performing the operations. */
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Enter the array length: ");
        int N = sc.nextInt();
        int[] A = new int[N];
        System.out.println();
        System.out.println("Enter array elements: ");
        for (int i=0; i<N; i++) {
            A[i] = sc.nextInt();
        }
        System.out.println();
        System.out.println("XOR of all array elements: " + compressBits(A, N));
        System.out.println();
        sc.close();
        
    }
    public static int compressBits(int[] A, int N) {
        int comp = 0;
        int a = 0, b = N-1;
        Arrays.sort(A);
        while (a < b) {
            int temp = A[a];
            A[a] = A[a] & A[b];
            A[b] = temp | A[b];
            a++;
            b--;            
        }
        for (int i=0; i<N; i++) {
            comp ^= A[i];
        }
        return comp;
    }
 }