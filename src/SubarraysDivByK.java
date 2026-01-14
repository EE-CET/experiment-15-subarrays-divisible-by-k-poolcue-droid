import java.util.*;

public class SubarraysDivByK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TODO: Read n and k
        int n = sc.nextInt();
        int k = sc.nextInt();

        // TODO: Read array elements
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // HashMap to store remainder frequencies
        HashMap<Integer, Integer> remainderCount = new HashMap<>();
        remainderCount.put(0, 1); // prefix sum divisible by k initially

        int prefixSum = 0;
        int count = 0;

        // TODO: Count subarrays with sum divisible by k
        for (int num : nums) {
            prefixSum += num;
            int remainder = prefixSum % k;

            // Handle negative remainder
            if (remainder < 0) {
                remainder += k;
            }

            if (remainderCount.containsKey(remainder)) {
                count += remainderCount.get(remainder);
            }

            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
        }

        // TODO: Print result
        System.out.println(count);
    }
}
