package checkpoint3;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem4 {

    public static int solve(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] heights = new int[m];
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, maxRectangleInHistogram(heights));
        }
        return maxArea;
    }

    private static int maxRectangleInHistogram(int[] heights) {
        int m = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;

        for (int i = 0; i <= m; i++) {
            int h = (i == m) ? 0 : heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] > h) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }

    public static void run() {
        System.out.println("--- ЗАДАЧА 4: Максимальный прямоугольник из единиц ---");
        
        char[][] matrix = {
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'0', '1', '0', '1', '0'}
        };
        
        System.out.println("Вход: матрица 4x5");
        for (char[] row : matrix) {
            System.out.println("  " + new String(row));
        }
        
        int result = solve(matrix);
        System.out.println("Выход: " + result);
        System.out.println();
    }
}