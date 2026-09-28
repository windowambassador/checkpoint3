package checkpoint3;

public class Problem3 {

    public static String solve(int n, int start, int[] next) {
        int slow = start;
        int fast = start;

        while (true) {
            if (next[slow] == -1) {
                return "NO";
            }
            slow = next[slow];

            if (next[fast] == -1) {
                return "NO";
            }
            fast = next[fast];
            if (next[fast] == -1) {
                return "NO";
            }
            fast = next[fast];

            if (slow == fast) {
                return "YES";
            }
        }
    }

    public static void run() {
        System.out.println("--- ЗАДАЧА 3: Обнаружение цикла ---");
        
        int n = 4;
        int start = 1;
        int[] next = {0, 2, 3, 4, 2};
        
        System.out.println("Вход: n=" + n + ", start=" + start + ", next=[2, 3, 4, 2]");
        String result = solve(n, start, next);
        System.out.println("Выход: " + result);
        System.out.println();
    }
}