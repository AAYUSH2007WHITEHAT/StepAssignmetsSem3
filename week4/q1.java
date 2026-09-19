package week4;
public class q1 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];


        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        int rightRunningProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= rightRunningProduct;
            rightRunningProduct *= nums[i];
        }

        return answer;
    }
}