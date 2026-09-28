package checkpoint3;

import java.util.ArrayDeque;
import java.util.Queue;

public class Problem5 {

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

        boolean[][][] visited = new boolean[n][m][1024];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{sr, sc, 0});
        visited[sr][sc][0] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int[] curr = queue.poll();
                int r = curr[0], c = curr[1], keys = curr[2];

                if (r == tr && c == tc) {
                    return steps;
                }

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;

                    char cell = grid[nr][nc];
                    if (cell == '#') continue;

                    int newKeys = keys;

                    if (cell >= 'a' && cell <= 'j') {
                        newKeys |= (1 << (cell - 'a'));
                    }
                    else if (cell >= 'A' && cell <= 'J') {
                        if ((keys & (1 << (cell - 'A'))) == 0) {
                            continue;
                        }
                    }

                    if (!visited[nr][nc][newKeys]) {
                        visited[nr][nc][newKeys] = true;
                        queue.add(new int[]{nr, nc, newKeys});
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    public static void run() {
        System.out.println("--- ЗАДАЧА 5: Путь с ключами и дверями ---");
        
        char[][] grid = {
            {'S', '.', '.', 'a', '.'},
            {'.', '#', 'A', '#', '.'},
            {'.', '.', '.', '.', '.'},
            {'.', '#', '.', '#', '.'},
            {'.', '.', '.', '.', 'T'}
        };
        
        System.out.println("Вход: карта 5x5 с ключом 'a' и дверью 'A'");
        for (char[] row : grid) {
            System.out.println("  " + new String(row));
        }
        
        int result = solve(grid);
        System.out.println("Выход: " + result);
        System.out.println();
    }
}