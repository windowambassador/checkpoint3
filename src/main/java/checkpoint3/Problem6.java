package checkpoint3;

public class Problem6 {

    public static int solve(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void run() {
        System.out.println("--- ЗАДАЧА 6: Поиск дубликата ---");
        
        int n = 4;
        int[] nums = {1, 3, 4, 2, 2};
        
        System.out.println("Вход: n=" + n + ", nums=[1, 3, 4, 2, 2]");
        int result = solve(nums);
        System.out.println("Выход: " + result);
        System.out.println();
    }
}