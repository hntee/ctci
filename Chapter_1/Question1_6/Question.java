public class Question {
    public static void rotate(int[][] matrix, int N) {
        if (N == 0 || N == 1) return;

        int start = 0;
        int end = N - 1;

        while (start < end) {
            for (int i = start; i < end; i++) {
                // save top
                int temp = matrix[start][i];
                // left -> top
                matrix[start][i] = matrix[start + end - i][start];
                // bottom -> left
                matrix[start + end - i][start] = matrix[end][start + end - i];
                // right -> bottom
                matrix[end][start + end - i] = matrix[i][end];
                // top -> right
                matrix[i][end] = temp;
            }
            start++;
            end--;
        }
    }

    public static void printMatrix(int[][] matrix, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf("%2d ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] A = {{1, 2}, {3, 4}};
        int[][] B = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] C = {{1, 2, 3, 4}, {4, 5, 6,10}, {7, 8, 9, 1}, {1, 8, 9, 6}};
        System.out.println("========================");
        System.out.println("before:");
        printMatrix(A, 2);
        System.out.println("after:");
        rotate(A, 2);
        printMatrix(A, 2);

        System.out.println("========================");
        System.out.println("before:");
        printMatrix(B, 3);
        System.out.println("after:");
        rotate(B, 3);
        printMatrix(B, 3);

        System.out.println("========================");
        System.out.println("before:");
        printMatrix(C, 4);
        System.out.println("after:");
        rotate(C, 4);
        printMatrix(C, 4);
        System.out.println("========================");

    }
}