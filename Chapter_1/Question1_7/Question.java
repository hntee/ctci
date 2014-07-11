public class Question {
    public static void setZero(int[][] matrix) {
        if (matrix == null) return;

        int M = matrix.length;
        int N = matrix[0].length;

        // set two boolean arrays to record if the row/col is 0
        boolean[] row = new boolean[M];
        boolean[] col = new boolean[N];

        // iterate through the matrix
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        // iterate again to set the elements
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
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
        int[][] A = {{1, 2}, {0, 4}};
        int[][] B = {{0, 2, 3}, {4, 0, 6}, {7, 8, 9}};
        int[][] C = {{1, 2, 0, 4}, {4, 5, 6,10}, {7, 8, 9, 1}, {0, 8, 9, 6}};
        System.out.println("========================");
        System.out.println("before:");
        printMatrix(A, 2);
        System.out.println("after:");
        setZero(A);
        printMatrix(A, 2);

        System.out.println("========================");
        System.out.println("before:");
        printMatrix(B, 3);
        System.out.println("after:");
        setZero(B);
        printMatrix(B, 3);

        System.out.println("========================");
        System.out.println("before:");
        printMatrix(C, 4);
        System.out.println("after:");
        setZero(C);
        printMatrix(C, 4);
        System.out.println("========================");

    }
}