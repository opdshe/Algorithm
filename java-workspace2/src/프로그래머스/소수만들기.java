package 프로그래머스;

public class 소수만들기 {
    static int answer = 0;
    public static void main(String[] args) {
        solution(new int[]{1,2,7,6,4});
    }
    public static int solution(int[] nums) {
        dfs(nums, 0, 0, 0 );
        System.out.println(answer);
        return answer;
    }
    private static void dfs(int[] nums, int idx, int count, int sum) {
        if(count == 3) {
            if(check(sum)){
                answer++;
            }
            return;
        }
        if(idx ==nums.length){
            return;
        }
        dfs(nums, idx+1, count+1, sum+nums[idx]);
        dfs(nums, idx+1, count, sum);
    }
    private static boolean check(int num) {
        for(int i = 2 ; i<num; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
