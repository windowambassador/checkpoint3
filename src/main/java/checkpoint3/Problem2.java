package checkpoint3;

import java.util.ArrayDeque;
import java.util.Queue;

public class Problem2 {

    public static int solve(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int sr = -1, sc = -1, tr = -1, tc = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'S') { sr = i; sc = j; }
                if (grid[i][j] == 'T') { tr = i; tc = j; }
            }
        }

        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = -1;
            }
        }

        dist[sr][sc] = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(sr * m + sc);

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            int r = curr / m;
            int c = curr % m;

            if (r == tr && c == tc) {
                return dist[r][c];
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m
                        && grid[nr][nc] != '#' && dist[nr][nc] == -1) {
                    dist[nr][nc] = dist[r][c] + 1;
                    queue.add(nr * m + nc);
                }
            }
        }
        return -1;
    }

    public static void run() {
        System.out.println("--- ЗАДАЧА 2: Кратчайший путь в лабиринте ---");
        
        char[][] grid = {
            {'S', '.', '.', '.', '.'},
            {'.', '#', '#', '#', '.'},
            {'.', '.', '.', '.', '.'},
            {'.', '#', '#', '#', '.'},
            {'.', '.', '.', '.', 'T'}
        };
        
        System.out.println("Вход: карта 5x5");
        for (char[] row : grid) {
            System.out.println("  " + new String(row));
        }
        
        int result = solve(grid);
        System.out.println("Выход: " + result);
        System.out.println();
    }
}