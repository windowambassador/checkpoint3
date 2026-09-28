package checkpoint3;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Problem1 {

    public static int[] solve(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }
            answer[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return answer;
    }

    public static void run() {
        System.out.println("--- ЗАДАЧА 1: Следующая большая цена ---");

        int[] prices = {5, 2, 3, 1, 4};
        System.out.println("Вход: prices = " + Arrays.toString(prices));
        int[] result = solve(prices);
        System.out.println("Выход: " + Arrays.toString(result));
        System.out.println();
    }
}