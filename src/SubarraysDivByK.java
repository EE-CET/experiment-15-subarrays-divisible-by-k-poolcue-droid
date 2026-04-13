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

        // Array to store remainder frequencies
        int[] remainderCount = new int[k];
        remainderCount[0] = 1; // prefix sum divisible by k

        int prefixSum = 0;
        int count = 0;

        // TODO: Count subarrays divisible by k
        for (int num : nums) {
            prefixSum += num;
            int remainder = prefixSum % k;

            // Handle negative remainder
            if (remainder < 0) {
                remainder += k;
            }

            count += remainderCount[remainder];
            remainderCount[remainder]++;
        }

        // TODO: Print result
        System.out.println(count);
    }
}
